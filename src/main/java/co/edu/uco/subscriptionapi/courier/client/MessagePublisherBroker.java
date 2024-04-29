package co.edu.uco.subscriptionapi.courier.client;

import co.edu.uco.subscriptionapi.config.ClientQueueConfig;
import co.edu.uco.subscriptionapi.util.MessagePublisher;
import co.edu.uco.subscriptionapi.util.gson.JsonObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessagePublisherBroker implements MessagePublisher {

    private final RabbitTemplate rabbitTemplate;
    private final JsonObjectMapper jsonObjectMapper;
    private final ClientQueueConfig clientQueueConfig;

    public MessagePublisherBroker(RabbitTemplate rabbitTemplate, JsonObjectMapper jsonObjectMapper, ClientQueueConfig clientQueueConfig) {
        this.rabbitTemplate = rabbitTemplate;
        this.jsonObjectMapper = jsonObjectMapper;
        this.clientQueueConfig = clientQueueConfig;
    }

    @Override
    public void execute(Object message, String idMessage) {

    }

}
