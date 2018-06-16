package pt.tiago.webservice.controller;

import org.springframework.stereotype.Component;

/**
 * Created by Tiago Vilas Boas on 16/06/2018.
 */
@Component
public class TempId {
    private Long id;

    public Long getId() {
        return id;
    }

    public TempId setId(Long id) {
        this.id = id;
        return this;
    }
}
