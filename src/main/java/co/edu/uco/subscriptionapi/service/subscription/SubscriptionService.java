package co.edu.uco.subscriptionapi.service.subscription;

import co.edu.uco.subscriptionapi.domain.subscription.Subscription;

import java.util.ArrayList;
import java.util.UUID;

public interface SubscriptionService {

    ArrayList<Subscription> getSubscriptionListByUserId(UUID id);
    Subscription saveSubscription(Subscription subscription);
    Subscription updateSubscription(Subscription subscription);
    void deleteSubscription(UUID id);

}
