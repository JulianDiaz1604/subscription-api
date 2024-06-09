package co.edu.uco.subscriptionapi.courier;

import co.edu.uco.subscriptionapi.config.RabbitMQProperties;
import co.edu.uco.subscriptionapi.domain.billing.BillingProcess;
import co.edu.uco.subscriptionapi.domain.plan.PlanListMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSenderBroker {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RabbitMQProperties rabbitMQProperties;

    @Autowired
    ObjectMapper objectMapper;

    public void sendPlanMessage(PlanListMessage message) {
        try {
            String jsonMessage = objectMapper.writeValueAsString(message);
            rabbitTemplate.convertAndSend(rabbitMQProperties.getExchange().getRequest(), rabbitMQProperties.getRoutingKey().getPlanProcessing(), jsonMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void sendBillingMessage(BillingProcess message) {
        try {
            String jsonMessage = objectMapper.writeValueAsString(message);
            rabbitTemplate.convertAndSend(rabbitMQProperties.getExchange().getRequest(), rabbitMQProperties.getRoutingKey().getBillingProcessing(), jsonMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }    }

}
