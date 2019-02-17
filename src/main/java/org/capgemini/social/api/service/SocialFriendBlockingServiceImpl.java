package org.capgemini.social.api.service;

import java.util.List;

import org.capgemini.social.api.dto.ToggleFriendSubscribeDTO;
import org.capgemini.social.api.exception.FriendBlockingException;
import org.capgemini.social.api.exception.InvalidFriendRequestException;
import org.capgemini.social.api.model.SocialFriendBlock;
import org.capgemini.social.api.repository.SocialFriendBlockRepository;
import org.capgemini.social.api.util.SocialFriendValidationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Block;
import org.springframework.stereotype.Service;

/**
 * @author Ravi
 */
@Service
public class SocialFriendBlockingServiceImpl implements SocialFriendBlockingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SocialFriendBlockingServiceImpl.class);
    @Autowired
    SocialFriendValidationUtils socialFrdValidationUtils;

    @Autowired
    SocialFriendBlockRepository blockRepo;

    @Override
    public void block(ToggleFriendSubscribeDTO toggleSubscriptionDTO) {
        LOGGER.info("blocking status {} {}", toggleSubscriptionDTO.getRequestor(), toggleSubscriptionDTO.getTarget());
        checkBlockCondition(toggleSubscriptionDTO.getRequestor(), toggleSubscriptionDTO.getTarget());
    }

    /**
     * @param requestor
     * @param target 
     */
    private void checkBlockCondition(final String requestor, final String target) {
        LOGGER.info("blocking condition {} {}", requestor, target);
        if (requestor == null || target == null) {
            throw new InvalidFriendRequestException("Invalid request :Required requestor and target");
        }

        socialFrdValidationUtils.validateFriendShipCriteria(requestor, target);

        List<String> targetBlockers = blockRepo.fetchBlockers(target);

        if (targetBlockers.contains(requestor)) {
            LOGGER.info("Exception :: blocking condition {} {}", requestor, target);
            throw new FriendBlockingException(requestor, target);
        }

        blockRepo.save(createBlock(requestor, target));
        LOGGER.info("blocking condition {} {}", requestor, target);

    }

   
    /**
     * @param requestor
     * @param target
     * @return SocialFriendBlock
     */
    private SocialFriendBlock createBlock(final String requestor, final String target) {
        return new SocialFriendBlock(requestor, target);
    }

}
