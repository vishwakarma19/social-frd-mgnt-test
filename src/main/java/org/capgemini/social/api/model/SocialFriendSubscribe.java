/**
 * 
 */
package org.capgemini.social.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Ravi
 * To subscribe the friends
 */
@Entity
@NamedQuery(name = "SocialFriendSubscribe.fetchSubscribers",
    query = "SELECT s.subscriber FROM SocialFriendSubscribe s WHERE s.subscribee=:subscribee")
@Table(name="social_frd_subscrib")
public class SocialFriendSubscribe implements java.io.Serializable {

     /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6967114759901813193L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String subscriber;
    private String subscribee;

	public SocialFriendSubscribe() {
	}

    public SocialFriendSubscribe(String subscriber, String subscribee) {
        super();
        this.subscriber = subscriber;
        this.subscribee = subscribee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(String subscriber) {
        this.subscriber = subscriber;
    }

    public String getSubscribee() {
        return subscribee;
    }

    public void setSubscribee(String subscribee) {
        this.subscribee = subscribee;
    }

}
