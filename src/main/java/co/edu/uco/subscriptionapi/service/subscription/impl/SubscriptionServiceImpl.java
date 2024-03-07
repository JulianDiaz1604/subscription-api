package co.edu.uco.subscriptionapi.service.subscription.impl;

import co.edu.uco.subscriptionapi.domain.subscription.Subscription;
import co.edu.uco.subscriptionapi.repository.SubscriptionRepository;
import co.edu.uco.subscriptionapi.repository.entity.SubscriptionEntity;
import co.edu.uco.subscriptionapi.service.mappers.SubscriptionMapper;
import co.edu.uco.subscriptionapi.service.subscription.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    SubscriptionRepository subscriptionRepository;

    private SubscriptionMapper mapper = new SubscriptionMapper();

    @Override
    public ArrayList<Subscription> getSubscriptionListByUserId(UUID id) {
        return mapper.toDTOList(subscriptionRepository.getSubscriptionListByUserId(id));
    }

    @Override
    public Subscription saveSubscription(Subscription subscription) {
        subscription.setId(UUID.randomUUID());
        SubscriptionEntity subscriptionEntity = mapper.toEntity(subscription);
        return mapper.toDTO(subscriptionRepository.save(subscriptionEntity));
    }

    @Override
    public Subscription updateSubscription(Subscription subscription) {
        SubscriptionEntity subscriptionEntity = mapper.toEntity(subscription);
        return mapper.toDTO(subscriptionRepository.save(subscriptionEntity));
    }

    @Override
    public void deleteSubscription(UUID id) {
        subscriptionRepository.deleteById(id);

    }

}
