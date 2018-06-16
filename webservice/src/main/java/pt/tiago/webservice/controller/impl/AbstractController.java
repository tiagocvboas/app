package pt.tiago.webservice.controller.impl;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pt.tiago.business.dto.AbstractBaseId;
import pt.tiago.business.dto.ErrorEnum;
import pt.tiago.business.dto.ErrorStatus;
import pt.tiago.business.exception.AppRuntimeException;
import pt.tiago.business.exception.ExceptionUtils;
import pt.tiago.business.service.CrudService;
import pt.tiago.webservice.controller.CrudController;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;
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

    protected CrudService<T,Y> crudService;

    protected abstract Logger getLogger();

    public AbstractController(CrudService<T, Y> crudService) {
        this.crudService = crudService;
    }


    @Override
    @GetMapping(value = "{id}")
    public ResponseEntity read(@PathVariable("id") Y id) {
        Optional<T> t;
        try {
            t = crudService.read(id);
            getLogger().info("read by id = {} from {}",id,this.getClass().getSimpleName());
        } catch (AppRuntimeException exception){
            getLogger().warn("failed to execute service {} with id={} with exception {}",
                    this.getClass().getSimpleName(),id,exception.getClass().getSimpleName());
            return handle(exception);
        }
        return t.isPresent()?new ResponseEntity<>(t.get(), HttpStatus.OK):ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorStatus().setErrorEnum(ErrorEnum.RESOURCE_NOT_FOUND).setMessage(ErrorEnum.RESOURCE_NOT_FOUND.description()));
    }


    @Override
    @GetMapping(value = "")
    public ResponseEntity<Collection<T>> list() {
        Collection<T> list;
        try {
            list = crudService.list();
            getLogger().info("listing resources from {}", this.getClass().getSimpleName());
        } catch (AppRuntimeException exception) {
            getLogger().warn("failed to execute service {} with id={} with exception {}",
                    this.getClass().getSimpleName(), exception.getClass().getSimpleName());
            return handle(exception);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @Override
    @PostMapping(value = "")
    public ResponseEntity<T> create(@Valid @RequestBody T dto) {
        T created;
        try {
            created = crudService.create(dto);
            getLogger().info("listing resources from {}", this.getClass().getSimpleName());
        } catch (AppRuntimeException exception) {
            getLogger().warn("failed to execute service {} with id={} with exception {}",
                    this.getClass().getSimpleName(), exception.getClass().getSimpleName());
            return handle(exception);
        }
        return new ResponseEntity<>(created,HttpStatus.CREATED);
    }

    @Override
    @PutMapping(value = "{id}")
    public ResponseEntity<T> update(@PathVariable("id") Y id,@RequestBody  T dto) {
        try {
            crudService.update(id,dto);
            getLogger().info("listing resources from {}", this.getClass().getSimpleName());
        } catch (AppRuntimeException exception) {
            getLogger().warn("failed to execute service {} with id={} with exception {}",
                    this.getClass().getSimpleName(), exception.getClass().getSimpleName());
            return handle(exception);
        }
        return ResponseEntity.noContent().build();
    }

    @Override
    @DeleteMapping(value = "{id}")
    public ResponseEntity<T> delete(@PathVariable("id") Y id) {
        try {
            crudService.delete(id);
            getLogger().info("listing resources from {}", this.getClass().getSimpleName());
        } catch (AppRuntimeException exception) {
            getLogger().warn("failed to execute service {} with id={} with exception {}",
                    this.getClass().getSimpleName(), exception.getClass().getSimpleName());
            return handle(exception);
        }
        return ResponseEntity.noContent().build();
    }


    /**
     * Handles the exceptions to return the respective http
     * @param exception an instance of AppRuntimeException or a class that extends it
     * @return
     */
    protected ResponseEntity handle(AppRuntimeException exception) {
        return ExceptionUtils.handle(exception);
    }

}
