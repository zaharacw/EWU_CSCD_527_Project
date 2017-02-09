package socialMedia.generators.relationships;

import socialMedia.Relationships.Likes;
import socialMedia.nodes.Person;
import socialMedia.nodes.Post;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * Created by zaharacw on 2/9/17.
 */
public class LikesGenerator
{
    private Random rand = new Random();

    public LikesGenerator()
    {
        //Intentionally blank
    }

    public Likes generate(Person person, Post [] posts)
    {
        Post post = posts[rand.nextInt(posts.length)];

        while (post.getCreatedOn().compareTo(person.getAccountCreated()) < 0)
        {
            post = posts[rand.nextInt(posts.length)];
        }

        return new Likes(person, post);
    }

    /**
     * Generates the list of posts liked by a singer person. The number of posts liked is randomly chosen between
     * min and max.
     *
     * @param person
     * @param posts
     * @param min
     * @param max
     * @return
     */
    public ArrayList<Likes> generateLikesList(Person person, ArrayList<Post> posts, int min, int max)
    {
        int count = 0;
        int attempts = 0;
        int goal = rand.nextInt(max + 1 - min) + min;

        HashSet<Post> set = new HashSet<>();

        while(count < goal && attempts < posts.size())
        {
            Post liked = posts.get(rand.nextInt(posts.size()));

            if(person.getAccountCreated().compareTo(liked.getCreatedOn()) >= 0)
            {
                if (set.add(liked))
                {
                    count++;
                }
            }
            attempts++;
        }

        ArrayList<Post> list = new ArrayList<>(set);
        ArrayList<Likes> members = new ArrayList<>();

        for(Post p : list)
        {
            members.add(new Likes(person, p));
        }

        return members;
    }
}
