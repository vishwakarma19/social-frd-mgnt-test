/**
 * 
 */
package org.capgemini.social.api.repository;

import java.util.List;

import org.capgemini.social.api.model.SocialFriend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Ravi
 */
public interface SocialFriendRepository extends JpaRepository<SocialFriend, String> {

    /**
     * @param person
     * @return List of friends for a person
     */
    @Query(nativeQuery = true)
    List<String> fetchFriends(@Param("user") final String user);
}
