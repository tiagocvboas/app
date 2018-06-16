package pt.tiago.webservice.controller;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import pt.tiago.webservice.app.Application;
import pt.tiago.business.dto.OwnerDto;

import static org.junit.Assert.assertEquals;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OwnerControllerTest implements CrudTest {


    @Autowired
    private OwnerController ownerController;
    @Autowired
    TempId tempId;

    private OwnerDto ownerDto = new OwnerDto()
            .setName("Owner name")
            .setTitle("Owner title")
            ;

    @Override
    @Test
    public void test1Create() {
        ResponseEntity read = ownerController.create(ownerDto);
        ownerDto = (OwnerDto) read.getBody();
        tempId.setId(ownerDto.getId());
        assertEquals(read.getStatusCode(), HttpStatus.CREATED);
    }


    @Override
    @Test
    public void test2Update() {
        ResponseEntity read = ownerController.update(tempId.getId(), ownerDto.setName("updated name"));
        assertEquals(read.getStatusCode(), HttpStatus.NO_CONTENT);
    }

    @Override
    @Test
    public void test4Read() {
        ResponseEntity read = ownerController.read(tempId.getId());
        assertEquals(read.getStatusCode(), HttpStatus.OK);
    }


    @Override
    @Test
    public void test5Delete() {
        ResponseEntity read = ownerController.delete(tempId.getId());
        assertEquals(read.getStatusCode(), HttpStatus.NO_CONTENT);
    }


    @Override
    @Test
    public void test7List() {

        ResponseEntity read = ownerController.list();
        assertEquals(read.getStatusCode(), HttpStatus.OK);
    }

}
