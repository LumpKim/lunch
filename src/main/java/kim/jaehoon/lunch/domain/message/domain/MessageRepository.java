package kim.jaehoon.lunch.domain.message.domain;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface MessageRepository extends ReactiveCrudRepository<Message, Integer> {

    Mono<Message> findFirstByTypeAndCode(Message.Type type, String code);

}
