package co.edu.uco.subscriptionapi.service.mappers;

import co.edu.uco.subscriptionapi.domain.subscription.Subscription;
import co.edu.uco.subscriptionapi.repository.entity.SubscriptionEntity;

import java.util.ArrayList;

public class SubscriptionMapper {

    public Subscription toDTO(SubscriptionEntity subscriptionEntity) {

        Subscription subscriptionDTO = new Subscription();
        subscriptionDTO.setId(subscriptionEntity.getId());
        subscriptionDTO.setEndDate(subscriptionEntity.getEndDate());
        subscriptionDTO.setPlanId(subscriptionEntity.getPlanId());
        subscriptionDTO.setPeriodId(subscriptionEntity.getPeriodId());
        subscriptionDTO.setStatus(subscriptionEntity.getStatus());
        subscriptionDTO.setUserId(subscriptionEntity.getUserId());
        subscriptionDTO.setStartDate(subscriptionEntity.getStartDate());
        return subscriptionDTO;

    }
    public ArrayList<Subscription> toDTOList(ArrayList<SubscriptionEntity> subscriptionEntityList) {

        ArrayList<Subscription> subscriptionDTOList = new ArrayList<Subscription>();
        subscriptionEntityList.forEach(subscriptionEntity -> {
            Subscription subscriptionDTO = toDTO(subscriptionEntity);
            subscriptionDTOList.add(subscriptionDTO);
        });

        return subscriptionDTOList;

    }


    public SubscriptionEntity toEntity(Subscription SubscriptionDTO) {

        SubscriptionEntity subscriptionEntity = new SubscriptionEntity();
        subscriptionEntity.setId(SubscriptionDTO.getId());
        subscriptionEntity.setPlanId(SubscriptionDTO.getPlanId());
        subscriptionEntity.setPeriodId(SubscriptionDTO.getPeriodId());
        subscriptionEntity.setStatus(SubscriptionDTO.getStatus());
        subscriptionEntity.setEndDate(SubscriptionDTO.getEndDate());
        subscriptionEntity.setStartDate(SubscriptionDTO.getStartDate());
        subscriptionEntity.setUserId(SubscriptionDTO.getUserId());
        return subscriptionEntity;

    }

}
