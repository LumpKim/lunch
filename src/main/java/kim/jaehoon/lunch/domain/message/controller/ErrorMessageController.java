package kim.jaehoon.lunch.domain.message.controller;

import kim.jaehoon.lunch.global.dto.CommandResp;
import kim.jaehoon.lunch.domain.message.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/errors")
@RequiredArgsConstructor
public class ErrorMessageController {

    private final MessageService messageService;

    @PostMapping("/{errCode}")
    public Mono<CommandResp> getErrorMessage(@PathVariable String errCode) {
        return messageService.findErrMsgByCode(errCode)
                .map(m -> CommandResp.builder()
                        .text(m.getDetails())
                        .build())
                .switchIfEmpty(Mono.just(CommandResp.builder()
                        .text("##### Error code has not found.")
                        .build()));
    }

}
