package socialMedia.Relationships;

import socialMedia.nodes.Person;

/**
 * Created by zaharacw on 2/5/17.
 */
public class Friends implements Comparable<Friends>
{
    private int id1;
    private int id2;

    public Friends(Person p1, Person p2)
    {
        this(p1.getId(), p2.getId());
    }

    public Friends(int id1, int id2)
    {
        if (id1 == id2)
        {
            throw new IllegalArgumentException("Friend ids must be unique");
        }

        this.id1 = Math.min(id1, id2);
        this.id2 = Math.max(id1, id2);
    }

    public int getId1()
    {
        return id1;
    }

    public int getId2()
    {
        return id2;
    }

    public String toString()
    {
        return "" + id1 + "," + id2;
    }

    public int compareTo(Friends friend)
    {
        int result = this.id1 - friend.getId1();

        if (result != 0)
        {
            return result;
        }

        return this.id2 - friend.getId2();
    }


}
