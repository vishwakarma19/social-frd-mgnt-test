package org.capgemini.social.api.util;

/**
 * @author Ravi Application Constants
 */
public class SocialConstantUtil {

	

	public static final String UNKNOWN_ERROR_CODE = "500";

	public static final String UNKNOWN_ERROR_MESSAGE = "Unknown Error Cought";

	public static final String FRIEND_BLOCKED_ERROR_CODE = "30001";
	
	public static final String EMAIL_REGEX = "([a-z0-9_.-]+)@([a-z0-9_.-]+[a-z])";

	public static final String VALID_EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"; 
	
	public static final String INVALID_USER_ERROR_CODE = "30002";

	public static final String USER_DOES_NOT_EXISTS_ERROR_CODE = "30003";
	
	public static final String DUPLICATE_FRIEND_INVITATION_ERROR_CODE = "30004";

	public static final String INVALID_EMAIL_ERROR_CODE = "30005";

	public static final String INVALID_REQUEST_ERROR_CODE = "30006";

	public static final String DUPLICATE_FRIEND_SUBSCRIPTION_ERROR_CODE = "30007";
}
