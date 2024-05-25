package co.edu.uco.subscriptionapi.courier.client;

import co.edu.uco.subscriptionapi.config.ClientQueueConfig;
import co.edu.uco.subscriptionapi.domain.billing.Billing;
import co.edu.uco.subscriptionapi.util.MessagePublisher;
import co.edu.uco.subscriptionapi.util.gson.JsonObjectMapper;
import org.springframework.amqp.core.MessageProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class MessagePublisherBroker implements MessagePublisher<Billing> {

    private final RabbitTemplate rabbitTemplate;
    private final JsonObjectMapper jsonObjectMapper;
    private final ClientQueueConfig clientQueueConfig;

    public MessagePublisherBroker(RabbitTemplate rabbitTemplate, JsonObjectMapper jsonObjectMapper, ClientQueueConfig clientQueueConfig) {
        this.rabbitTemplate = rabbitTemplate;
        this.jsonObjectMapper = jsonObjectMapper;
        this.clientQueueConfig = clientQueueConfig;
    }

    public void sendMessagge(Object message, Long EmissorMessageId, String exchange, String routingKey){

    }

    private MessageProperties messagePropertiesGenerate(String idMessageSender ) {
        return MessagePropertiesBuilder.newInstance()
                .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                .setHeader("idMensaje", idMessageSender)
                .build();
    }

    private Optional<Message> getMessageBody(Object message, org.springframework.amqp.core.MessageProperties messageProperties){
        Optional<String> messageText = jsonObjectMapper.executeGson(message);

        return messageText.map(msg -> MessageBuilder
                .withBody(msg.getBytes())
                .andProperties(messageProperties)
                .build());
    }

    @Override
    public void execute(Billing message, String idMessage) {
        MessageProperties messageProperties = messagePropertiesGenerate(idMessage);
        rabbitTemplate.convertAndSend(message);
        Optional<Message> messageBody = getMessageBody(message, messageProperties);
        if(messageBody.isEmpty()){
            return;
        }
        rabbitTemplate.convertAndSend(clientQueueConfig.getExchangeName(), clientQueueConfig.getRoutingKey(), messageBody.get());
    }

}
