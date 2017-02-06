package socialMedia.nodes;

import socialMedia.enums.Content;
import socialMedia.utilityStructs.CustomDate;

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

    public String toString()
    {
        return "" + id + "," + createdOn.toString() + "," + creator.getId() + "," + content.getId();
    }

}
