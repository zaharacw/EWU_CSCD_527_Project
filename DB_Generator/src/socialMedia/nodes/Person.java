package socialMedia.nodes;

import socialMedia.CSVWriter;
import socialMedia.enums.State;
import socialMedia.utilityStructs.CustomDate;

import java.util.ArrayList;

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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (getId() != person.getId()) return false;
        if (age != person.age) return false;
        if (state != person.state) return false;
        if (!birthday.equals(person.birthday)) return false;
        return getAccountCreated().equals(person.getAccountCreated());
    }

    @Override
    public int hashCode()
    {
        int result = getId();
        result = 31 * result + age;
        result = 31 * result + state.hashCode();
        result = 31 * result + birthday.hashCode();
        result = 31 * result + getAccountCreated().hashCode();
        return result;
    }

    public String toString()
    {
        return "" + id + ","
                + state.getId() + ","
                + birthday.toString() + ","
                + age + ","
                + accountCreated.toString();
    }

    public static void toCSV(ArrayList<Person> people, String fileName)
    {
        CSVWriter.toCSV(people.toArray(), "id,state_id,birthday,age,accountCreatedDate", fileName);
    }
}
