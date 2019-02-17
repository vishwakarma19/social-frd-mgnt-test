package org.capgemini.social.api.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.capgemini.social.api.dto.InviteFriendDTO;
import org.capgemini.social.api.dto.SocialUpdateRecieveDTO;
import org.capgemini.social.api.exception.DuplicateFriendInvitaionException;
import org.capgemini.social.api.exception.FriendBlockingException;
import org.capgemini.social.api.exception.InvalidFriendRequestException;
import org.capgemini.social.api.model.SocialFriend;
import org.capgemini.social.api.repository.SocialFriendBlockRepository;
import org.capgemini.social.api.repository.SocialFriendRepository;
import org.capgemini.social.api.repository.SocialFriendSubscribeRepository;
import org.capgemini.social.api.repository.SocialUserProfileRepository;
import org.capgemini.social.api.util.SocialFriendValidationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ravi
 */
@Service
public class SocialFriendRequestServiceImpl implements SocialFriendRequestService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SocialFriendRequestServiceImpl.class);

	@Autowired
	SocialFriendRepository socialfriendRepo;

	@Autowired
	SocialFriendSubscribeRepository socialFrdSubscribeRepo;

	@Autowired
	SocialFriendBlockRepository socialFrdBlockRepo;

	@Autowired
	SocialUserProfileRepository SocialUserProfileRepo;
	
	@Autowired
	SocialFriendValidationUtils socialFrdValidateUtils;

	@Override
	public void makeNewFriends(final InviteFriendDTO invitationDTO) {
		LOGGER.info("making new friend {} {} ", invitationDTO.getFriends().get(0),
				invitationDTO.getFriends().get(1));
		socialfriendRepo.save(makeFriend(invitationDTO));
		
	}

	@Override
	public List<String> getAllMyFriends(final String email) {
		LOGGER.info(" getFriends {} ", email);
		if (null == email) {
			LOGGER.info("InvalidRequestException :: getFriends {} ", email);
			throw new InvalidFriendRequestException("Request doesnt contains email");
		}
		socialFrdValidateUtils.validateUser(email);
		List<String> friends = socialfriendRepo.fetchFriends(email);

		
		return friends;
	}

	
	@Override
	public List<String> getCommonFriends(InviteFriendDTO invitationDTO) {
		
		if (null == invitationDTO.getFriends() || invitationDTO.getFriends().size() != 2) {
			LOGGER.info("InvalidRequestException :: getCommonFriends {} {}", invitationDTO.getFriends().get(0),
					invitationDTO.getFriends().get(1));
			throw new InvalidFriendRequestException("Request doesnt contains friends or size of friends are not two");
		}
		List<String> commonFriends = getCommonFriends(invitationDTO.getFriends().get(0),
				invitationDTO.getFriends().get(1));
		LOGGER.info("End :: getCommonFriends {} {}", invitationDTO.getFriends().get(0), invitationDTO.getFriends().get(1));
		return commonFriends;
	}

	
	@Override
	public List<String> getNotification(SocialUpdateRecieveDTO reciveUpdateDTO) {
		
		if (null == reciveUpdateDTO.getSender() || null == reciveUpdateDTO.getText()) {
			LOGGER.info("InvalidFriendRequestException :: getUpdate {} {}", reciveUpdateDTO.getSender(),
					reciveUpdateDTO.getText());
			throw new InvalidFriendRequestException("Invalid request : Request doesnt contains sender or text or null");
		}

		socialFrdValidateUtils.validateUser(reciveUpdateDTO.getSender());

		List<String> senderFriends = socialfriendRepo.fetchFriends(reciveUpdateDTO.getSender());
		List<String> senderSubscribers = socialFrdSubscribeRepo.fetchSubscribers(reciveUpdateDTO.getSender());
		List<String> senderBlockers = socialFrdBlockRepo.fetchBlockers(reciveUpdateDTO.getSender());
		List<String> extractedMailsFromSenderText = extractMailsFromSenderText(reciveUpdateDTO.getText());

		List<String> recipentsList = buildRecipients(reciveUpdateDTO.getSender(), senderFriends, senderSubscribers,
				senderBlockers, extractedMailsFromSenderText);

		LOGGER.info(" getNotification {} {}", reciveUpdateDTO.getSender(), reciveUpdateDTO.getText());
		return recipentsList;

	}

	/**
	 * @param invitationDTO
	 * @return Friend
	 */
	private SocialFriend makeFriend(final InviteFriendDTO invitationDTO) {
		if (null == invitationDTO.getFriends() || invitationDTO.getFriends().size() != 2) {
			LOGGER.info("InvalidFriendRequestException :: makeFriend {} {} ", invitationDTO.getFriends().get(0),
					invitationDTO.getFriends().get(1));
			throw new InvalidFriendRequestException("Request doesnt contains friends or size of friends are not two");
		}

		String personOne = invitationDTO.getFriends().get(0);
		String personTwo = invitationDTO.getFriends().get(1);

		socialFrdValidateUtils.validateFriendShipCriteria(personOne, personTwo);

		List<String> personOneFriends = socialfriendRepo.fetchFriends(personOne);

		if (checkBothAreAlreadyFriends(personOneFriends, personTwo)) {
			LOGGER.info("DuplicateFriendInvitaionException createFriend {} {} ", invitationDTO.getFriends().get(0),
					invitationDTO.getFriends().get(1));
			throw new DuplicateFriendInvitaionException(personOne, personTwo);
		}

		List<String> blockersForPersonOne = socialFrdBlockRepo.fetchBlockers(personOne);
		if (blockersForPersonOne.contains(personTwo)) {
			LOGGER.info("FriendBlockingException makeFriend {} {} ", invitationDTO.getFriends().get(0),
					invitationDTO.getFriends().get(1));
			throw new FriendBlockingException(personOne, personTwo);
		}

		List<String> blockersForPersonTwo = socialFrdBlockRepo.fetchBlockers(personTwo);
		if (blockersForPersonTwo.contains(personOne)) {
			LOGGER.info("FriendBlockingException makeFriend {} {} ", invitationDTO.getFriends().get(0),
					invitationDTO.getFriends().get(1));
			throw new FriendBlockingException(personOne, personTwo);
		}

		LOGGER.info("makeFriend {} {} ", invitationDTO.getFriends().get(0), invitationDTO.getFriends().get(1));
		return new SocialFriend(personOne, personTwo);
	}

	/**
	 * @param personOneFriends
	 * @param personTwo
	 * @return boolean Checks a person is already friend with some one
	 */
	public boolean checkBothAreAlreadyFriends(final List<String> personOneFriends, final String personTwo) {
		return personOneFriends.contains(personTwo) ? true : false;
	}

	/**
	 * @param personOne
	 * @param personTwo
	 * @return List of common friends for given two persons.
	 */
	private List<String> getCommonFriends(final String personOne, final String personTwo) {
		LOGGER.info("getCommonFriends {} {} ", personOne, personTwo);
		List<String> commonFriends = new ArrayList<String>();
		socialFrdValidateUtils.validateFriendShipCriteria(personOne, personTwo);

		List<String> personOneFriends = socialfriendRepo.fetchFriends(personOne);
		List<String> personTwoFriends = socialfriendRepo.fetchFriends(personTwo);

		for (String person : personOneFriends) {
			if (personTwoFriends.contains(person)) {
				commonFriends.add(person);
			}
		}
		return commonFriends;

	}

	/**
	 * @param sender
	 * @param senderFriends
	 * @param senderSubscribers
	 * @param senderBlockers
	 * @param extractedMailsFromSenderText
	 * @return List of recipients
	 */
	private List<String> buildRecipients(final String sender, final List<String> senderFriends,
			final List<String> senderSubscribers, final List<String> senderBlockers,
			final List<String> extractedMailsFromSenderText) {
		LOGGER.info("buildRecipients {}", sender);
		Set<String> setOfRecipents = new HashSet<>();

		setOfRecipents.addAll(senderFriends);
		setOfRecipents.addAll(senderSubscribers);
		setOfRecipents.addAll(extractedMailsFromSenderText);
		setOfRecipents.removeAll(senderBlockers);
		setOfRecipents.remove(sender);

		List<String> recipents = new ArrayList<String>(setOfRecipents);
		return recipents;
	}

	/**
	 * @param text
	 * @return List of extracted email
	 */
	private List<String> extractMailsFromSenderText(final String text) {
		LOGGER.info("extractMailsFromSenderText {}", text);
		List<String> emailsInText = new ArrayList<String>();
		List<String> extractedEmails = socialFrdValidateUtils.extractMailsFromText(text);
		if (null != extractedEmails) {
			for (String extractedMail : extractedEmails) {
				if (null != SocialUserProfileRepo.findById(extractedMail)) {
					emailsInText.add(extractedMail);
				}
			}
		}
		return emailsInText;
	}

}
