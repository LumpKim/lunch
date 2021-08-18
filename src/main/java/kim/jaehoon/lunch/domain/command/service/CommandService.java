package kim.jaehoon.lunch.domain.command.service;

import kim.jaehoon.lunch.domain.command.domain.Command;
import kim.jaehoon.lunch.domain.command.domain.CommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CommandService {

    private final CommandRepository commandRepository;

    public Mono<Command> findByKeyword(String keyword) {
        return commandRepository.findFirstByKeywordAndIsEnabledTrue(keyword);
    }

}
