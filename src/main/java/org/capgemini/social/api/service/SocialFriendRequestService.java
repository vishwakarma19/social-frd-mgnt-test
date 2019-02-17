/**
 * 
 */
package org.capgemini.social.api.service;

import java.util.List;

import org.capgemini.social.api.dto.InviteFriendDTO;
import org.capgemini.social.api.dto.SocialNotificationDTO;

/**
 * @author Ravi
 */
public interface SocialFriendRequestService {

    /**
     * @param to create friendship for two user
     */
    void makeNewFriends(final InviteFriendDTO invitationDTO);

    /**
     * @param email
     * @return List of Friends for given email
     */
    List<String> getAllMyFriends(final String email);

    /**
     * @param invitationDTO
     * @return List of common friends for given two user.
     */
    List<String> getCommonFriends(final InviteFriendDTO invitationDTO);

    /**
     * @param reciveUpdateDTO
     * @return List of user for notification.
     */
    List<String> getNotification(final SocialNotificationDTO reciveUpdateDTO);
}
