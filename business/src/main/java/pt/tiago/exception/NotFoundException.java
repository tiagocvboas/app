package pt.tiago.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends AppRuntimeException {
}
