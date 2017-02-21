package socialMedia.generators.relationships;

import socialMedia.Relationships.Likes;
import socialMedia.Relationships.Member;
import socialMedia.nodes.Group;
import socialMedia.nodes.Person;
import socialMedia.nodes.Post;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * Created by zaharacw on 2/9/17.
 */
public class MemberGenerator
{
    private Random rand = new Random();

    public MemberGenerator()
    {
        //Intentionally blank
    }

    public ArrayList<Member> generateMemeberList(ArrayList<Person> people, Group group, int mean, int min)
    {
        int count = 0;
        int attempts = 0;
        int goal = (int)(rand.nextGaussian() * ((mean - min) / 4) + mean);

        if (goal < min)
        {
            goal = min;
        }

        HashSet<Person> set = new HashSet<>();

        while(count < goal && attempts < people.size())
        {
            Person member = people.get(rand.nextInt(people.size()));

            if(member.getAccountCreated().compareTo(group.getCreatedOn()) >= 0)
            {
                if (set.add(member))
                {
                    count++;
                }
            }
            attempts++;
        }

        ArrayList<Person> list = new ArrayList<>(set);
        ArrayList<Member> members = new ArrayList<>();

        for(Person p : list)
        {
            members.add(new Member(p, group));
        }

        return members;
    }
}
