/**
 * 
 */
package org.capgemini.social.api.dto;

import java.util.List;

/**
 * @author Ravi
 */
public class InviteFriendDTO implements java.io.Serializable {

    private static final long serialVersionUID = -1846727325242637537L;

    private List<String> friends;

    public InviteFriendDTO() {
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

}
