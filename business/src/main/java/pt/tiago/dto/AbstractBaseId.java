package pt.tiago.dto;

import java.util.Objects;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 */
public abstract class AbstractBaseId<T> {

    private T id;


    public T getId() {
        return id;
    }

    public AbstractBaseId<T> setId(T id) {
        this.id = id;
        return this;
    }
}
