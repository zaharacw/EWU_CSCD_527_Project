package socialMedia.nodes;

import socialMedia.enums.State;
import socialMedia.utilityStructs.CustomDate;

/**
 * Created by zaharacw on 2/5/17.
 */
public class Person
{
    private int id;
    private int age;
    private State state;
    private CustomDate birthday;
    private CustomDate accountCreated;

    public Person(int id, State state, CustomDate birthday, CustomDate created)
    {
        this.id = id;
        this.state = state;
        this.birthday = birthday;
        this.accountCreated = created;
        this.age = this.birthday.getAge();
    }

    public CustomDate getAccountCreated()
    {
        return accountCreated;
    }

    public int getId()
    {
        return id;
    }

    public String toString()
    {
        return "" + id + ","
                + state.getId() + ","
                + birthday.toString() + ","
                + age + ","
                + accountCreated.toString();
    }
}
