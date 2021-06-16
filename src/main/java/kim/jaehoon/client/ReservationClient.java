package kim.jaehoon.client;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.MediaType;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import kim.jaehoon.client.dto.req.*;
import kim.jaehoon.client.dto.resp.GetReserveMasterIdsResp;
import kim.jaehoon.client.dto.resp.GetStoreCodeResp;
import kim.jaehoon.client.dto.resp.LoginResp;
import kim.jaehoon.client.dto.resp.ReserveResp;
import kim.jaehoon.config.ReservationConfig;
import kim.jaehoon.util.Encryptor;

import javax.inject.Singleton;

@Singleton
public class ReservationClient {

    private static final String HEADER_AUTH_TOKEN = "lunchpass_auth_token";
    private static final String HEADER_MEMBER_ID = "lunchpass_member_id";

    private final RxHttpClient httpClient;
    private final Encryptor encryptor;

    public ReservationClient(
            @Client(ReservationConfig.RESERVATION_API_URL) RxHttpClient httpClient,
            Encryptor encryptor
    ) {
        this.httpClient = httpClient;
        this.encryptor = encryptor;
    }

    public LoginResp login(LoginReq loginReq) {
        String encrypted = encryptor.encrypt(loginReq);
        HttpRequest<?> req = HttpRequest.POST("/auth/login", new RequestWrapper(encrypted))
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_TYPE);

        return httpClient.retrieve(req, LoginResp.class)
                .firstElement()
                .blockingGet();
    }

    public GetStoreCodeResp getStoreCode(GetStoreCodeReq getStoreCodeReq, String authToken, String memberId) {
        String encrypted = encryptor.encrypt(getStoreCodeReq);
        HttpRequest<?> req = HttpRequest.POST("/store/list/ableReserveSelectList", new RequestWrapper(encrypted))
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
                .header(HEADER_AUTH_TOKEN, authToken)
                .header(HEADER_MEMBER_ID, memberId);

        return httpClient.retrieve(req, GetStoreCodeResp.class)
                .firstElement()
                .blockingGet();
    }

    public GetReserveMasterIdsResp getReserveMasterIds(
            GetReserveMasterIdsReq getReserveMasterIdsReq,
            String authToken, String memberId
    ) {
        String encrypted = encryptor.encrypt(getReserveMasterIdsReq);
        HttpRequest<?> req = HttpRequest.POST("/store/list/reserveMaster", new RequestWrapper(encrypted))
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
                .header(HEADER_AUTH_TOKEN, authToken)
                .header(HEADER_MEMBER_ID, memberId);

        return httpClient.retrieve(req, GetReserveMasterIdsResp.class)
                .firstElement()
                .blockingGet();
    }

    public ReserveResp reserve(ReserveReq reserveReq, String authToken, String memberId) {
        String encrypted = encryptor.encrypt(reserveReq);
        HttpRequest<?> req = HttpRequest.POST("/store/reserve/912000", new RequestWrapper(encrypted))
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
                .header(HEADER_AUTH_TOKEN, authToken)
                .header(HEADER_MEMBER_ID, memberId);

        return httpClient.retrieve(req, ReserveResp.class)
                .firstElement()
                .blockingGet();
    }

}
