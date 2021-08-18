package kim.jaehoon.lunch.domain.user.controller;

import kim.jaehoon.lunch.global.dto.CommandReq;
import kim.jaehoon.lunch.global.dto.CommandResp;
import kim.jaehoon.lunch.global.dto.InteractiveDialogResp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserController {

    public static final String CONNECT_SUBMIT_PATH = "/connect/submit";

    @Value("${server.host}")
    private String serverUrl;

    @Value("${spring.webflux.base-path}")
    private String basePath;

    @Qualifier("messengerWebClient")
    private WebClient messengerClient;

    @PostMapping("/commands/connect/form")
    public Mono<Void> printConnectForm(Mono<CommandReq> req) {
        return req.map(CommandReq::getTriggerId)
                .flatMap(triggerId -> {
                    List<InteractiveDialogResp.Element> elements = List.of(
                            InteractiveDialogResp.Element.builder()
                                    .displayName("케이터링 패스 비밀번호")
                                    .name("catering_pass_password")
                                    .type("text")
                                    .subType("")
                                    .defaultText("")
                                    .placeholder("여기를 눌러 케이터링 패스 비밀번호 입력")
                                    .helpText("예약 자동화를 위해 비밀번호를 수집하고 있습니다. " +
                                            "보안성 강화를 위해 다른 서비스에서 이용하지 않는 비밀번호를 이용해 주세요.")
                                    .optional(false)
                                    .minLength(0)
                                    .maxLength(30)
                                    .dataSource("")
                                    .options(null)
                                    .build()
                    );
                    InteractiveDialogResp.Dialog dialog = InteractiveDialogResp.Dialog.builder()
                            .callbackId(UUID.randomUUID().toString())
                            .title("기능 활성화")
                            .elements(elements)
                            .build();
                    Mono<InteractiveDialogResp> body = Mono.just(InteractiveDialogResp.builder()
                            .triggerId(UUID.randomUUID().toString())
                            .url(serverUrl + basePath + CONNECT_SUBMIT_PATH)
                            .dialog(dialog)
                            .build());

                    messengerClient.post()
                            .uri("/api/v4/actions/dialogs/open")
                            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                            .body(body, InteractiveDialogResp.class)
                            .retrieve();

                    return Mono.empty();
                });
    }

    @PostMapping(CONNECT_SUBMIT_PATH)
    public Mono<CommandResp> submitConnectForm(Mono<CommandReq> req) {
        return Mono.just(new CommandResp());
    }

//    @PostMapping
//    public connectResp connect(connectReq req) {
//
//    }

}
