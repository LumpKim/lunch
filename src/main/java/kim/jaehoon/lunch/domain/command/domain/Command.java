package kim.jaehoon.lunch.domain.command.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
@AllArgsConstructor
public class Command {

    @Id
    private Integer id;

    private String keyword;

    private String uri;

    private Boolean isEnabled;

}
