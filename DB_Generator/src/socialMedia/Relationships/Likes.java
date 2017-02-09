package socialMedia.Relationships;

import socialMedia.CSVWriter;
import socialMedia.nodes.Person;
import socialMedia.nodes.Post;

import java.util.ArrayList;

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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Likes likes = (Likes) o;

        if (person != likes.person) return false;
        return post == likes.post;
    }

    @Override
    public int hashCode()
    {
        int result = person;
        result = 31 * result + post;
        return result;
    }

    public static void toCSV(ArrayList<Likes> likes, String fileName)
    {
        CSVWriter.toCSV(likes.toArray(), "person_id,post_id", fileName);
    }
}
