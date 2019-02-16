/**
 * 
 */
package org.capgemini.social.api.repository;

import java.util.List;

import org.capgemini.social.api.model.SocialFriendSubscribe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author Ravi
 *
 */
public interface SocialFriendSubscribeRepository extends JpaRepository<SocialFriendSubscribe, Long> {

    /**
     * @param subscribee -who will be subscribe by other user
     * @return List of subscribers of given subscribe.
     */
    List<String> fetchSubscribers(@Param("subscribee") final String subscribee);

}
