package pt.tiago.service;

import pt.tiago.dto.AbstractBaseId;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 */
public interface CrudService<T extends AbstractBaseId<Y>,Y> {


    Optional<T> read(Y id);
    Collection<T> list();
    T create(T dto);
    T update(Y id, T dto);
    T delete(Y id);

}
