/**
 * 
 */
package org.capgemini.social.api.exception;

import org.capgemini.social.api.util.SocialConstantUtil;

/**
 * @author Ravi
 *  person is not valid.
 */
public class InvalidUserException extends BaseException {

    private static final long serialVersionUID = 6497944687817046025L;

    public InvalidUserException(String message) {
        super(message);
    }

    @Override
    public String getExceptionErrorCode() {
        return SocialConstantUtil.INVALID_USER_ERROR_CODE;
    }

}
