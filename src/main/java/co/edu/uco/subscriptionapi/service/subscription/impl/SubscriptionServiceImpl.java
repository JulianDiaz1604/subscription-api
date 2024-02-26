package co.edu.uco.subscriptionapi.service.subscription.impl;

import co.edu.uco.subscriptionapi.domain.subscription.Subscription;
import co.edu.uco.subscriptionapi.service.subscription.SubscriptionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Override
    public ArrayList<Subscription> getSubscriptionListByUserId(UUID id) {
        return new ArrayList<Subscription>();
    }

    @Override
    public Subscription saveSubscription(Subscription subscription) {
        return subscription;
    }

    @Override
    public Subscription updateSubscription(Subscription subscription) {
        return subscription;
    }

    @Override
    public void deleteSubscription(UUID id) {

    }

}
