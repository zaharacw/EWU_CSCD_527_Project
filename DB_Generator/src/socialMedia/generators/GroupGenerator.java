package socialMedia.generators;

import socialMedia.utilityStructs.CustomDate;
import socialMedia.nodes.Group;
import socialMedia.nodes.Person;
import socialMedia.enums.Topic;

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
}
