package org.capgemini.social.api.rest.endpoint;

import java.util.List;

import javax.validation.Valid;

import org.capgemini.social.api.dto.BaseResponseDTO;
import org.capgemini.social.api.dto.EmailDTO;
import org.capgemini.social.api.dto.FriendsResponseDTO;
import org.capgemini.social.api.dto.InviteFriendDTO;
import org.capgemini.social.api.dto.SocialNotificationDTO;
import org.capgemini.social.api.dto.ReceiverUpdateResponseDTO;
import org.capgemini.social.api.dto.RuntimeExceptionResponseDTO;
import org.capgemini.social.api.dto.SuccessResponseDTO;
import org.capgemini.social.api.dto.ToggleFriendSubscribeDTO;
import org.capgemini.social.api.exception.BaseException;
import org.capgemini.social.api.service.SocialFriendBlockingService;
import org.capgemini.social.api.service.SocialFriendRequestService;
import org.capgemini.social.api.service.SocialFriendSubscribeService;
import org.capgemini.social.api.service.SocialUserProfileService;
import org.capgemini.social.api.util.SocialConstantUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ravi
 */
@RestController
@RequestMapping("/social/*")
public class SocialFriendsMgntEndPointController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SocialFriendsMgntEndPointController.class);

    @Autowired
   public SocialUserProfileService socialUserProfileService;

    @Autowired
    public  SocialFriendRequestService socialFriendRequestService;

    @Autowired
    public SocialFriendBlockingService socialFriendBlockingService;

    @Autowired
    public SocialFriendSubscribeService socialFriendSubService;

    @PostMapping("/logon")
    public BaseResponseDTO logOn(@Valid @RequestBody EmailDTO emailDTO) {
	socialUserProfileService.signUp(emailDTO);
	return new SuccessResponseDTO();
    }

    /**
     * @param invitationDTO
     * @return BaseResponseDTO
     */
    @PostMapping("/makeFriendRequest")
    public BaseResponseDTO makeFriendship(@Valid @RequestBody InviteFriendDTO invitationDTO) {
	try {
	    LOGGER.info("makeFriendRequest  {} {}", invitationDTO.getFriends().get(0),
		    invitationDTO.getFriends().get(1));
	    socialFriendRequestService.makeNewFriends(invitationDTO);
	} catch (BaseException baseException) {
	    LOGGER.error("Exception in makeFriendRequest {} {}", invitationDTO.getFriends().get(0),
		    invitationDTO.getFriends().get(1));
	    return new RuntimeExceptionResponseDTO(baseException.getExceptionErrorCode(), baseException.getMessage());
	} catch (Exception exception) {
	    LOGGER.error("Exception in makefriendship {} {}", invitationDTO.getFriends().get(0),
		    invitationDTO.getFriends().get(1));
	    return new RuntimeExceptionResponseDTO(SocialConstantUtil.UNKNOWN_ERROR_CODE,
		    SocialConstantUtil.UNKNOWN_ERROR_MESSAGE);
	}
	LOGGER.info("makeFriendRequest  {} {}", invitationDTO.getFriends().get(0), invitationDTO.getFriends().get(1));
	return new SuccessResponseDTO();
    }

    /**
     * @param emailDTO
     * @return BaseResponseDTO
     */
    @PostMapping("/myfriendlist")
    public BaseResponseDTO myFriendList(@Valid @RequestBody EmailDTO emailDTO) {
	List<String> friendsList = null;
	try {
	    LOGGER.info("myFriendList ", emailDTO.getEmail());
	    friendsList = socialFriendRequestService.getAllMyFriends(emailDTO.getEmail());
	} catch (BaseException baseException) {
	    LOGGER.info("Exception myFriendList ", emailDTO.getEmail());
	    return new RuntimeExceptionResponseDTO(baseException.getExceptionErrorCode(), baseException.getMessage());
	} catch (Exception exception) {
	    LOGGER.error("Exception myFriendList ", emailDTO.getEmail());
	    return new RuntimeExceptionResponseDTO(SocialConstantUtil.UNKNOWN_ERROR_CODE,
		    SocialConstantUtil.UNKNOWN_ERROR_MESSAGE);
	}

	return new FriendsResponseDTO(friendsList);
    }

    /**
     * @param invitationDTO
     * @return BaseResponseDTO
     */
    @PostMapping("/commonfriends")
    public BaseResponseDTO getCommonFriends(@Valid @RequestBody InviteFriendDTO invitationDTO) {
	List<String> commonFriendsList = null;
	try {
	    LOGGER.info("getCommonFriends {} {}", invitationDTO.getFriends().get(0), invitationDTO.getFriends().get(1));
	    commonFriendsList = socialFriendRequestService.getCommonFriends(invitationDTO);
	} catch (BaseException baseException) {
	    LOGGER.error("Base Exception getCommonFriends {} {}", invitationDTO.getFriends().get(0),
		    invitationDTO.getFriends().get(1));
	    return new RuntimeExceptionResponseDTO(baseException.getExceptionErrorCode(), baseException.getMessage());
	} catch (Exception exception) {
	    LOGGER.error("Exception getCommonFriends {} {}", invitationDTO.getFriends().get(0),
		    invitationDTO.getFriends().get(1));
	    return new RuntimeExceptionResponseDTO(SocialConstantUtil.UNKNOWN_ERROR_CODE,
		    SocialConstantUtil.UNKNOWN_ERROR_MESSAGE);
	}

	return new FriendsResponseDTO(commonFriendsList);
    }

    /**
     * @param togleSubsDTO
     * @return BaseResponseDTO
     */
    @PostMapping("/usersubscribe")
    public BaseResponseDTO userSubscribe(@Valid @RequestBody ToggleFriendSubscribeDTO togleSubsDTO) {

	try {
	    LOGGER.info("subscribe {} {}", togleSubsDTO.getRequestor(), togleSubsDTO.getTarget());
	    socialFriendSubService.scubscribe(togleSubsDTO);
	} catch (BaseException baseException) {
	    LOGGER.debug("Base Exception subscribe {} {}", togleSubsDTO.getRequestor(), togleSubsDTO.getTarget());
	    return new RuntimeExceptionResponseDTO(baseException.getExceptionErrorCode(), baseException.getMessage());
	} catch (Exception exception) {
	    LOGGER.error("Exception subscribe {} {}", togleSubsDTO.getRequestor(), togleSubsDTO.getTarget());
	    return new RuntimeExceptionResponseDTO(SocialConstantUtil.UNKNOWN_ERROR_CODE,
		    SocialConstantUtil.UNKNOWN_ERROR_MESSAGE);
	}

	return new SuccessResponseDTO();
    }

    /**
     * @param toggleSubscriptionDTO
     * @return BaseResponseDTO
     */
    @PostMapping("/blockfriend")
    public BaseResponseDTO blockUnwantedFriend(@Valid @RequestBody ToggleFriendSubscribeDTO toggleSubscriptionDTO) {

	try {
	    LOGGER.info("block your friend {} {}", toggleSubscriptionDTO.getRequestor(),
		    toggleSubscriptionDTO.getTarget());
	    socialFriendBlockingService.block(toggleSubscriptionDTO);

	} catch (BaseException baseException) {
	    LOGGER.info("Base Exception in block friend{} {}", toggleSubscriptionDTO.getRequestor(),
		    toggleSubscriptionDTO.getTarget());
	    return new RuntimeExceptionResponseDTO(baseException.getExceptionErrorCode(), baseException.getMessage());
	} catch (Exception exception) {
	    LOGGER.error("Exception in block friend {} {}", toggleSubscriptionDTO.getRequestor(),
		    toggleSubscriptionDTO.getTarget());
	    return new RuntimeExceptionResponseDTO(SocialConstantUtil.UNKNOWN_ERROR_CODE,
		    SocialConstantUtil.UNKNOWN_ERROR_MESSAGE);
	}

	return new SuccessResponseDTO();
    }

    /**
     * @param nofifyUserDTO - To update the subscribed and friend
     * @return BaseResponseDTO
     */
    @PostMapping("/notifyuser")
    public BaseResponseDTO userNotification(@Valid @RequestBody SocialNotificationDTO nofifyUserDTO) {
	List<String> recipentList = null;
	try {
	    LOGGER.info("userNotification {} {}", nofifyUserDTO.getSender(), nofifyUserDTO.getText());
	    recipentList = socialFriendRequestService.getNotification(nofifyUserDTO);
	} catch (BaseException baseException) {
	    LOGGER.info("BaseException userNotification{} {}", nofifyUserDTO.getSender(), nofifyUserDTO.getText());
	    return new RuntimeExceptionResponseDTO(baseException.getExceptionErrorCode(), baseException.getMessage());
	} catch (Exception exception) {
	    LOGGER.error("Exception userNotification {} {}", nofifyUserDTO.getSender(), nofifyUserDTO.getText());
	    return new RuntimeExceptionResponseDTO(SocialConstantUtil.UNKNOWN_ERROR_CODE,
		    SocialConstantUtil.UNKNOWN_ERROR_MESSAGE);
	}
	return new ReceiverUpdateResponseDTO(recipentList);
    }

}
