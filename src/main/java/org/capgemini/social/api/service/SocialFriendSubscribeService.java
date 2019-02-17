/**
 * 
 */
package org.capgemini.social.api.service;

import org.capgemini.social.api.dto.ToggleFriendSubscribeDTO;

/**
 * @author Ravi
 *
 */
public interface SocialFriendSubscribeService {

    /**
     * @param toggleSubscriptionDTO
     */
    void scubscribe(final ToggleFriendSubscribeDTO toggleSubscriptionDTO);

}
