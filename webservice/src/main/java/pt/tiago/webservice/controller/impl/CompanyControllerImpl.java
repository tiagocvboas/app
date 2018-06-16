package pt.tiago.webservice.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.tiago.webservice.controller.CompanyController;
import pt.tiago.business.dto.CompanyDto;
import pt.tiago.business.service.CompanyService;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 */

@RestController
@RequestMapping(value = "api/company")
public class CompanyControllerImpl extends AbstractController<CompanyDto,Long> implements CompanyController {

    private final Logger logger = LoggerFactory.getLogger(CompanyControllerImpl.class);


    @Autowired
    public CompanyControllerImpl(CompanyService companyService) {
        super(companyService);
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }


}
