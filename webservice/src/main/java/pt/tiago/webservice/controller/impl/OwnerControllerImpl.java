package pt.tiago.webservice.controller.impl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.tiago.business.dto.OwnerDto;
import pt.tiago.business.service.OwnerService;
import pt.tiago.webservice.controller.OwnerController;

import javax.validation.Valid;
import java.util.Collection;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 * Implementation of the owner controller
 */

@RestController
@RequestMapping(value = "api/owner")
public class OwnerControllerImpl extends AbstractController<OwnerDto,Long> implements OwnerController {

    private final Logger logger = LoggerFactory.getLogger(OwnerControllerImpl.class);


    @Override
    @GetMapping(value = "")
    @ApiOperation(value = "Lists all the owners",response = OwnerDto.class,responseContainer = "list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 500, message = "Something went very wrong")
    })
    public ResponseEntity<Collection<OwnerDto>> list() {
        return super.list();
    }

    @Override
    @GetMapping(value = "{id}")
    @ApiOperation(value = "Finds a owner by id",response = OwnerDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Unable to found owner of the give id"),
            @ApiResponse(code = 500, message = "Something went very wrong")
    })
    public ResponseEntity read(@PathVariable("id") Long id) {
        return super.read(id);
    }

    @Override
    @PostMapping(value = "")
    @ApiOperation(value = "Creates a owner and returns the created owner",response = OwnerDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success"),
            @ApiResponse(code = 500, message = "Something went very wrong")
    })
    public ResponseEntity<OwnerDto> create(@Valid OwnerDto dto) {
        return super.create(dto);
    }

    @Override
    @PutMapping(value = "{id}")
    @ApiOperation(value = "Updates a owner with the given id ")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success"),
            @ApiResponse(code = 404, message = "Unable to found owner of the give id"),
            @ApiResponse(code = 500, message = "Something went very wrong")
    })
    public ResponseEntity<OwnerDto> update(@PathVariable("id") Long id,@Valid OwnerDto dto) {
        return super.update(id, dto);
    }

    @Override
    @DeleteMapping(value = "{id}")
    @ApiOperation(value = "Deletes a owner with the given id ")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success"),
            @ApiResponse(code = 404, message = "Unable to found owner of the give id"),
            @ApiResponse(code = 500, message = "Something went very wrong")
    })
    public ResponseEntity<OwnerDto> delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }
    
    
    @Autowired
    public OwnerControllerImpl(OwnerService ownerService) {
        super(ownerService);
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }


}
