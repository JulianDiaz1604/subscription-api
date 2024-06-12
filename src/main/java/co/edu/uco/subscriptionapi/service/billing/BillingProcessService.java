package co.edu.uco.subscriptionapi.service.billing;

import co.edu.uco.subscriptionapi.domain.subscription.Subscription;
import co.edu.uco.subscriptionapi.domain.subscription.SubscriptionRequest;

public interface BillingProcessService {

    Subscription execute(SubscriptionRequest subscription);

}
