package pt.tiago.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pt.tiago.business.dto.ErrorEnum;
import pt.tiago.business.dto.ErrorStatus;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 */
public class ExceptionUtils {

    /**
     * Takes an exception and mapps it to the httpStatus we want to return
     * @param exception The exception to handle
     * @return A ResponseEntity with an Error status as body
     */
    public static ResponseEntity handle(AppRuntimeException exception){

        if (exception instanceof NotFoundException){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorStatus().setErrorEnum(ErrorEnum.RESOURCE_NOT_FOUND).setMessage(ErrorEnum.RESOURCE_NOT_FOUND.description()));
        } else if (exception instanceof ConflictException){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorStatus().setErrorEnum(ErrorEnum.UNIQUE_IDENTIFIER_EXISTS).setMessage(ErrorEnum.UNIQUE_IDENTIFIER_EXISTS.description()));
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorStatus().setErrorEnum(ErrorEnum.INTERNAL_SERVER_ERROR).setMessage(ErrorEnum.INTERNAL_SERVER_ERROR.description()));
        }

    }
}
