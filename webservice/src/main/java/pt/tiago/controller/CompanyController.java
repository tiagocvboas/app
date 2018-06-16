package pt.tiago.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.tiago.constant.Constant;
import pt.tiago.dto.CompanyDto;
import pt.tiago.service.CompanyService;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 */

@RestController
@RequestMapping(value = Constant.CONTEXT_PATH_PREFIX + "company")
public class CompanyController extends AbstractController<CompanyDto,Long> implements CrudController<CompanyDto,Long>  {

    private final Logger logger = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    public CompanyController(CompanyService crudService) {
        super(crudService);
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }
}