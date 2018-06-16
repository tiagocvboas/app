package pt.tiago.webservice.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.tiago.business.dto.OwnerDto;
import pt.tiago.business.exception.AppRuntimeException;
import pt.tiago.webservice.controller.CompanyController;
import pt.tiago.business.dto.CompanyDto;
import pt.tiago.business.service.CompanyService;

import java.util.Collection;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 * Implementation of the company controller
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


    @Override
    @GetMapping(value = "{id}/owner")
    public ResponseEntity owners(@PathVariable("id")Long id) {
        Collection<OwnerDto> list;
        try {
            CompanyService companyService = (CompanyService) crudService;
            list = companyService.owners(id);
            getLogger().info("listing resources from {}", this.getClass().getSimpleName());
        } catch (AppRuntimeException exception) {
            getLogger().warn("failed to execute service {} with id={} with exception {}",
                    this.getClass().getSimpleName(), exception.getClass().getSimpleName());
            return handle(exception);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @Override
    @PutMapping(value = "{id}/owner/{ownerId}")
    public ResponseEntity addOwner(@PathVariable("id") Long id, @PathVariable("ownerId") Long ownerId) {
        try {
            CompanyService companyService = (CompanyService) crudService;
            companyService.addOwner(id,ownerId);
            getLogger().info("listing resources from {}", this.getClass().getSimpleName());
        } catch (AppRuntimeException exception) {
            getLogger().warn("failed to execute service {} with id={} with exception {}",
                    this.getClass().getSimpleName(), exception.getClass().getSimpleName());
            return handle(exception);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    @DeleteMapping(value = "{id}/owner/{ownerId}")
    public ResponseEntity removeOwner(@PathVariable("id") Long id, @PathVariable("ownerId") Long ownerId) {
        try {
            CompanyService companyService = (CompanyService) crudService;
            companyService.removeOwner(id,ownerId);
            getLogger().info("listing resources from {}", this.getClass().getSimpleName());
        } catch (AppRuntimeException exception) {
            getLogger().warn("failed to execute service {} with id={} with exception {}",
                    this.getClass().getSimpleName(), exception.getClass().getSimpleName());
            return handle(exception);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
