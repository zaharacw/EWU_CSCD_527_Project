package socialMedia.Relationships;

import socialMedia.nodes.Person;
import socialMedia.nodes.Post;

/**
 * Created by zaharacw on 2/5/17.
 */
public class Likes
{
    private int person;
    private int post;

    public Likes(Person person, Post post)
    {
        this(person.getId(), post.getId());
    }

    public Likes(int person, int post)
    {
        this.person = person;
        this.post = post;
    }

    public String toString()
    {
        return "" + this.person + "," + this.post;
    }
}
