/**
 * 
 */
package org.capgemini.social.api.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import org.capgemini.social.api.dto.ToggleFriendSubscribeDTO;
import org.junit.Test;

/**
 * @author ravi
 *
 */
public class SocialFriendSubscriptionServiceTest {

    @Test
    public void testSubscribeUser() {
	SocialFriendSubscribeServiceImpl subscribeServiceMock = mock(SocialFriendSubscribeServiceImpl.class);
	
	ToggleFriendSubscribeDTO tsubsDTO = new ToggleFriendSubscribeDTO();
	tsubsDTO.setTarget("vishwakarma@gmail.com");
	tsubsDTO.setRequestor(" sudhansu@gmail.com");
	
	doNothing().when(subscribeServiceMock).scubscribe(tsubsDTO);
    }
}
