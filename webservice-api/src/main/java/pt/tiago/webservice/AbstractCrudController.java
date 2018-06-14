package pt.tiago.webservice;

import java.util.Collection;

/**
 * Created by Tiago Vilas Boas on 14/06/2018.
 */
public interface AbstractCrudController<T,Y> {

    T read(Y id);
    Collection<T> list();
    void creat();




}
