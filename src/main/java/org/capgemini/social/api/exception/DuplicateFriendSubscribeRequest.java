package org.capgemini.social.api.exception;

import org.capgemini.social.api.util.SocialConstantUtil;

/**
 * @author Ravi
 * request contains duplicate subscription details
 */
public class DuplicateFriendSubscribeRequest extends BaseException {


    private static final long serialVersionUID = -3342487909681068263L;

    public DuplicateFriendSubscribeRequest(String requestor, String target) {
        super(" This person : " + requestor + " already subscribed for : " + target);
    }

    @Override
    public String getExceptionErrorCode() {
        return SocialConstantUtil.DUPLICATE_FRIEND_SUBSCRIPTION_ERROR_CODE;
    }
}
