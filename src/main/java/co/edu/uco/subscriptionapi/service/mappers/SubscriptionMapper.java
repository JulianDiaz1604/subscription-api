package co.edu.uco.subscriptionapi.service.mappers;

import co.edu.uco.subscriptionapi.domain.subscription.Subscription;
import co.edu.uco.subscriptionapi.repository.entity.SubscriptionEntity;

public class SubscriptionMapper {

    public Subscription toDTO(SubscriptionEntity subscriptionEntity) {

        Subscription subscriptionDTO = new Subscription();
        subscriptionDTO.setId(subscriptionEntity.getId());
        subscriptionDTO.setEndDate(subscriptionEntity.getEndDate());
        subscriptionDTO.setPlanId(subscriptionEntity.getPlanId());
        subscriptionDTO.setStatus(subscriptionEntity.getStatus());
        subscriptionDTO.setUserId(subscriptionEntity.getUserId());
        subscriptionDTO.setStartDate(subscriptionEntity.getStartDate());
        return subscriptionDTO;

    }

    public SubscriptionEntity toEntity(Subscription SubscriptionDTO) {

        SubscriptionEntity subscriptionEntity = new SubscriptionEntity();
        subscriptionEntity.setId(SubscriptionDTO.getId());
        subscriptionEntity.setPlanId(SubscriptionDTO.getPlanId());
        subscriptionEntity.setStatus(SubscriptionDTO.getStatus());
        subscriptionEntity.setEndDate(SubscriptionDTO.getEndDate());
        subscriptionEntity.setStartDate(SubscriptionDTO.getStartDate());
        subscriptionEntity.setUserId(SubscriptionDTO.getUserId());
        return subscriptionEntity;

    }

}
