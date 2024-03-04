package co.edu.uco.subscriptionapi.service.billing;

import co.edu.uco.subscriptionapi.domain.billing.Billing;

import java.util.UUID;

public interface BillingService {

    Billing getBillingById(UUID id);

    Billing getBySubscriptionId(UUID id);

    Billing saveBilling(Billing billing);

    void deleteBilling(UUID id);

    Billing updateBilling(Billing  billing);

}

