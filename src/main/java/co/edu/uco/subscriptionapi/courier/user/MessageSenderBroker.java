package co.edu.uco.subscriptionapi.courier.user;

import co.edu.uco.subscriptionapi.config.SubscriptionQueueConfig;
import co.edu.uco.subscriptionapi.domain.user.MyUser;
import co.edu.uco.subscriptionapi.util.courier.MessageSender;
import co.edu.uco.subscriptionapi.util.mapper.JsonObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MessageSenderBroker implements MessageSender<MyUser> {

    private final RabbitTemplate rabbitTemplate;
    private final JsonObjectMapper jsonObjectMapper;
    private final SubscriptionQueueConfig subscriptionQueueConfig;

    public MessageSenderBroker(RabbitTemplate rabbitTemplate, JsonObjectMapper jsonObjectMapper, SubscriptionQueueConfig subscriptionQueueConfig) {
        this.rabbitTemplate = rabbitTemplate;
        this.jsonObjectMapper = jsonObjectMapper;
        this.subscriptionQueueConfig = subscriptionQueueConfig;
    }

    @Override
    public void execute(MyUser message, String idMessage) {
        MessageProperties messageProperties = generateMessageProperties(idMessage);

        Optional<Message> messageBody = getMessageBody(message, messageProperties);
        if (messageBody.isEmpty()) {
            return;
        }
        rabbitTemplate.convertAndSend(subscriptionQueueConfig.getExchangeName(), subscriptionQueueConfig.getRoutingKeyName(), messageBody.get());
    }

    private MessageProperties generateMessageProperties(String idMessageSender ) {
        return MessagePropertiesBuilder.newInstance()
                .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                .setHeader("messageId", idMessageSender)
                .build();
    }

    private Optional<Message> getMessageBody(Object message, MessageProperties messageProperties) {
        Optional<String> messageText = jsonObjectMapper.executeGson(message);

        return messageText.map(msg -> MessageBuilder
                .withBody(msg.getBytes())
                .andProperties(messageProperties)
                .build());

    }


}
