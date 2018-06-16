package pt.tiago.business.mapper;

import org.springframework.stereotype.Component;

/**
 * Created by Tiago Vilas Boas on 16/06/2018.
 */
@Component
public abstract class IdentityMapper<T> implements Mapper<T,T> {
    @Override
    public T map(T t) {
        return t;
    }
}
