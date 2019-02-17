
package org.capgemini.social.api.model;

import javax.persistence.Column;
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
@NamedNativeQuery(name = "SocialFriend.fetchFriends",
    query = "SELECT user_two AS friend FROM social_friend WHERE user_one =:user" + " UNION "
        + "SELECT user_one AS friend FROM social_friend WHERE user_two =:user")
@Table(name="social_friend")
public class SocialFriend implements java.io.Serializable {

	private static final long serialVersionUID = -8121751681233894071L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 
	@Column(name="user_one")
	private String userOne;
	@Column(name="user_two")
    private String userTwo;
    
    public SocialFriend(String userOne, String userTwo) {
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
