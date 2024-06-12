package co.edu.uco.subscriptionapi.courier;

import co.edu.uco.subscriptionapi.domain.billing.Billing;
import co.edu.uco.subscriptionapi.service.billing.BillingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiverBroker {

    @Autowired
    private BillingService billingService;

    @Autowired
    private ObjectMapper objectMapper;

    private Object lastReceivedMessage;

    @RabbitListener(queues = "${rabbitmq.queue.plan-response}")
    public void receivePlanMessage(String message) {
        try {
            lastReceivedMessage = objectMapper.readValue(message, Object.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = "${rabbitmq.queue.billing-response}")
    public void receiveBillingMessage(String message) {
        try {
            Billing billing = objectMapper.readValue(message, Billing.class);
            billingService.saveBilling(billing);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object getLastReceivedMessage() {
        return lastReceivedMessage;
    }

}
