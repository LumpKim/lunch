package kim.jaehoon.lunch.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean(name = "messengerWebClient")
    public WebClient getMessengerWebClient() {
        return WebClient.create("https://mattermost.midasit.com");
    }

}
