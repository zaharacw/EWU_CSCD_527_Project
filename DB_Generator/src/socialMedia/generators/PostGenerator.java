package socialMedia.generators;

import socialMedia.enums.Content;
import socialMedia.nodes.Person;
import socialMedia.nodes.Post;
import socialMedia.utilityStructs.CustomDate;

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
}
