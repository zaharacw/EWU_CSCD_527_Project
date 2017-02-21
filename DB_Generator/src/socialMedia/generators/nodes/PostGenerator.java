package socialMedia.generators.nodes;

import socialMedia.enums.Content;
import socialMedia.generators.structures.DateGenerator;
import socialMedia.nodes.Person;
import socialMedia.nodes.Post;
import socialMedia.utilityStructs.CustomDate;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by zaharacw on 2/5/17.
 */
public class PostGenerator
{
    private static Random rand = new Random();

    public static Post generatePost(int id, Person creator)
    {
        CustomDate createdOn = DateGenerator.generateDateAfter(creator.getAccountCreated());
        Content content = Content.of(rand.nextInt(4) + 1);

        return new Post(id, createdOn, creator, content);
    }

    public static ArrayList<Post> generatePosts(int startingId, int count, ArrayList<Person> people)
    {
        ArrayList<Post> list = new ArrayList<>();

        for (int i = 0; i < count; i++)
        {
            list.add(generatePost(startingId + i, people.get(rand.nextInt(people.size()))));
        }

        return list;
    }
}
