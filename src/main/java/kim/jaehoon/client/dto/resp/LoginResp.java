package kim.jaehoon.client.dto.resp;

import io.micronaut.core.annotation.Introspected;
import lombok.Getter;

@Getter
@Introspected
public class LoginResp {

    private String resultCode;
    private String resultMsg;
    private ResultData resultData;

    @Getter
    public static class ResultData {
        private String memberId;
        private String authToken;
        private String passwordStatus;
        private String otaYn;
        private String deviceId;
        private String companyCode;
        private String changeRequestYn;
    }

}