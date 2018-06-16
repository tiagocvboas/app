package pt.tiago.webservice.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.tiago.webservice.controller.OwnerController;
import pt.tiago.business.dto.OwnerDto;
import pt.tiago.business.service.OwnerService;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 * Implementation of the owner controller
 */

@RestController
@RequestMapping(value = "api/owner")
public class OwnerControllerImpl extends AbstractController<OwnerDto,Long> implements OwnerController {

    private final Logger logger = LoggerFactory.getLogger(OwnerControllerImpl.class);


    @Autowired
    public OwnerControllerImpl(OwnerService companyService) {
        super(companyService);
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }


}
