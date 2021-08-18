package kim.jaehoon.lunch.global.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommandResp {

    private String responseType;
    private String text;
    private String username;
    private String iconUrl;
    private String type;
    private Map<String, String> props;
    private String gotoLocation;
    private String triggerId;
    private List<CommandResp> extraResponses;
    private String channelId;
    private Boolean skipSlackParsing;

    @Builder
    public CommandResp(String responseType, String text, String username, String iconUrl, String type,
                       Map<String, String> props, String gotoLocation, String triggerId,
                       List<CommandResp> extraResponses, String channelId, Boolean skipSlackParsing) {
        this.responseType = responseType;
        this.text = text;
        this.username = username;
        this.iconUrl = iconUrl;
        this.type = type;
        this.props = props;
        this.gotoLocation = gotoLocation;
        this.triggerId = triggerId;
        this.extraResponses = extraResponses;
        this.channelId = channelId;
        this.skipSlackParsing = skipSlackParsing;
    }
}
