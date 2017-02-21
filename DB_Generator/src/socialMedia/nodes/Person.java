package socialMedia.nodes;

import socialMedia.CSVWriter;
import socialMedia.enums.Gender;
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
    private String firstName;
    private String lastName;
    private Gender gender;
    private State state;
    private CustomDate birthday;
    private CustomDate accountCreated;

    public Person(int id, String firstName, String lastName, Gender gender, State state, CustomDate birthday,
                  CustomDate created)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
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
        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
        if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) return false;
        if (getGender() != person.getGender()) return false;
        if (state != person.state) return false;
        if (birthday != null ? !birthday.equals(person.birthday) : person.birthday != null) return false;
        return getAccountCreated() != null ? getAccountCreated().equals(person.getAccountCreated()) : person.getAccountCreated() == null;
    }

    @Override
    public int hashCode()
    {
        int result = getId();
        result = 31 * result + age;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (getGender() != null ? getGender().hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (getAccountCreated() != null ? getAccountCreated().hashCode() : 0);
        return result;
    }

    public String toString()
    {
        return "" + id + ","
                + firstName + ","
                + lastName + ","
                + state.getId() + ","
                + birthday.toString() + ","
                + age + ","
                + gender.getId() + ","
                + accountCreated.toString();
    }

    public static void toCSV(ArrayList<Person> people, String fileName)
    {
        CSVWriter.toCSV(people.toArray(), "id,first_name,last_name,state_id,birthday,age,gender_id,accountCreatedDate",
                fileName);
    }

    public Gender getGender()
    {
        return gender;
    }
}
