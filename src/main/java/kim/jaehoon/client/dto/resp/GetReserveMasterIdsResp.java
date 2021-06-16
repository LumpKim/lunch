package kim.jaehoon.client.dto.resp;

import io.micronaut.core.annotation.Introspected;
import lombok.Getter;

import java.util.List;

@Getter
@Introspected
public class GetReserveMasterIdsResp {

    private String resultCode;
    private ResultData resultData;
    private Object resultMsg;

    @Getter
    public static class ResultData {
        private List<Datum> data;
    }

    @Getter
    public static class Datum {
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
