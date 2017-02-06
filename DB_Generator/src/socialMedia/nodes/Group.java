package socialMedia.nodes;

import socialMedia.enums.Topic;
import socialMedia.utilityStructs.CustomDate;

/**
 * Created by zaharacw on 2/5/17.
 */
public class Group
{
    private int id;
    private CustomDate createdOn;
    private Person creator;
    private Topic topic;

    public Group (int id, CustomDate date, Person creator, Topic topic)
    {
        this.id = id;
        this.createdOn = date;
        this.creator = creator;
        this.topic = topic;
    }

    public int getId()
    {
        return id;
    }

    public String toString()
    {
        return "" + id + "," + createdOn.toString() + "," + creator.getId() + "," + topic.getId();
    }

}
