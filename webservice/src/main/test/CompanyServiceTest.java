import org.junit.FixMethodOrder;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pt.tiago.app.Application;
import pt.tiago.dto.CompanyDto;
import pt.tiago.service.CompanyService;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 */
@RunWith(SpringRunner.class)

@SpringBootTest(classes = Application.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CompanyServiceTest implements CrudTest {


    @Autowired
    private CompanyService companyService;


    @Override
    @Test
    public void test4Read() {
        CompanyDto companyDto = (CompanyDto) new CompanyDto().setName("primeiro").setId(1L);
        CompanyDto read = companyService.read(1L);
        assertEquals(read,companyDto);
    }

    @Override
    @Test
    public void test3List() {

        CompanyDto companyDto = (CompanyDto) new CompanyDto().setName("primeiro").setId(1L);
        CompanyDto read = companyService.read(1L);
        assertEquals(read,companyDto);
    }

    @Override
    @Test
    public void test1Create() {

        CompanyDto companyDto = (CompanyDto) new CompanyDto().setName("primeiro").setId(1L);
        CompanyDto read = companyService.read(1L);
        assertEquals(read,companyDto);
    }

    @Override
    @Test
    public void test2Update() {

        CompanyDto companyDto = (CompanyDto) new CompanyDto().setName("primeiro").setId(1L);
        CompanyDto read = companyService.read(1L);
        assertEquals(read,companyDto);
    }

    @Override
    @Test
    public void test5Delete() {

        CompanyDto companyDto = (CompanyDto) new CompanyDto().setName("primeiro").setId(1L);
        CompanyDto read = companyService.read(1L);
        assertEquals(read,companyDto);
    }
}
