package org.capgemini.social.api.rest.endpoint.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.capgemini.social.api.dto.BaseResponseDTO;
import org.capgemini.social.api.dto.EmailDTO;
import org.capgemini.social.api.dto.SocialNotificationDTO;
import org.capgemini.social.api.dto.ToggleFriendSubscribeDTO;
import org.capgemini.social.api.rest.endpoint.SocialFriendsMgntEndPointController;
import org.capgemini.social.api.service.SocialFriendBlockingServiceImpl;
import org.capgemini.social.api.service.SocialFriendRequestServiceImpl;
import org.capgemini.social.api.service.SocialFriendSubscribeServiceImpl;
import org.capgemini.social.api.service.SocialUserProfileServiceImpl;
import org.junit.Test;
import org.junit.runner.JUnitCore;


/**
 * @author Ravi
 */
public class SocialFriendsMgntEndPointControllerTest {

    @Test
    public void SocialFriendsMgntEndPointControllerTest()
        throws Exception {
	SocialFriendsMgntEndPointController result = new SocialFriendsMgntEndPointController();
        assertNotNull(result);
    }

    @Test
    public void testMyFriendList()
        throws Exception {
	SocialFriendsMgntEndPointController restController = new SocialFriendsMgntEndPointController();
	restController.socialFriendRequestService = new SocialFriendRequestServiceImpl();
	restController.socialUserProfileService = new SocialUserProfileServiceImpl();
        restController.socialFriendBlockingService = new SocialFriendBlockingServiceImpl();
        restController.socialFriendSubService = new SocialFriendSubscribeServiceImpl();
       
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setEmail("vishwakarma@gmail.com");

        BaseResponseDTO result = restController.myFriendList(emailDTO);

        assertNotNull(result);
        assertEquals(false, result.isSuccess());
    }

    @Test
    public void testUserNotification()
        throws Exception {
	SocialFriendsMgntEndPointController restController = new SocialFriendsMgntEndPointController();
	restController.socialFriendRequestService = new SocialFriendRequestServiceImpl();
	restController.socialUserProfileService = new SocialUserProfileServiceImpl();
        restController.socialFriendBlockingService = new SocialFriendBlockingServiceImpl();
        restController.socialFriendSubService = new SocialFriendSubscribeServiceImpl();
       
        SocialNotificationDTO notifyUser = new SocialNotificationDTO();
        notifyUser.setSender("vishwakarma@gmail.com");
        notifyUser.setText("Hi , I have updated my status please check it sudhansu@gmail.com");
       
        BaseResponseDTO result = restController.userNotification(notifyUser);
        assertNotNull(result);
        assertEquals(false, result.isSuccess());
    }


    @Test
    public void testFriendBlock()
        throws Exception {
	SocialFriendsMgntEndPointController restController = new SocialFriendsMgntEndPointController();
	restController.socialFriendRequestService = new SocialFriendRequestServiceImpl();
	restController.socialUserProfileService = new SocialUserProfileServiceImpl();
        restController.socialFriendBlockingService = new SocialFriendBlockingServiceImpl();
        restController.socialFriendSubService = new SocialFriendSubscribeServiceImpl();
       
        ToggleFriendSubscribeDTO tsubsDTO = new ToggleFriendSubscribeDTO();
        tsubsDTO.setTarget("vishwakarma@gmail.com");
        tsubsDTO.setRequestor(" sudhansu@gmail.com");

        BaseResponseDTO result = restController.blockUnwantedFriend(tsubsDTO);

        assertNotNull(result);
        assertEquals(false, result.isSuccess());
    }
    @Test
    public void testUserSubscribe()
        throws Exception {
	SocialFriendsMgntEndPointController restController = new SocialFriendsMgntEndPointController();
	restController.socialFriendRequestService = new SocialFriendRequestServiceImpl();
	restController.socialUserProfileService = new SocialUserProfileServiceImpl();
        restController.socialFriendBlockingService = new SocialFriendBlockingServiceImpl();
        restController.socialFriendSubService = new SocialFriendSubscribeServiceImpl();
       
        ToggleFriendSubscribeDTO tsubsDTO = new ToggleFriendSubscribeDTO();
        tsubsDTO.setTarget("vishwakarma@gmail.com");
        tsubsDTO.setRequestor(" sudhansu@gmail.com");


        BaseResponseDTO result = restController.userSubscribe(tsubsDTO);

        assertNotNull(result);
        assertEquals(false, result.isSuccess());
    }

    public static void main(String[] args) {
        new JUnitCore().run(SocialFriendsMgntEndPointController.class);
    }
}