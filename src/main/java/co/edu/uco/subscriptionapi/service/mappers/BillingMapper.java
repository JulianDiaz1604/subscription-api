package co.edu.uco.subscriptionapi.service.mappers;

import co.edu.uco.subscriptionapi.domain.billing.Billing;
import co.edu.uco.subscriptionapi.repository.entity.BillingEntity;

public class BillingMapper {

    public Billing toDTO(BillingEntity billingEntity) {

        Billing billingDTO = new Billing();
        billingDTO.setId(billingEntity.getId());
        billingDTO.setAmount(billingEntity.getAmount());
        billingDTO.setEmissionDate(billingEntity.getEmissionDate());
        billingDTO.setDueDate(billingEntity.getDueDate());
        billingDTO.setSubscriptionId(billingEntity.getSubscriptionId());
        return billingDTO;

    }

    public BillingEntity toEntity(Billing billingDTO) {

        BillingEntity billingEntity = new BillingEntity();
        billingEntity.setId(billingDTO.getId());
        billingEntity.setAmount(billingDTO.getAmount());
        billingEntity.setEmissionDate(billingDTO.getEmissionDate());
        billingEntity.setDueDate(billingDTO.getDueDate());
        billingEntity.setSubscriptionId(billingDTO.getSubscriptionId());
        return billingEntity;

    }

}
