package co.edu.uco.subscriptionapi.service.billing;

import co.edu.uco.subscriptionapi.domain.subscription.Subscription;

public interface BillingProcessService {

    public void execute(Subscription subscription);

}
