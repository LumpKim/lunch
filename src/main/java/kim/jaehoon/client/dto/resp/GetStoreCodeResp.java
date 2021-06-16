package kim.jaehoon.client.dto.resp;

import io.micronaut.core.annotation.Introspected;
import lombok.Getter;

import java.util.List;

@Getter
@Introspected
public class GetStoreCodeResp {

    private String resultCode;
    private List<ResultDatum> resultData;
    private String resultMsg;

    @Getter
    public static class ResultDatum {
        private String code;
        private String title;
    }

}
