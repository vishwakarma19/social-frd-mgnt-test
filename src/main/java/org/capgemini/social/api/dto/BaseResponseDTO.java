/**
 * 
 */
package org.capgemini.social.api.dto;

/**
 * @author Ravi
 */
public class BaseResponseDTO {

    private boolean success;

    public BaseResponseDTO(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
