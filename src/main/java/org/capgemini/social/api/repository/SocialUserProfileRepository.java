package org.capgemini.social.api.repository;

import org.capgemini.social.api.model.SocialUserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ravi
 *
 */

public interface SocialUserProfileRepository extends JpaRepository<SocialUserProfile, String> {

}
