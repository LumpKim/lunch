package kim.jaehoon.client.dto.req;

import io.micronaut.core.annotation.Introspected;
import lombok.Getter;

@Getter
@Introspected
public class GetReserveMasterIdsReq {

    private String authToken;
    private String memberId;
    private String companyCode;
    private String storeCode;
    private String menuDate;

}
