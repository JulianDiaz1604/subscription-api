package co.edu.uco.subscriptionapi.controller.subscription;

import co.edu.uco.subscriptionapi.domain.subscription.Subscription;
import co.edu.uco.subscriptionapi.domain.subscription.SubscriptionDetails;
import co.edu.uco.subscriptionapi.domain.subscription.SubscriptionRequest;
import co.edu.uco.subscriptionapi.service.subscription.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ArrayList<SubscriptionDetails>> getSubscriptionDetailsList() {
        try {
            ArrayList<SubscriptionDetails> subscriptionDetails = subscriptionService.getSubscriptionDetailsList();
            return new ResponseEntity<>(subscriptionDetails, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/subscription/{id}")
    public ResponseEntity<ArrayList<Subscription>> getSubscriptionListByUserId(@PathVariable UUID id) {
        try {
            ArrayList<Subscription> subscriptions = subscriptionService.getSubscriptionListByUserId(id);
            if (subscriptions == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(subscriptions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/subscription")
    public ResponseEntity<Subscription> saveSubscription(@RequestBody SubscriptionRequest subscriptionRequest) {
        try {
            Subscription subscription = subscriptionService.saveSubscription(subscriptionRequest);
            return new ResponseEntity<>(subscription, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/subscription")
    public ResponseEntity<Subscription> updateSubscription(@RequestBody Subscription subscription) {
        try {
            Subscription updatedSubscription = subscriptionService.updateSubscription(subscription);
            if (updatedSubscription == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(updatedSubscription, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/subscription")
    public ResponseEntity<Void> deleteSubscription(@RequestParam UUID id) {
        try {
            subscriptionService.deleteSubscription(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/subscription")
    public ResponseEntity<Subscription> patchSubscription(@RequestBody Map<?, Object> patchFields, @RequestParam UUID id) {
        try {
            Subscription patchedSubscription = subscriptionService.patchSubscription(id, patchFields);
            if (patchedSubscription == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(patchedSubscription, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
