package co.edu.uco.subscriptionapi.courier.user;

import co.edu.uco.subscriptionapi.domain.user.MyUser;
import co.edu.uco.subscriptionapi.service.user.MyUserService;
import co.edu.uco.subscriptionapi.util.mapper.JsonObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MessageReceiverBroker {

    @Autowired
    private MyUserService myUserService;

    private final JsonObjectMapper jsonObjectMapper;

    public MessageReceiverBroker(JsonObjectMapper jsonObjectMapper) {
        this.jsonObjectMapper = jsonObjectMapper;
    }


    @RabbitListener(queues = "${subscription.consumer.queue-name}")
    public void receiveMessageProcessClient(String message) {
        try {
            System.out.println(getObjectFromMessage(message).get());
//            myUserService.saveUser(getObjectFromMessage(message).get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Optional<MyUser> getObjectFromMessage(String message) {
        return jsonObjectMapper.execute(message, MyUser.class);
    }

}
