package org.capgemini.social.api.util;

/**
 * @author Ravi 
 *  Constants
 */
public interface SocialConstantUtil {

	 String UNKNOWN_ERROR_CODE = "500";

	  String UNKNOWN_ERROR_MESSAGE = "Unknown Error Cought";

	  String FRIEND_BLOCKED_ERROR_CODE = "30001";
	
	  String EMAIL_REGEX = "([a-z0-9_.-]+)@([a-z0-9_.-]+[a-z])";

	  String VALID_EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"; 
	
	  String INVALID_USER_ERROR_CODE = "30002";

	  String USER_DOES_NOT_EXISTS_ERROR_CODE = "30003";
	
	  String DUPLICATE_FRIEND_INVITATION_ERROR_CODE = "30004";

	  String INVALID_EMAIL_ERROR_CODE = "30005";

	  String INVALID_REQUEST_ERROR_CODE = "30006";

	  String DUPLICATE_FRIEND_SUBSCRIPTION_ERROR_CODE = "30007";
}
