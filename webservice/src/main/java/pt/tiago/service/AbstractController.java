package pt.tiago.service;

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
import pt.tiago.mapper.dto.AbstractBaseId;

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

    @Override
    @GetMapping(value = "/{id}/")
    public ResponseEntity<T> read(@PathVariable("id")Y id) {
        T t = getNewINInstance();
        t.setId(id);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }
    @Override
    @GetMapping(value = "/")
    public ResponseEntity<Collection<T>> list() {
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.OK);
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
            ;
        }

        return out;
    }

}
