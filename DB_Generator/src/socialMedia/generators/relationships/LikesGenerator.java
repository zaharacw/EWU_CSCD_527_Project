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
     * Generates the list of posts liked by a singer person. The number of posts liked normally chosen with a mean
     * of mean and a stadard deviation of mean / 4.
     *
     * @param person
     * @param posts
     * @return
     */
    public ArrayList<Likes> generateLikesList(Person person, ArrayList<Post> posts, int mean)
    {
        int count = 0;
        int attempts = 0;
        int goal = (int)(rand.nextGaussian() * (mean / 4) + mean);

        if (goal < 0)
        {
            goal = 0;
        }

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
