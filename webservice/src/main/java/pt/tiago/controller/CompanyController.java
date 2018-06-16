package pt.tiago.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.tiago.dto.CompanyDto;
import pt.tiago.service.CompanyService;
import pt.tiago.service.CrudService;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 */

@RestController
@RequestMapping(value = "api/company")
public class CompanyController extends AbstractController<CompanyDto,Long> implements CrudController<CompanyDto,Long>  {

    private final Logger logger = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    private CompanyService companyService;

    @Override
    protected Logger getLogger() {
        return logger;
    }

    @Override
    public CrudService<CompanyDto, Long> getCrudService() {
        return companyService;
    }

}
