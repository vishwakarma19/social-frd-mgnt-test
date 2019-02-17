
package org.capgemini.social.api.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import org.capgemini.social.api.dto.ToggleFriendSubscribeDTO;
import org.junit.Test;

/**
 * @author Ravi
 *
 */
public class SocialFriendBlockServiceTest {

    @Test
    public void testBlockUser() {
	SocialFriendBlockingServiceImpl blockUserMockService = mock(SocialFriendBlockingServiceImpl.class);

	ToggleFriendSubscribeDTO tsubsDTO = new ToggleFriendSubscribeDTO();
        tsubsDTO.setTarget("vishwakarma@gmail.com");
        tsubsDTO.setRequestor(" sudhansu@gmail.com");
        doNothing().when(blockUserMockService).block(tsubsDTO);
    }
}
