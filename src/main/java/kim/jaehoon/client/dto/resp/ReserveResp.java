package kim.jaehoon.client.dto.resp;

import io.micronaut.core.annotation.Introspected;
import lombok.Getter;

@Getter
@Introspected
public class ReserveResp {

    private String resultCode;
    private ResultData resultData;
    private String resultMsg;

    @Getter
    public static class ResultData {
        private String menuDetail;
        private String menuIcon;
        private String menuId;
        private String menuName;
        private Integer menuPrice;
        private Integer remainQty;
        private String reserveDivCode;
        private String reserveMasterId;
        private String reserveTitle;
        private String reserveYn;
        private String selTimeYn;
        private String storeName;
        private String storeownerCode;
        private String title;
    }

}
