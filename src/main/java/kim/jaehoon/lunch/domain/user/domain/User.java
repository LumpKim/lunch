package kim.jaehoon.lunch.domain.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class User {

    @Id
    private Integer id;

    private String userId;

    private String userName;

    private String floor;

    private LocalDateTime createdAt;

}
