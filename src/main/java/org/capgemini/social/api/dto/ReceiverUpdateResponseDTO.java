package org.capgemini.social.api.dto;

import java.util.List;

/**
 * @author Ravi
 *
 */
public class ReceiverUpdateResponseDTO extends BaseResponseDTO {

    private List<String> recipients;

    public ReceiverUpdateResponseDTO(List<String> recipients) {
        super(true);
        this.recipients = recipients;
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }
}
