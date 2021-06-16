package kim.jaehoon.client.dto.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Introspected
public class LoginReq {

    private final String memberId;

    @JsonProperty("member_pw")
    private final String password;

    @JsonProperty("device_id")
    private final String deviceId;

    @Builder
    public LoginReq(String memberId, String password) {
        this.memberId = memberId;
        this.password = password;
        this.deviceId = UUID.randomUUID().toString();
    }

}
