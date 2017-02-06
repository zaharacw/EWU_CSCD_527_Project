package socialMedia.Relationships;

import socialMedia.nodes.Group;
import socialMedia.nodes.Person;
import socialMedia.nodes.Post;

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
}
