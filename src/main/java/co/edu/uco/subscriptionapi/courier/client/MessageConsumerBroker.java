package co.edu.uco.subscriptionapi.courier.client;

import co.edu.uco.subscriptionapi.domain.billing.Billing;
import co.edu.uco.subscriptionapi.service.billing.BillingService;
import co.edu.uco.subscriptionapi.util.MessageConsumer;
import co.edu.uco.subscriptionapi.util.gson.JsonObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageConsumerBroker {

    @Autowired
    private BillingService billingService;

    private final JsonObjectMapper jsonObjectMapper;

    public MessageConsumerBroker(JsonObjectMapper jsonObjectMapper) {
        this.jsonObjectMapper = jsonObjectMapper;
    }

    @RabbitListener(queues = {"${subscription.consumer.queue-name}"})
    public void receiveMessage(@Payload MessageConsumer<Billing> message) {

//        log.info(message.toString());
        makeSlow();

    }

    private void makeSlow() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
//            log.error(e.getMessage());
        }
    }

}
