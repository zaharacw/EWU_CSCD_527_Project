package socialMedia.Relationships;

import socialMedia.CSVWriter;
import socialMedia.nodes.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Friends friends = (Friends) o;

        if (getId1() != friends.getId1()) return false;
        return getId2() == friends.getId2();
    }

    @Override
    public int hashCode()
    {
        int result = getId1();
        result = 31 * result + getId2();
        return result;
    }

    public static void toCSV(ArrayList<Friends> friends, String fileName)
    {
        CSVWriter.toCSV(friends.toArray(), "id1,id2", fileName);
    }
}
