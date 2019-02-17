/**
 * 
 */
package org.capgemini.social.api.service;

import org.capgemini.social.api.dto.EmailDTO;
import org.capgemini.social.api.model.SocialUserProfile;

/**
 * @author Ravi
 *
 */
public interface SocialUserProfileService {

    /**
     * @param emailDTO
     * @return UserProfile
     */
    SocialUserProfile signUp(final EmailDTO emailDTO);


}
