/**
 * 
 */
package org.capgemini.social.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Ravi
 * 
 *  Entity for UserProfile
 */
@Entity
@Table(name="social_userprofile")
public class SocialUserProfile implements java.io.Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7191970360863579682L;
	
	@Id
    private String email;

    public SocialUserProfile() {
		super();
	}

	public SocialUserProfile(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
