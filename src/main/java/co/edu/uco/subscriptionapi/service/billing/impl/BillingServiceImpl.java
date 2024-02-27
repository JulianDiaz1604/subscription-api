package co.edu.uco.subscriptionapi.service.billing.impl;

import co.edu.uco.subscriptionapi.domain.billing.Billing;
import co.edu.uco.subscriptionapi.service.billing.BillingService;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service

public class BillingServiceImpl implements BillingService {
    @Override
    public Billing getBillingById(UUID id) {
        return new Billing();
    }

    @Override
    public Billing saveBilling(Billing billing) {
        return billing;
    }
}
