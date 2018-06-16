package pt.tiago.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.tiago.controller.CrudController;
import pt.tiago.dto.CompanyDto;
import pt.tiago.dto.OwnerDto;
import pt.tiago.service.CompanyService;
import pt.tiago.service.OwnerService;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 */

@RestController
@RequestMapping(value = "api/owner")
public class OwnerController extends AbstractController<OwnerDto,Long> implements CrudController<OwnerDto,Long> {

    private final Logger logger = LoggerFactory.getLogger(OwnerController.class);


    @Autowired
    public OwnerController(OwnerService companyService) {
        super(companyService);
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }


}
