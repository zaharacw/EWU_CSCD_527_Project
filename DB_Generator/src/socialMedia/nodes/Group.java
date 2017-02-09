package socialMedia.nodes;

import socialMedia.CSVWriter;
import socialMedia.Relationships.Friends;
import socialMedia.enums.Topic;
import socialMedia.utilityStructs.CustomDate;

import java.util.ArrayList;

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

    public CustomDate getCreatedOn()
    {
        return createdOn;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (getId() != group.getId()) return false;
        if (!createdOn.equals(group.createdOn)) return false;
        if (!creator.equals(group.creator)) return false;
        return topic == group.topic;
    }

    @Override
    public int hashCode()
    {
        int result = getId();
        result = 31 * result + createdOn.hashCode();
        result = 31 * result + creator.hashCode();
        result = 31 * result + topic.hashCode();
        return result;
    }

    public String toString()
    {
        return "" + id + "," + createdOn.toString() + "," + creator.getId() + "," + topic.getId();
    }

    public static void toCSV(ArrayList<Group> groups, String fileName)
    {
        CSVWriter.toCSV(groups.toArray(), "id,createdOn,creator_id,topic_id", fileName);
    }

}
