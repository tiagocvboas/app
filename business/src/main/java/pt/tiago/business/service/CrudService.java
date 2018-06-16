package pt.tiago.business.service;

import pt.tiago.business.dto.AbstractBaseId;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 *
 * Interface for CrudServices, it offers all the crud operations
 *
 * @param <T> The type of the DTO class we want to make CRUD operation
 * @param <Y>
 */
public interface CrudService<T,Y> {
    /**
     * Finds an element by id
     * @param id the key to find
     * @return Either returns and Optional of the type of the CRUD service
     */
    Optional<T> read(Y id);

    /**
     * Simple list of all the elements of the service
     * @return Returns the collection of elements of the T dto
     */
    Collection<T> list();

    /**
     * Creates an element of the T dto
     * @param dto the DTO to persist
     * @return Returns the created DTO, with the generated fields if applicable
     */
    T create(T dto);

    /**
     * Updates a DTO
     * @param id The id of the dto we want to update
     * @param dto The DTO itself to update
     */
    void update(Y id, T dto);

    /**
     * Deletes a DTO
     * @param id The id of the dto we want to delete
     */
    void delete(Y id);

}
