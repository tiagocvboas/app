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
import pt.tiago.business.dto.CompanyDto;

import static org.junit.Assert.*;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CompanyControllerTest implements CrudTest {


    @Autowired
    private CompanyController companyController;
    @Autowired
    TempId tempId;

    private CompanyDto company = new CompanyDto()
            .setAddress("Some street")
            .setCity("Some city")
            .setCountry("Some country")
            .setEmail("someemail@gmail.com")
            .setName("Some name")
            .setPhoneNumber("somephonenumber")
            .setCompanyIdentifier("TIAGO")
            ;

    @Override
    @Test
    public void test1Create() {


        ResponseEntity read = companyController.create(company);
        company = (CompanyDto) read.getBody();
        tempId.setId(company.getId());
        assertEquals(read.getStatusCode(), HttpStatus.CREATED);
    }


    @Override
    @Test
    public void test2Update() {
        ResponseEntity read = companyController.update(tempId.getId(),company.setName("updated"));
        assertEquals(read.getStatusCode(), HttpStatus.NO_CONTENT);
    }

    @Override
    @Test
    public void test4Read() {
        ResponseEntity read = companyController.read(tempId.getId());
        assertEquals(read.getStatusCode(), HttpStatus.OK);
    }


    @Override
    @Test
    public void test5Delete() {
        ResponseEntity read = companyController.delete(tempId.getId());
        assertEquals(read.getStatusCode(), HttpStatus.NO_CONTENT);
    }


    @Override
    @Test
    public void test7List() {

        ResponseEntity read = companyController.list();
        assertEquals(read.getStatusCode(), HttpStatus.OK);
    }

}
