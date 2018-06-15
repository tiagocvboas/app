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

    ResponseEntity read(Y id);
    ResponseEntity list();
    ResponseEntity create(T dto);
    ResponseEntity update(Y id, T dto);
    ResponseEntity delete(Y id);




}
