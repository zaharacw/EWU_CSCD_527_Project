package socialMedia.generators.nodes;

import socialMedia.enums.Gender;
import socialMedia.generators.structures.DateGenerator;
import socialMedia.generators.structures.NameGenerator;
import socialMedia.utilityStructs.CustomDate;
import socialMedia.nodes.Person;
import socialMedia.enums.State;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by zaharacw on 2/5/17.
 */
public class PersonGenerator
{
    private static final int START_BIRTH = 1950;
    private static final int END_BIRTH = 2005;
    private static final int START_ACCOUNT = 2000;

    private static Random rand = new Random();
    private NameGenerator maleNames;
    private NameGenerator femaleNames;
    private NameGenerator surnames;

    public PersonGenerator(NameGenerator maleNames, NameGenerator femaleNames, NameGenerator surnames)
    {
        this.maleNames = maleNames;
        this.femaleNames = femaleNames;
        this.surnames = surnames;
    }

    public Person createPerson(int id)
    {
        CustomDate birth = DateGenerator.generateDateBetween(START_BIRTH, END_BIRTH);
        CustomDate account = DateGenerator.generateDateAfter(Math.max(START_ACCOUNT, birth.getYear().getValue() + 10));
        State state = State.of(rand.nextInt(50) + 1);
        Gender gender = Gender.of(rand.nextInt(2) + 1);

        if (gender == Gender.MALE)
        {
            return new Person(id, maleNames.generateName(), surnames.generateName(), gender, state, birth, account);
        }

        return new Person(id, femaleNames.generateName(), surnames.generateName(), gender, state, birth, account);
    }

    public ArrayList<Person> createPeople(int startingId, int count)
    {
        ArrayList<Person> list = new ArrayList<>();

        for(int i = 0; i < count; i++)
        {
            list.add(createPerson(startingId + i));
        }

        return list;
    }
}
