package kim.jaehoon.lunch.domain.message.service;

import kim.jaehoon.lunch.domain.message.domain.Message;
import kim.jaehoon.lunch.domain.message.domain.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public Mono<Message> findErrMsgByCode(String code) {
        return messageRepository.findFirstByTypeAndCode(Message.Type.ERROR, code);
    }

    public Mono<Message> findInfoMsgByCode(String code) {
        return messageRepository.findFirstByTypeAndCode(Message.Type.INFO, code);
    }

}
