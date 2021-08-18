package kim.jaehoon.lunch.domain.command.domain;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CommandRepository extends ReactiveCrudRepository<Command, Integer> {

    Mono<Command> findFirstByKeywordAndIsEnabledTrue(String keyword);

}
