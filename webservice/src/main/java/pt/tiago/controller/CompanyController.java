package pt.tiago.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
public class CompanyController  {

    private final Logger logger = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    private CompanyService companyService;


    @GetMapping(value = "/{id}/")
    public ResponseEntity read(@PathVariable("id")Long id) {
        return new ResponseEntity(companyService.read(id),HttpStatus.OK);
    }

    @GetMapping(value = "/")
    public ResponseEntity<Collection<CompanyDto>> list() {
        return new ResponseEntity(companyService.list(),HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<CompanyDto> create(@Valid @RequestBody CompanyDto dto) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(value = "/{id}/")
    public ResponseEntity<CompanyDto> update(@PathVariable("id")Long id,@Valid @RequestBody CompanyDto dto) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}/")
    public ResponseEntity<CompanyDto> delete(@PathVariable("id")Long id) {
        return new ResponseEntity(HttpStatus.OK);
    }

    protected Logger getLogger() {
        return logger;
    }

    public CrudService<CompanyDto, Long> getCrudService() {
        return companyService;
    }

}
