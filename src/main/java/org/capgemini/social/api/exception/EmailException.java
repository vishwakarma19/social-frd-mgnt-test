/**
 * 
 */
package org.capgemini.social.api.exception;

import org.capgemini.social.api.util.SocialConstantUtil;

/**
 * @author Ravi
 * when the request contains Invalid email.
 */
public class EmailException extends BaseException {


    private static final long serialVersionUID = -7787553595462711156L;

    public EmailException(String email) {
        super("Invalid email :" + email);
    }

    @Override
    public String getExceptionErrorCode() {
        return SocialConstantUtil.INVALID_EMAIL_ERROR_CODE;
    }

}
