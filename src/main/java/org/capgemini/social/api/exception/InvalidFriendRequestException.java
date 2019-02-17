/**
 * 
 */
package org.capgemini.social.api.exception;

import org.capgemini.social.api.util.SocialConstantUtil;

/**
 * @author Ravi
 * 
 *  when the request contains invalid data
 */
public class InvalidFriendRequestException extends BaseException {

    private static final long serialVersionUID = -4058741024665851134L;

    public InvalidFriendRequestException(String message) {
        super("Invalid Freind Request exception: " + message);
    }

    @Override
    public String getExceptionErrorCode() {
        return SocialConstantUtil.INVALID_REQUEST_ERROR_CODE;
    }


}
