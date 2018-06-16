package pt.tiago.webservice.controller;

import org.springframework.stereotype.Component;

/**
 * Created by Tiago Vilas Boas on 16/06/2018.
 */
@Component
public class TempId {
    private Long companyId;
    private Long ownerId;

    public Long getCompanyId() {
        return companyId;
    }

    public TempId setCompanyId(Long companyId) {
        this.companyId = companyId;
        return this;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public TempId setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
        return this;
    }
}
