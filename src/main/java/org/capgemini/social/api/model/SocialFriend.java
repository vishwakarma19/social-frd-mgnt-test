
package org.capgemini.social.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

/**
 * @author Ravi
 *  Entity for SocialFriend
 */
@Entity
@NamedNativeQuery(name = "social_friend.fetchFriends",
    query = "SELECT userTwo AS friend FROM social_friend WHERE userOne =:user" + " UNION "
        + "SELECT userOne AS friend FROM social_friend WHERE userTwo =:user")
@Table(name="social_friend")
public class SocialFriend implements java.io.Serializable {

	private static final long serialVersionUID = -8121751681233894071L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 
	private String userOne;
    private String userTwo;
    
    public SocialFriend(Long id, String userOne, String userTwo) {
 		super();
 		this.userOne = userOne;
 		this.userTwo = userTwo;
 	}

	public SocialFriend() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserOne() {
		return userOne;
	}

	public void setUserOne(String userOne) {
		this.userOne = userOne;
	}

	public String getUserTwo() {
		return userTwo;
	}

	public void setUserTwo(String userTwo) {
		this.userTwo = userTwo;
	}
    



}
