package co.edu.uco.subscriptionapi.service.billing.impl;

import co.edu.uco.subscriptionapi.courier.MessageSenderBroker;
import co.edu.uco.subscriptionapi.domain.billing.BillingProcess;
import co.edu.uco.subscriptionapi.domain.period.Period;
import co.edu.uco.subscriptionapi.domain.person.Person;
import co.edu.uco.subscriptionapi.domain.plan.Plan;
import co.edu.uco.subscriptionapi.domain.subscription.Subscription;
import co.edu.uco.subscriptionapi.domain.subscription.SubscriptionRequest;
import co.edu.uco.subscriptionapi.service.billing.BillingProcessService;
import co.edu.uco.subscriptionapi.service.period.PeriodService;
import co.edu.uco.subscriptionapi.service.person.PersonService;
import co.edu.uco.subscriptionapi.service.plan.PlanService;
import co.edu.uco.subscriptionapi.service.user.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class BillingProcessServiceImpl implements BillingProcessService {

    @Autowired
    private PeriodService periodService;

    @Autowired
    private PersonService personService;

    @Autowired
    private MyUserService userService;

    @Autowired
    private PlanService planService;

    @Autowired
    MessageSenderBroker messageSenderBroker;

    /**
     * Method that initiates the billing process
     * @param subscriptionRequest: required object to initiate billing
     */
    @Override
    public Subscription execute(SubscriptionRequest subscriptionRequest) {

        Person person = personService.getPersonById(userService.getUserById(subscriptionRequest.getUserId()).getPersonId());
        Period period = periodService.getPeriodByName(subscriptionRequest.getPeriod());
        Plan plan = planService.getPlanById(subscriptionRequest.getPlanId());
        Double actualPrice = plan.getPrice();
        plan.setPrice(calculateDiscountedPrice(actualPrice, period.getDiscount()));
        Double amount = calculateAmount(actualPrice, period.getDiscount(), period.getMonths());

        Subscription subscription = new Subscription();
        subscription.setId(UUID.randomUUID());
        subscription.setUserId(subscriptionRequest.getUserId());
        subscription.setPlanId(plan.getId());
        subscription.setPeriodId(period.getId());
        subscription.setStatus("Active");
        subscription.setStartDate(LocalDateTime.now());
        subscription.setEndDate(LocalDateTime.now().plusMonths(period.getMonths()));

        BillingProcess billingProcess = new BillingProcess(subscription, person, period, plan, amount);
        messageSenderBroker.sendBillingMessage(billingProcess);

        return subscription;

    }

    private Double calculateDiscountedPrice(Double value, Double discount) {
        return value - (value * (discount / 100));
    }

    private Double calculateAmount(Double value, Double discount, int months) {
        return calculateDiscountedPrice(value, discount) * months;
    }

}
