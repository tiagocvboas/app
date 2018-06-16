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
import pt.tiago.business.dto.OwnerDto;
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
    private OwnerController ownedController;

    @Autowired
    TempId tempId;



    private CompanyDto company = new CompanyDto()
            .setAddress("Some street")
            .setCity("Some city")
            .setCountry("Some country")
            .setEmail("someemail@gmail.com")
            .setName("Some name")
            .setPhoneNumber("somephonenumber")
            ;

    @Override
    @Test
    public void test1Create() {


        ResponseEntity read = companyController.create(company);
        company = (CompanyDto) read.getBody();
        tempId.setCompanyId(company.getId());
        assertEquals( HttpStatus.CREATED,read.getStatusCode());
    }


    @Override
    @Test
    public void test2Update() {
        ResponseEntity read = companyController.update(tempId.getCompanyId(),company.setName("updated"));
        assertEquals( HttpStatus.NO_CONTENT,read.getStatusCode());
    }

    @Override
    @Test
    public void test4Read() {
        ResponseEntity read = companyController.read(tempId.getCompanyId());
        assertEquals( HttpStatus.OK,read.getStatusCode());
    }


    @Override
    @Test
    public void test8Delete() {
        ResponseEntity read = companyController.delete(tempId.getCompanyId());
        assertEquals( HttpStatus.NO_CONTENT,read.getStatusCode());
    }


    @Override
    @Test
    public void test7List() {

        ResponseEntity read = companyController.list();
        assertEquals( HttpStatus.OK,read.getStatusCode());
    }


    @Test
    public void test5addOwner() {
        ResponseEntity responseEntity = ownedController.create(new OwnerDto().setName("TEST_AUTO_OWNER").setTitle("TEST_AUTO_OWNER"));
        OwnerDto owner= (OwnerDto) responseEntity.getBody();
        tempId.setOwnerId(owner.getId());
        ResponseEntity read = companyController.addOwner(tempId.getCompanyId(),tempId.getOwnerId());
        assertEquals(HttpStatus.NO_CONTENT,read.getStatusCode());


    }

    @Test
    public void test6ListOwner() {
        ResponseEntity read = companyController.owners(tempId.getCompanyId());
        assertEquals( HttpStatus.OK,read.getStatusCode());
    }

    @Test
    public void test7DeleteOwner() {
        ResponseEntity read = companyController.removeOwner(tempId.getCompanyId(),tempId.getOwnerId());

        ownedController.delete(tempId.getOwnerId());
        assertEquals( HttpStatus.NO_CONTENT,read.getStatusCode());
    }


}
