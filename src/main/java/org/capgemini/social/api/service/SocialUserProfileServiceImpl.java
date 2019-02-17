package org.capgemini.social.api.service;

import org.capgemini.social.api.dto.EmailDTO;
import org.capgemini.social.api.model.SocialUserProfile;
import org.capgemini.social.api.repository.SocialUserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialUserProfileServiceImpl implements SocialUserProfileService {

    @Autowired
    SocialUserProfileRepository userProfileRepo;

    @Override
    public SocialUserProfile signUp(final EmailDTO emailDTO) {
        return userProfileRepo.save(createUserProfile(emailDTO.getEmail()));
    }

    /**
     * @param email
     * @return UserProfile
     */
    private SocialUserProfile createUserProfile(final String email) {
        return new SocialUserProfile(email);
    }

}
