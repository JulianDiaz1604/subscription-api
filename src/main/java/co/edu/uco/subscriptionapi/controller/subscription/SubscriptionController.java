package co.edu.uco.subscriptionapi.controller.subscription;

import co.edu.uco.subscriptionapi.domain.billing.Billing;
import co.edu.uco.subscriptionapi.domain.subscription.Subscription;
import co.edu.uco.subscriptionapi.domain.subscription.SubscriptionDetails;
import co.edu.uco.subscriptionapi.service.subscription.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api/v1/rest")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @CrossOrigin(origins = "http://localhost:4200")

    @GetMapping("/subscription")
    public ArrayList<SubscriptionDetails> getSubscriptionDetailsList() {
        return subscriptionService.getSubscriptionDetailsList();
    }

    @GetMapping("/subscription/{id}")
    public ArrayList<Subscription> getSubscriptionListByUserId(@PathVariable UUID userId) {
        return subscriptionService.getSubscriptionListByUserId(userId);
    }
    @CrossOrigin(origins = "http://localhost:4200")

    @PostMapping("/subscription")
    public Subscription saveSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.saveSubscription(subscription);
    }

    @PutMapping("/subscription")
    public Subscription updateSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.updateSubscription(subscription);
    }

    @DeleteMapping("/subscription")
    public void deleteSubscription(@RequestParam UUID id) {
        subscriptionService.deleteSubscription(id);
    }

    @PatchMapping("/subscription")
    public Subscription patchSubscription(@RequestBody Map<?, Object> patchFields, @RequestParam UUID id) { return subscriptionService.patchSubscription(id, patchFields); }

}
