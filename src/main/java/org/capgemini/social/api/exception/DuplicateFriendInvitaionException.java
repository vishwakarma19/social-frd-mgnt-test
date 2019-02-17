package org.capgemini.social.api.exception;

import org.capgemini.social.api.util.SocialConstantUtil;

/**
 * @author Ravi
 *   request contains duplicate invitation for friend request
 */
public class DuplicateFriendInvitaionException extends BaseException {

    private static final long serialVersionUID = -3566601960277815766L;

    public DuplicateFriendInvitaionException(String message) {
        super(message);
    }

    public DuplicateFriendInvitaionException(String userOne, String userTwo) {
        super("Invalid friend invitation exception  :" + userOne + " and " + userTwo + " already friends.");
    }

    @Override
    public String getExceptionErrorCode() {
        return SocialConstantUtil.DUPLICATE_FRIEND_INVITATION_ERROR_CODE;
    }

}
