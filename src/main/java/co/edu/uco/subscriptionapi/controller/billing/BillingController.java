package co.edu.uco.subscriptionapi.controller.billing;

import co.edu.uco.subscriptionapi.config.ClientQueueConfig;
import co.edu.uco.subscriptionapi.courier.client.MessagePublisherBroker;
import co.edu.uco.subscriptionapi.domain.billing.Billing;
import co.edu.uco.subscriptionapi.service.billing.BillingService;
import co.edu.uco.subscriptionapi.util.gson.JsonObjectMapperImpl;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/rest")
public class BillingController {

    @Autowired
    private BillingService billingService;
    private MessagePublisherBroker messagePublisherBroker = new MessagePublisherBroker( new  RabbitTemplate(), new JsonObjectMapperImpl(), new ClientQueueConfig());
    @GetMapping("/billing")
    public Billing getBillingById(@RequestParam UUID id){
        return billingService.getBillingById(id);
    }

    @GetMapping("/billing/subscription/{subs}")
    public Billing getBillingBySubscriptionId(@PathVariable UUID subs){
        return billingService.getBySubscriptionId(subs);
    }

    @DeleteMapping("/billing")
    public void deleteBilling(@RequestParam UUID id){
        billingService.deleteBilling(id);
    }

    @PutMapping("/billing")
    public Billing updateBilling(Billing billing){
        return billingService.updateBilling(billing);
    }

    @PostMapping("/billing")
    public Billing saveBilling(@RequestBody Billing billing){
        return billingService.saveBilling(billing);
    }

    @PostMapping("/billingp")
    public void prueba(@RequestBody Billing billing){
        messagePublisherBroker.execute(billing, "FUNCIONÓ MMGVO");
    }
}
