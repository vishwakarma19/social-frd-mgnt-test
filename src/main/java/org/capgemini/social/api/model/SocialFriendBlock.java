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
 * To block the user
 */
@Entity
@NamedQuery(name = "social_frd_block.fetchBlockers",
    query = "SELECT bl.blocker FROM SocialFriendBlock bl WHERE bl.blockee=:blockee")
@Table(name="social_frd_block")
public class SocialFriendBlock implements java.io.Serializable {

    private static final long serialVersionUID = -5064330509061005796L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String blocker;
    private String blockee;

    public SocialFriendBlock() {
    }

    public SocialFriendBlock(String blocker, String blockee) {
        super();
        this.blocker = blocker;
        this.blockee = blockee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlocker() {
        return blocker;
    }

    public void setBlocker(String blocker) {
        this.blocker = blocker;
    }

    public String getBlockee() {
        return blockee;
    }

    public void setBlockee(String blockee) {
        this.blockee = blockee;
    }

}
