import socialMedia.nodes.Person;
import socialMedia.generators.PersonGenerator;

import java.util.LinkedList;

/**
 * Created by zaharacw on 2/5/17.
 */
public class Test
{
    public static void main(String [] args)
    {
        LinkedList<Person> list = new LinkedList<>();

        for (int i = 1; i <= 10; i++)
        {
            list.add(PersonGenerator.createPerson(i));
        }

        list.stream().forEach(System.out::println);
    }
}
