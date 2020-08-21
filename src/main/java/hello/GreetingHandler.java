package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
public class GreetingHandler {

//    @Autowired
//    private KafkaTemplate<Object, Object> template;

    public Mono<ServerResponse> hello(ServerRequest request) {

//      this.template.send("topic1", "Hello at : "+ LocalDateTime.now());

        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("Hello, Spring!"));
    }
}