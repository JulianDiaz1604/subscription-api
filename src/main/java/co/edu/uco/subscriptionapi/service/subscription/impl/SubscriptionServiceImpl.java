package co.edu.uco.subscriptionapi.service.subscription.impl;

import co.edu.uco.subscriptionapi.domain.subscription.Subscription;
import co.edu.uco.subscriptionapi.domain.subscription.SubscriptionDetails;
import co.edu.uco.subscriptionapi.domain.subscription.SubscriptionRequest;
import co.edu.uco.subscriptionapi.repository.SubscriptionRepository;
import co.edu.uco.subscriptionapi.repository.entity.SubscriptionEntity;
import co.edu.uco.subscriptionapi.service.billing.BillingProcessService;
import co.edu.uco.subscriptionapi.service.mappers.SubscriptionMapper;
import co.edu.uco.subscriptionapi.service.subscription.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Autowired
    BillingProcessService billingProcessService;

    private SubscriptionMapper mapper = new SubscriptionMapper();

    @Override
    public ArrayList<Subscription> getSubscriptionListByUserId(UUID id) {
        return mapper.toDTOList(subscriptionRepository.getSubscriptionListByUserId(id));
    }

    @Override
    public ArrayList<SubscriptionDetails> getSubscriptionDetailsList() {
        return subscriptionRepository.getSubscriptionDetails();
    }

    @Override
    public Subscription saveSubscription(SubscriptionRequest subscriptionRequest) {
        Subscription subscription = billingProcessService.execute(subscriptionRequest);
        subscription.setStatus("Active");
        SubscriptionEntity subscriptionEntity = mapper.toEntity(subscription);
        ArrayList<Subscription> subscriptions = getSubscriptionListByUserId(subscriptionRequest.getUserId());
        subscriptions.forEach(sub -> {
            sub.setStatus("Inactive");
            subscriptionRepository.save(mapper.toEntity(sub));
        });
        subscriptionRepository.save(subscriptionEntity);
        return subscription;
    }

    @Override
    public Subscription updateSubscription(Subscription subscription) {
        SubscriptionEntity subscriptionEntity = mapper.toEntity(subscription);
        return mapper.toDTO(subscriptionRepository.save(subscriptionEntity));
    }

    @Override
    public Subscription patchSubscription(UUID id, Map<?, Object> patchFields) {
        Subscription subscription = mapper.toDTO(subscriptionRepository.findById(id).get());
        if (patchFields.containsKey("status")){
            String value = (String) patchFields.get("status");
            subscription.setStatus(value);
        }
        if (patchFields.containsKey("startDate")){
            LocalDateTime value = LocalDateTime.parse((String) patchFields.get("startDate"));
            subscription.setStartDate(value);
        }
        if (patchFields.containsKey("endDate")){
            LocalDateTime value = LocalDateTime.parse((String) patchFields.get("endDate"));
            subscription.setEndDate(value);
        }
        SubscriptionEntity subscriptionEntity = mapper.toEntity(subscription);
        return mapper.toDTO(subscriptionRepository.save(subscriptionEntity));
    }

    @Override
    public void deleteSubscription(UUID id) {
        subscriptionRepository.deleteById(id);

    }

}
