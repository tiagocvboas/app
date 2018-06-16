package pt.tiago.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.tiago.constant.Constant;
import pt.tiago.dto.CompanyDto;
import pt.tiago.service.CompanyService;
import pt.tiago.service.CrudService;

import javax.validation.Valid;
import java.util.Collection;

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
    @GetMapping(value = "/{id}/")
    public ResponseEntity read(@PathVariable("id")Long id) {
        return super.read(id);
    }

    @Override
    @GetMapping(value = "/")
    public ResponseEntity<Collection<CompanyDto>> list() {
        return super.list();
    }

    @Override
    @PostMapping(value = "/")
    public ResponseEntity<CompanyDto> create(@Valid @RequestBody CompanyDto dto) {
        return super.create(dto);
    }

    @Override
    @PutMapping(value = "/{id}/")
    public ResponseEntity<CompanyDto> update(@PathVariable("id")Long id,@Valid @RequestBody CompanyDto dto) {
        return super.update(id, dto);
    }

    @Override
    @DeleteMapping(value = "/{id}/")
    public ResponseEntity<CompanyDto> delete(@PathVariable("id")Long id) {
        return super.delete(id);
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }

    @Override
    public CrudService<CompanyDto, Long> getCrudService() {
        return companyService;
    }

}
