package socialMedia.nodes;

import socialMedia.CSVWriter;
import socialMedia.enums.Content;
import socialMedia.utilityStructs.CustomDate;

import java.util.ArrayList;

/**
 * Created by zaharacw on 2/5/17.
 */
public class Post
{
    private int id;
    private CustomDate createdOn;
    private Person creator;
    private Content content;

    public Post(int id, CustomDate date, Person creator, Content content)
    {
        this.id = id;
        this.createdOn = date;
        this.creator = creator;
        this.content = content;
    }

    public int getId()
    {
        return id;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (getId() != post.getId()) return false;
        if (!getCreatedOn().equals(post.getCreatedOn())) return false;
        if (!creator.equals(post.creator)) return false;
        return content == post.content;
    }

    @Override
    public int hashCode()
    {
        int result = getId();
        result = 31 * result + getCreatedOn().hashCode();
        result = 31 * result + creator.hashCode();
        result = 31 * result + content.hashCode();
        return result;
    }

    public CustomDate getCreatedOn()
    {
        return createdOn;
    }

    public String toString()
    {
        return "" + id + "," + createdOn.toString() + "," + creator.getId() + "," + content.getId();
    }

    public static void toCSV(ArrayList<Post> posts, String fileName)
    {
        CSVWriter.toCSV(posts.toArray(), "id,createdOn,creator_id,content_id", fileName);
    }

}
