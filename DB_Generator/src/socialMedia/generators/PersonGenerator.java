package socialMedia.generators;

import socialMedia.utilityStructs.CustomDate;
import socialMedia.nodes.Person;
import socialMedia.enums.State;

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

    public static Person createPerson(int id)
    {
        CustomDate birth = DateGenerator.generateDateBetween(START_BIRTH, END_BIRTH);
        CustomDate account = DateGenerator.generateDateAfter(Math.max(START_ACCOUNT, birth.getYear().getValue() + 10));
        State state = State.of(rand.nextInt(50) + 1);

        return new Person(id, state, birth, account);
    }
}
