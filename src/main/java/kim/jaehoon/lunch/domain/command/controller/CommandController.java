package kim.jaehoon.lunch.domain.command.controller;

import kim.jaehoon.lunch.domain.command.domain.Command;
import kim.jaehoon.lunch.global.dto.CommandReq;
import kim.jaehoon.lunch.global.dto.CommandResp;
import kim.jaehoon.lunch.domain.command.service.CommandService;
import kim.jaehoon.lunch.domain.message.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/commands")
@RequiredArgsConstructor
public class CommandController {

    @Value("${spring.webflux.base-path}")
    private String basePath;

    private final CommandService commandService;
    private final MessageService messageService;

    @PostMapping
    public Mono<ResponseEntity<Void>> switchCommand(@Validated @ModelAttribute Mono<CommandReq> req) {
        return req.map(r -> r.getText().split(" ")[0])
                .flatMap(commandService::findByKeyword)
                        .map(Command::getUri)
                        .switchIfEmpty(Mono.just("/errors/cmdNotFound"))
                .flatMap(uri -> Mono.just(new HttpHeaders())
                        .doOnNext(h -> h.add("Location", basePath + uri))
                        .map(h -> new ResponseEntity<>(null, h, HttpStatus.TEMPORARY_REDIRECT)));
    }

    @PostMapping("/help")
    public Mono<CommandResp> printHelp() {
        return messageService.findInfoMsgByCode("userGuide")
                .map(m -> CommandResp.builder()
                        .text(m.getDetails())
                        .build());
    }

}
