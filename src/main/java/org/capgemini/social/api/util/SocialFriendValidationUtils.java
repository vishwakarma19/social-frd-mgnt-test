/**
 * 
 */
package org.capgemini.social.api.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.capgemini.social.api.exception.EmailException;
import org.capgemini.social.api.exception.InvalidUserException;
import org.capgemini.social.api.exception.UserAvailabilityException;
import org.capgemini.social.api.repository.SocialUserProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Ravi
 *  Validation utility
 */
@Component
public class SocialFriendValidationUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(SocialFriendValidationUtils.class);

    @Autowired
    SocialUserProfileRepository userProfileRepo;

    /**
     * @param userOne
     * @param userTwo 
     * To specify the friendship criteria.
     */
    public void validateFriendShipCriteria(final String userOne, final String userTwo) {
        validateUser(userOne);
        validateUser(userTwo);

        if (userOne.equalsIgnoreCase(userTwo)) {
            throw new InvalidUserException("Invalid Request : Same users can not be friends again");
        }
        LOGGER.info("friendship validation {} {}", userOne, userTwo);
    }

    /**
     * @param user
     */
    public void validateUser(final String user) {
     
        if (!isValidEmail(user)) {
            LOGGER.info("InvalidEmailException validatePerson :: {}", user);
            throw new EmailException(user);
        }
        if (userProfileRepo.findById(user) == null) {
            LOGGER.info("UserDoesNotExistsException validatePerson :: {}", user);
            throw new UserAvailabilityException(user);
        }
        LOGGER.info("validatePerson {}", user);
    }

    /**
     * @param email
     */
    public List<String> extractMailsFromText(final String email) {
 
        Pattern pattern = Pattern.compile(SocialConstantUtil.EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        List<String> extractedEmails = new ArrayList<String>();
        while (matcher.find()) {
            extractedEmails.add(matcher.group());
        }
        LOGGER.info(" Mail from ticket {}", email);
        return extractedEmails;
    }

    /**
     * @param email
     * @return boolean
     */
    public boolean isValidEmail(final String email) {
        Pattern pattern = Pattern.compile(SocialConstantUtil.VALID_EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        boolean flag = matcher.matches();
        LOGGER.info("isValidEmail {}", email);
        return flag;
    }
}
