package socialMedia.generators.nodes;

import socialMedia.generators.structures.DateGenerator;
import socialMedia.utilityStructs.CustomDate;
import socialMedia.nodes.Group;
import socialMedia.nodes.Person;
import socialMedia.enums.Topic;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by zaharacw on 2/5/17.
 */
public class GroupGenerator
{
    private static Random rand = new Random();

    public static Group generateGroup(int id, Person creator)
    {
        CustomDate createdOn = DateGenerator.generateDateAfter(creator.getAccountCreated());
        Topic topic = Topic.of(rand.nextInt(10) + 1);

        return new Group(id, createdOn, creator, topic);
    }

    public static ArrayList<Group> generateGroups(int startingId, int count, ArrayList<Person> people)
    {
        ArrayList<Group> list = new ArrayList<>();

        for (int i = 0; i < count; i++)
        {
            list.add(generateGroup(startingId + i, people.get(rand.nextInt(people.size()))));
        }

        return list;
    }
}
