package co.edu.uco.subscriptionapi.service.billing.impl;

import co.edu.uco.subscriptionapi.domain.billing.Billing;
import co.edu.uco.subscriptionapi.repository.BillingRepository;
import co.edu.uco.subscriptionapi.repository.entity.BillingEntity;
import co.edu.uco.subscriptionapi.service.billing.BillingService;
import co.edu.uco.subscriptionapi.service.mappers.BillingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
