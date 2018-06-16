package pt.tiago.controller;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pt.tiago.dto.AbstractBaseId;
import pt.tiago.exception.AppRuntimeException;
import pt.tiago.service.CrudService;
import pt.tiago.exception.ExceptionUtils;

import javax.validation.Valid;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
/**
 * Created by Tiago Vilas Boas on 14/06/2018.
 */

/**
 * Abstract generic controller
 * This class is meant to implement a default behaviour for rest CRUD operations
 * @param <T> the type of the DTO's primary key
 * @param <Y> the type of the DTO that is going to be persisted
 */
public abstract class AbstractController<T extends AbstractBaseId<Y>,Y extends Serializable> implements CrudController<T,Y> {


    protected abstract Logger getLogger();

    public abstract CrudService<T, Y> getCrudService();

    @Override
    @GetMapping(value = "/{id}/")
    public ResponseEntity read(@PathVariable("id")Y id) {
        T t = getNewINInstance();
        try {
            getCrudService().read(id);
            getLogger().info("read by id = {} from {}",id,this.getClass().getSimpleName());
        } catch (AppRuntimeException exception){
            getLogger().warn("failed to execute service {} with id={} with exception {}",
                    this.getClass().getSimpleName(),id,exception.getClass().getSimpleName());
            return handle(exception);
        }
        t.setId(id);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }


    @Override
    @GetMapping(value = "/")
    public ResponseEntity<Collection<T>> list() {
        Collection<T> list;
        try {
            list = getCrudService().list();
            getLogger().info("listing resources from {}", this.getClass().getSimpleName());
        } catch (AppRuntimeException exception) {
            getLogger().warn("failed to execute service {} with id={} with exception {}",
                    this.getClass().getSimpleName(), exception.getClass().getSimpleName());
            return handle(exception);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @Override
    @PostMapping(value = "/")
    public ResponseEntity<T> create(@Valid @RequestBody T dto) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        return new ResponseEntity<>(dto,headers,HttpStatus.CREATED);
    }

    @Override
    @PutMapping(value = "/{id}/")
    public ResponseEntity<T> update(@PathVariable("id") Y id,@RequestBody  T dto) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    @DeleteMapping(value = "/{id}/")
    public ResponseEntity<T> delete(@PathVariable("id")Y id) {
        return null;
    }


    protected T getNewINInstance() {
        Type t = this.getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType)t;
        Class<T> type = (Class)pt.getActualTypeArguments()[0];
        T out = null;

        try {
            out = type.newInstance();
        } catch (IllegalAccessException | InstantiationException ignored) {
        }

        return out;
    }


    private ResponseEntity handle(AppRuntimeException exception) {
        return ExceptionUtils.handle(exception);
    }

}
