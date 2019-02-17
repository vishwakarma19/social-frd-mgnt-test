/**
 * 
 */
package org.capgemini.social.api.exception;

/**
 * @author Ravi
 *  Base Exception for the all
 */
public abstract class BaseException extends RuntimeException {


    private static final long serialVersionUID = -272761610295470586L;

    public BaseException(String message) {
        super(message);
    }

    public abstract String getExceptionErrorCode();

}
