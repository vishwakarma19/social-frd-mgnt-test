/**
 * 
 */
package org.capgemini.social.api.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.capgemini.social.api.dto.InviteFriendDTO;
import org.capgemini.social.api.dto.SocialNotificationDTO;
import org.junit.Test;

/**
 * @author Ravi
 */
public class SocialFriendServiceTest {

    @Test
    public void testMyFriendList() {
	SocialFriendRequestServiceImpl friendServiceMock = mock(SocialFriendRequestServiceImpl.class);
        List<String> friendsList = Arrays.asList(new String[] {"vishwakarma@gmail.com", "sudhansu@gmail.com"});
        when(friendServiceMock.getAllMyFriends("ajay@gmail.com")).thenReturn(friendsList);
    }

    @Test
    public void testMakeFriendResquest() {
	SocialFriendRequestServiceImpl friendServiceMock = mock(SocialFriendRequestServiceImpl.class);
        final InviteFriendDTO invitationDTO = new InviteFriendDTO();
        doNothing().when(friendServiceMock).makeNewFriends(invitationDTO);
    }

    @Test
    public void testGetAllCommonFriends() {
        List<String> friendsList = Arrays.asList(new String[] {"vishwakarma@gmail.com", "sudhansu@gmail.com"});
        SocialFriendRequestServiceImpl friendServiceMock = mock(SocialFriendRequestServiceImpl.class);
        final InviteFriendDTO invitationDTO = new InviteFriendDTO();
        invitationDTO.setFriends(Arrays.asList(new String[] {"ajay@gmail.com", "rk@gmail.com"}));
        when(friendServiceMock.getCommonFriends(invitationDTO)).thenReturn(friendsList);
    }

    @Test
    public void testGetUpdates() {
	SocialFriendRequestServiceImpl friendServiceMock = mock(SocialFriendRequestServiceImpl.class);
        final SocialNotificationDTO reciveUpdateDTO = new SocialNotificationDTO();
        reciveUpdateDTO.setSender("vishwakarma@gmail.com");
        reciveUpdateDTO.setText("Hello ajay@gmail.com");
        when(friendServiceMock.getNotification(reciveUpdateDTO)).thenReturn(Arrays.asList(new String[] {"pqr@gmail.com", "xyz@gmail.com"}));

    }

}
