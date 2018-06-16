package pt.tiago.business.dto;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 */
public enum ErrorEnum {
    RESOURCE_NOT_FOUND("notfound"),
    INTERNAL_SERVER_ERROR("internal server error"),
    UNIQUE_IDENTIFIER_EXISTS("uuid"),
    BAD_REQUEST("Invalid request");

    private final String description;

    ErrorEnum(String uuid) {
        description = uuid;
    }


    public String description(){
        return description;
    }
}
