package pt.tiago.business.dto;

import java.util.Objects;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 */
public class ErrorStatus {

    private String message;
    private ErrorEnum errorEnum;

    public String getMessage() {
        return message;
    }

    public ErrorStatus setMessage(String message) {
        this.message = message;
        return this;
    }

    public ErrorEnum getErrorEnum() {
        return errorEnum;
    }

    public ErrorStatus setErrorEnum(ErrorEnum errorEnum) {
        this.errorEnum = errorEnum;
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorStatus that = (ErrorStatus) o;
        return Objects.equals(getMessage(), that.getMessage()) &&
                getErrorEnum() == that.getErrorEnum();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getMessage(), getErrorEnum());
    }

    @Override
    public String toString() {
        return "ErrorStatus{" +
                "message='" + message + '\'' +
                ", errorEnum=" + errorEnum +
                '}';
    }
}
