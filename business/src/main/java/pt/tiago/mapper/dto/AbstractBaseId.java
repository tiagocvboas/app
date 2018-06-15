package pt.tiago.mapper.dto;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AbstractBaseId<?> that = (AbstractBaseId<?>) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getId());
    }
}
