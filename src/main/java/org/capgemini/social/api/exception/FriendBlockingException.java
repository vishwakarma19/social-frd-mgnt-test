/**
 * 
 */
package org.capgemini.social.api.exception;

import org.capgemini.social.api.util.SocialConstantUtil;

/**
 * @author Ravi
 * 
 *  When friendship is not possible between two persons.
 */
public class FriendBlockingException extends BaseException {

    private static final long serialVersionUID = 5705634452701140244L;

    public FriendBlockingException(String message) {
        super(message);
    }

    public FriendBlockingException(String personOne, String personTwo) {
        super("Friendship not possible for the blocked user: " + personOne + " blocked " + personTwo);
    }

    @Override
    public String getExceptionErrorCode() {
        return SocialConstantUtil.FRIEND_BLOCKED_ERROR_CODE;
    }

}
