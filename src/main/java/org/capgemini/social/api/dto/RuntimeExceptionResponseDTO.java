package org.capgemini.social.api.dto;

/**
 * @author Ravi
 */
public class RuntimeExceptionResponseDTO extends BaseResponseDTO {

    private String errorCode;
    private String message;

    public RuntimeExceptionResponseDTO(String errorCode, String message) {
        super(false);
        this.setErrorCode(errorCode);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}
