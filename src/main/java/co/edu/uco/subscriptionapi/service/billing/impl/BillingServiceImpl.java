package co.edu.uco.subscriptionapi.service.billing.impl;

import co.edu.uco.subscriptionapi.domain.billing.Billing;
import co.edu.uco.subscriptionapi.domain.plan.Plan;
import co.edu.uco.subscriptionapi.repository.BillingRepository;
import co.edu.uco.subscriptionapi.repository.entity.BillingEntity;
import co.edu.uco.subscriptionapi.repository.entity.PlanEntity;
import co.edu.uco.subscriptionapi.service.billing.BillingService;
import co.edu.uco.subscriptionapi.service.mappers.BillingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.UUID;
@Service

public class BillingServiceImpl implements BillingService {

    @Autowired
    private BillingRepository billingRepository;
    private BillingMapper mapper = new BillingMapper();

    @Override
    public Billing getBillingById(UUID id) {
        return mapper.toDTO(billingRepository.findById(id).get());
    }

    @Override
    public Billing getBySubscriptionId(UUID id) {
        return mapper.toDTO(billingRepository.getBillingBySubscriptionId(id));
    }

    @Override
    public Billing saveBilling(Billing billing) {
        billing.setId(UUID.randomUUID());
        BillingEntity billingEntity = mapper.toEntity(billing);
        return mapper.toDTO(billingRepository.save(billingEntity));
    }

    @Override
    public void deleteBilling(UUID id) {
        billingRepository.deleteById(id);
    }

    @Override
    public Billing updateBilling(Billing billing) {
        BillingEntity billingEntity = mapper.toEntity(billing);
        return mapper.toDTO(billingRepository.save(billingEntity));
    }

    @Override
    public Billing patchBilling(UUID id, Map<?, Object> patchFields) {
        Billing billing = mapper.toDTO(billingRepository.findById(id).get());
        if (patchFields.containsKey("amount")){
            Double value = (Double) patchFields.get("amount");
            billing.setAmount(value);
        }
        if (patchFields.containsKey("emissionDate")){
            LocalDateTime value = LocalDateTime.parse((String) patchFields.get("emissionDate"));
            billing.setEmissionDate(value);
        }
        if (patchFields.containsKey("dueDate")){
            LocalDateTime value = LocalDateTime.parse((String) patchFields.get("dueDate"));
            billing.setDueDate(value);
        }
        BillingEntity billingEntity = mapper.toEntity(billing);
        return mapper.toDTO(billingRepository.save(billingEntity));
    }



}
