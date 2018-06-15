package pt.tiago.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

/**
 * Interface for crud controllers
 * @param <T> the type of the DTO's primary key
 * @param <Y> the type of the DTO that is going to be persisted
 */
public interface CrudController<T ,Y> {

    ResponseEntity<T> read(Y id);
    ResponseEntity<Collection<T>> list();
    ResponseEntity<T> create(T dto);
    ResponseEntity<T> update(Y id, T dto);
    ResponseEntity<T> delete(Y id);




}
