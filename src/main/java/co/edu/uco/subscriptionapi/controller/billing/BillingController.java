package co.edu.uco.subscriptionapi.controller.billing;

import co.edu.uco.subscriptionapi.domain.billing.Billing;
import co.edu.uco.subscriptionapi.domain.plan.Plan;
import co.edu.uco.subscriptionapi.service.billing.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/rest")
public class BillingController {

    @Autowired
    private BillingService billingService;
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
    public Billing updateBilling(@RequestBody Billing billing){
            return billingService.updateBilling(billing);
    }

    @PostMapping("/billing")
    public Billing saveBilling(@RequestBody Billing billing){
        return billingService.saveBilling(billing);
    }

    @PatchMapping("/billing")
    public Billing patchBilling(@RequestBody Map<?, Object> patchFields, @RequestParam UUID id) { return billingService.patchBilling(id, patchFields); }
}
