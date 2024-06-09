package co.edu.uco.subscriptionapi.service.billing.impl;

import co.edu.uco.subscriptionapi.courier.MessageSenderBroker;
import co.edu.uco.subscriptionapi.domain.billing.BillingProcess;
import co.edu.uco.subscriptionapi.domain.period.Period;
import co.edu.uco.subscriptionapi.domain.person.Person;
import co.edu.uco.subscriptionapi.domain.subscription.Subscription;
import co.edu.uco.subscriptionapi.service.billing.BillingProcessService;
import co.edu.uco.subscriptionapi.service.period.PeriodService;
import co.edu.uco.subscriptionapi.service.person.PersonService;
import co.edu.uco.subscriptionapi.service.user.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillingProcessServiceImpl implements BillingProcessService {

    @Autowired
    private PeriodService periodService;

    @Autowired
    private PersonService personService;

    @Autowired
    private MyUserService userService;

    @Autowired
    MessageSenderBroker messageSenderBroker;

    /**
     * Method that initiates the billing process
     * @param subscription: required object to initiate billing
     */
    @Override
    public void execute(Subscription subscription) {

        Person person = personService.getPersonById(userService.getUserById(subscription.getUserId()).getPersonId());
        Period period = periodService.getPeriodById(subscription.getPeriodId());
        BillingProcess billingProcess = new BillingProcess(subscription, person, period);
        messageSenderBroker.sendBillingMessage(billingProcess);

    }

}
