package pt.tiago.webservice.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pt.tiago.business.dto.CompanyDto;
import pt.tiago.business.dto.OwnerDto;

import javax.validation.Valid;

/**
 * Created by Tiago Vilas Boas on 16/06/2018.
 */
public interface CompanyController extends CrudController<CompanyDto,Long> {



    ResponseEntity owners(Long id);
    ResponseEntity addNewOwner(Long id, OwnerDto ownerDto);
    ResponseEntity addOwner(Long id, Long ownerId);

    ResponseEntity removeOwner(Long id, Long ownerId);


}
