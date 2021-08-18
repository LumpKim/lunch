package kim.jaehoon.lunch.domain.message.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
@AllArgsConstructor
public class Message {

    @Id
    private Integer id;

    private Type type;

    private String code;

    private String details;

    public enum Type {
        ERROR, INFO
    }

}
