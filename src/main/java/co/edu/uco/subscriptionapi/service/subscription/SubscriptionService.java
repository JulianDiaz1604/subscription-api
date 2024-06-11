package co.edu.uco.subscriptionapi.service.subscription;

import co.edu.uco.subscriptionapi.domain.subscription.Subscription;
import co.edu.uco.subscriptionapi.domain.subscription.SubscriptionDetails;
import co.edu.uco.subscriptionapi.domain.subscription.SubscriptionRequest;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

public interface SubscriptionService {

    ArrayList<Subscription> getSubscriptionListByUserId(UUID id);
    ArrayList<SubscriptionDetails> getSubscriptionDetailsList();
    Subscription saveSubscription(SubscriptionRequest subscriptionRequest);
    Subscription updateSubscription(Subscription subscription);
    Subscription patchSubscription(UUID id, Map<?, Object> patchFields);
    void deleteSubscription(UUID id);


}
