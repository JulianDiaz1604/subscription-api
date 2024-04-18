package co.edu.uco.subscriptionapi.domain.registration;

import co.edu.uco.subscriptionapi.domain.person.Person;
import co.edu.uco.subscriptionapi.domain.user.MyUser;

public class UserRegistrationRequest {

    private MyUser user;
    private Person person;

    public MyUser getUser() {
        return user;
    }

    public void setUser(MyUser user) {
        this.user = user;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
