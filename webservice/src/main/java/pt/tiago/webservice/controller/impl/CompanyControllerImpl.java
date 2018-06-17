package pt.tiago.webservice.controller.impl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
import pt.tiago.business.dto.OwnerDto;
import pt.tiago.business.exception.AppRuntimeException;
import pt.tiago.data.entity.Owner;
import pt.tiago.webservice.controller.CompanyController;
import pt.tiago.business.dto.CompanyDto;
import pt.tiago.business.service.CompanyService;

import javax.validation.Valid;
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
    @GetMapping(value = "")
    @ApiOperation(value = "Lists all the companies",response = CompanyDto.class,responseContainer = "list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 500, message = "Something went very wrong")
    })
    public ResponseEntity<Collection<CompanyDto>> list() {
        return super.list();
    }

    @Override
    @GetMapping(value = "{id}")
    @ApiOperation(value = "Finds a company by id",response = CompanyDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Unable to found company of the give id"),
            @ApiResponse(code = 500, message = "Something went very wrong")
    })
    public ResponseEntity read(@PathVariable("id") Long id) {
        return super.read(id);
    }

    @Override
    @PostMapping(value = "")
    @ApiOperation(value = "Creates a company and returns the created company",response = CompanyDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success"),
            @ApiResponse(code = 500, message = "Something went very wrong")
    })
    public ResponseEntity<CompanyDto> create(@Valid CompanyDto dto) {
        return super.create(dto);
    }

    @Override
    @PutMapping(value = "{id}")
    @ApiOperation(value = "Updates a company with the given id ")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success"),
            @ApiResponse(code = 404, message = "Unable to found company of the give id"),
            @ApiResponse(code = 500, message = "Something went very wrong")
    })
    public ResponseEntity<CompanyDto> update(@PathVariable("id") Long id,@Valid CompanyDto dto) {
        return super.update(id, dto);
    }

    @Override
    @DeleteMapping(value = "{id}")
    @ApiOperation(value = "Deletes a company with the given id ")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success"),
            @ApiResponse(code = 404, message = "Unable to found company of the give id"),
            @ApiResponse(code = 500, message = "Something went very wrong")
    })
    public ResponseEntity<CompanyDto> delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }

    @Override
    @GetMapping(value = "{id}/owner")
    @ApiOperation(value = "Lists all the owners of the company with the given id",response = OwnerDto.class,responseContainer = "list")
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
    @PostMapping(value = "{id}/owner/")
    @ApiOperation(value = "Adds a new owner to the company with the given company and owner id", response = OwnerDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success"),
            @ApiResponse(code = 500, message = "Something went very wrong")
    })
    public ResponseEntity addNewOwner(@PathVariable("id") Long id, @RequestBody @Valid OwnerDto ownerDto) {
        OwnerDto createdOwner;
        try {
            CompanyService companyService = (CompanyService) crudService;
            createdOwner = companyService.addNewOwner(id,ownerDto);
            getLogger().info("listing resources from {}", this.getClass().getSimpleName());
        } catch (AppRuntimeException exception) {
            getLogger().warn("failed to execute service {} with id={} with exception {}",
                    this.getClass().getSimpleName(), exception.getClass().getSimpleName());
            return handle(exception);
        }
        return new ResponseEntity<>(createdOwner,HttpStatus.CREATED);
    }

    @Override
    @PutMapping(value = "{id}/owner/{ownerId}")
    @ApiOperation(value = "Adds a owner to the company with the given company and owner id")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success"),
            @ApiResponse(code = 404, message = "Unable to found company of the give id"),
            @ApiResponse(code = 500, message = "Something went very wrong")
    })
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
    @ApiOperation(value = "Removes a owner from the company with the given company and owner id")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success"),
            @ApiResponse(code = 404, message = "Unable to found company of the give id"),
            @ApiResponse(code = 500, message = "Something went very wrong")
    })
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
