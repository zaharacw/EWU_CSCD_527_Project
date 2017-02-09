package socialMedia.Relationships;

import socialMedia.CSVWriter;
import socialMedia.nodes.Group;
import socialMedia.nodes.Person;
import socialMedia.nodes.Post;

import java.util.ArrayList;

/**
 * Created by zaharacw on 2/5/17.
 */
public class Member
{
    private int person;
    private int group;

    public Member(Person person, Group group)
    {
        this(person.getId(), group.getId());
    }

    public Member(int person, int group)
    {
        this.person = person;
        this.group = group;
    }

    public String toString()
    {
        return "" + this.person + "," + this.group;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        if (person != member.person) return false;
        return group == member.group;
    }

    @Override
    public int hashCode()
    {
        int result = person;
        result = 31 * result + group;
        return result;
    }

    public static void toCSV(ArrayList<Member> members, String fileName)
    {
        CSVWriter.toCSV(members.toArray(), "person_id,group_id", fileName);
    }
}
