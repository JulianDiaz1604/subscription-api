package co.edu.uco.subscriptionapi.controller.subscription;

import co.edu.uco.subscriptionapi.domain.billing.Billing;
import co.edu.uco.subscriptionapi.domain.subscription.Subscription;
import co.edu.uco.subscriptionapi.service.subscription.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/rest")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping("/subscription")
    public ArrayList<Subscription> getSubscriptionListByUserId(@RequestParam UUID userId) {
        return subscriptionService.getSubscriptionListByUserId(userId);
    }

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
