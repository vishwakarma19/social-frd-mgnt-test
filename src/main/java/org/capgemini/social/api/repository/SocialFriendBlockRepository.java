/**
 * 
 */
package org.capgemini.social.api.repository;

import java.util.List;

import org.capgemini.social.api.model.SocialFriendBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author Ravi
 *
 */
public interface SocialFriendBlockRepository extends JpaRepository<SocialFriendBlock, Long> {

    /**
     * @param blockee-who will be blocked the another user
     * @return Blockers -who will block the blockee
     */
    List<String> fetchBlockers(@Param("blockee") final String blockee);
}
