package org.capgemini.social.api.dto;

import java.util.List;

/**
 * @author Ravi
 *
 */
public class ReciveUpdateResponseDTO extends BaseResponseDTO {

    private List<String> recipients;

    public ReciveUpdateResponseDTO(List<String> recipients) {
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
