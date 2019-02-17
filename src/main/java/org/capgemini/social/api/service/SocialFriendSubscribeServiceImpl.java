/**
 * 
 */
package org.capgemini.social.api.service;

import java.util.List;

import org.capgemini.social.api.dto.ToggleFriendSubscribeDTO;
import org.capgemini.social.api.exception.DuplicateFriendSubscribeRequest;
import org.capgemini.social.api.exception.InvalidFriendRequestException;
import org.capgemini.social.api.model.SocialFriendSubscribe;
import org.capgemini.social.api.repository.SocialFriendSubscribeRepository;
import org.capgemini.social.api.util.SocialFriendValidationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ravi
 */
@Service
public class SocialFriendSubscribeServiceImpl implements SocialFriendSubscribeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SocialFriendSubscribeServiceImpl.class);
    @Autowired
    SocialFriendSubscribeRepository socialFrdSubscribeRepo;

    @Autowired
    SocialFriendValidationUtils socialFrdValidationUtils;

    @Override
    public void scubscribe(final ToggleFriendSubscribeDTO toggleSubscriptionDTO) {
        checkSubscriptionCondition(toggleSubscriptionDTO.getRequestor(), toggleSubscriptionDTO.getTarget());
        LOGGER.info("subscription detials {} {}", toggleSubscriptionDTO.getRequestor(), toggleSubscriptionDTO.getTarget());

    }

    /**
     * @param requestor
     * @param target This method checks the subscription criteria
     */
    private void checkSubscriptionCondition(final String requestor, final String target) {

        if (requestor == null || target == null) {
            LOGGER.info("InvalidFriendRequestException  checkSubscriptionCondition {} {}", requestor, target);
            throw new InvalidFriendRequestException("Invalid request : should have requestor and target");
        }

        socialFrdValidationUtils.validateFriendShipCriteria(requestor, target);

        List<String> targetSubscribers = socialFrdSubscribeRepo.fetchSubscribers(target);

        if (targetSubscribers.contains(requestor)) {
            LOGGER.info("DuplicateSubscriptionRequest checkSubscriptionCondition {} {}", requestor, target);
            throw new DuplicateFriendSubscribeRequest(requestor, target);
        }

        socialFrdSubscribeRepo.save(makeSubscription(requestor, target));
        LOGGER.info("checkSubscriptionCondition {} {}", requestor, target);

    }

    /**
     * @param requestor
     * @param target
     * @return SocialFriendSubscribe
     */
    private SocialFriendSubscribe makeSubscription(final String requestor, final String target) {
        return new SocialFriendSubscribe(requestor, target);
    }

}
