package co.edu.uco.subscriptionapi.controller.billing;

import co.edu.uco.subscriptionapi.service.billing.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/rest")
public class Billing {

    @Autowired
    private BillingService billingService;
    @GetMapping("/billing")
    public co.edu.uco.subscriptionapi.domain.billing.Billing getBillingById(@RequestParam UUID id){
        return billingService.getBillingById(id);
    }

    @PostMapping("/billing")
    public co.edu.uco.subscriptionapi.domain.billing.Billing saveBilling(@RequestBody co.edu.uco.subscriptionapi.domain.billing.Billing billing){
        return billingService.saveBilling(billing);
    }
}
