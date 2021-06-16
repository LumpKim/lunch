package kim.jaehoon.client.dto.req;

import io.micronaut.core.annotation.Introspected;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Introspected
public class GetMenusReq {

    private final String authToken;
    private final String memberId;
    private final String companyCode;
    private final String menuDate;

}
