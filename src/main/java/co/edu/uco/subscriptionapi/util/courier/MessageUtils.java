package co.edu.uco.subscriptionapi.util.courier;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;

import java.util.Optional;

public interface MessageUtils {

    MessageProperties generateMessageProperties(String idMessageSender );

    Optional<Message> getMessageBody(Object message, MessageProperties messageProperties);

    <T> Optional<T> getObjectFromMessage(String message, Class<T> clazz);

}
