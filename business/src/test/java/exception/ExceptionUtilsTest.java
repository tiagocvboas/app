package exception;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import pt.tiago.mapper.dto.ErrorEnum;
import pt.tiago.mapper.dto.ErrorStatus;
import pt.tiago.mapper.exception.AppRuntimeException;
import pt.tiago.mapper.exception.ConflictException;
import pt.tiago.mapper.exception.ExceptionUtils;
import pt.tiago.mapper.exception.NotFoundException;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 */
@RunWith(SpringRunner.class)
public class ExceptionUtilsTest {


    @Test
    public void testExceptionNotFound(){
        AppRuntimeException ex = new NotFoundException();
        ErrorStatus errorStatus = new ErrorStatus().setErrorEnum(ErrorEnum.RESOURCE_NOT_FOUND).setMessage(ErrorEnum.RESOURCE_NOT_FOUND.description());
        ResponseEntity body = ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorStatus);
        ResponseEntity handle = ExceptionUtils.handle(ex);
        assert handle.equals(body);
    }

    @Test
    public void testExceptionInternalServerError(){
        AppRuntimeException ex = new AppRuntimeException();
        ErrorStatus errorStatus = new ErrorStatus().setErrorEnum(ErrorEnum.INTERNAL_SERVER_ERROR).setMessage(ErrorEnum.INTERNAL_SERVER_ERROR.description());
        ResponseEntity body = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorStatus);
        ResponseEntity handle = ExceptionUtils.handle(ex);
        assert handle.equals(body);
    }

    @Test
    public void testUniqueIdentifierExists(){
        AppRuntimeException ex = new ConflictException();
        ErrorStatus errorStatus = new ErrorStatus().setErrorEnum(ErrorEnum.UNIQUE_IDENTIFIER_EXISTS).setMessage(ErrorEnum.UNIQUE_IDENTIFIER_EXISTS.description());
        ResponseEntity body = ResponseEntity.status(HttpStatus.CONFLICT).body(errorStatus);
        ResponseEntity handle = ExceptionUtils.handle(ex);
        assert handle.equals(body);
    }


}
