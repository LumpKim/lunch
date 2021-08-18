package kim.jaehoon.lunch.global.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Data
public class CommandReq {

    @NotEmpty
    String channelId;

    @NotEmpty
    String channelName;

    @NotEmpty
    String command;

    @NotEmpty
    String responseUrl;

    @NotEmpty
    String teamDomain;

    @NotEmpty
    String teamId;

    @NotEmpty
    String text;

    @NotEmpty
    String token;

    @NotEmpty
    String triggerId;

    @NotEmpty
    String userId;

    @NotEmpty
    String userName;

    public CommandReq(String channel_id, String channel_name, String command, String response_url, String team_domain,
                      String team_id, String text, String token, String trigger_id, String user_id, String user_name) {
        this.channelId = channel_id;
        this.channelName = channel_name;
        this.command = command;
        this.responseUrl = response_url;
        this.teamDomain = team_domain;
        this.teamId = team_id;
        this.text = text;
        this.token = token;
        this.triggerId = trigger_id;
        this.userId = user_id;
        this.userName = user_name;
    }
}
