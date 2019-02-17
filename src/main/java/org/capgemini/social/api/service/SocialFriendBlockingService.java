package org.capgemini.social.api.service;

import org.capgemini.social.api.dto.ToggleFriendSubscribeDTO;

/**
 * @author Ravi
 *
 */
public interface SocialFriendBlockingService {

    /**
     * @param toggleFrdSubscribeDTO
     */
    void block(final ToggleFriendSubscribeDTO toggleFrdSubscribeDTO);
}
