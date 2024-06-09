package co.edu.uco.subscriptionapi.domain.billing;

import co.edu.uco.subscriptionapi.domain.period.Period;
import co.edu.uco.subscriptionapi.domain.person.Person;
import co.edu.uco.subscriptionapi.domain.subscription.Subscription;

public class BillingProcess {

    private Subscription subscription;
    private Person person;
    private Period period;

    public BillingProcess(Subscription subscription, Person person, Period period) {
        this.subscription = subscription;
        this.person = person;
        this.period = period;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "BillingProcess{" +
                "subscription=" + subscription +
                ", person=" + person +
                ", period=" + period +
                '}';
    }

}
