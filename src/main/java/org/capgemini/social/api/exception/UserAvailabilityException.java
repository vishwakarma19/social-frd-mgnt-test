package org.capgemini.social.api.exception;

import org.capgemini.social.api.util.SocialConstantUtil;

/**
 * @author Ravi
 * when the person is not found in the database.
 */
public class UserAvailabilityException extends BaseException {

    private static final long serialVersionUID = 5570113963372118063L;

    public UserAvailabilityException(String message) {
        super("User does not exit : " + message);
    }

    @Override
    public String getExceptionErrorCode() {
        return SocialConstantUtil.USER_DOES_NOT_EXISTS_ERROR_CODE;
    }

}
