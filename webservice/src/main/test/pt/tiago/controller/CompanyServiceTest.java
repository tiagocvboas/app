package pt.tiago.controller;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import pt.tiago.app.Application;
import pt.tiago.controller.impl.CompanyController;
import pt.tiago.dto.CompanyDto;
import pt.tiago.service.CompanyService;

import static org.junit.Assert.*;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CompanyServiceTest implements CrudTest {


    @Autowired
    private CompanyController companyService;


    @Override
    @Test
    public void test4Read() {
        ResponseEntity read = companyService.read(1L);
        assertEquals(read.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Override
    @Test
    public void test3List() {

        ResponseEntity read = companyService.read(1L);
        assertEquals(read.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Override
    @Test
    public void test1Create() {

        ResponseEntity read = companyService.read(1L);
        assertEquals(read.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Override
    @Test
    public void test2Update() {
        ResponseEntity read = companyService.read(1L);
        assertEquals(read.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Override
    @Test
    public void test5Delete() {
        ResponseEntity read = companyService.read(1L);
        assertEquals(read.getStatusCode(), HttpStatus.NOT_FOUND);
    }
}
