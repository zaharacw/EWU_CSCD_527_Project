package socialMedia.generators.relationships;

import socialMedia.Relationships.Friends;
import socialMedia.nodes.Person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * Created by zaharacw on 2/9/17.
 */
public class FriendsGenerator
{
    private Random rand = new Random();

    public FriendsGenerator()
    {
        //Intentionally blank
    }

    public ArrayList<Friends> generateFriendship(Person p1, Person p2)
    {
        ArrayList<Friends> list= new ArrayList<>();

        list.add(new Friends(p1, p2));
        list.add(new Friends(p2, p1));

        return list;
    }

    public ArrayList<Friends> generateRandomFriendship(ArrayList<Person> people)
    {
        ArrayList<Friends> list= new ArrayList<>();
        Person p1 = people.get(rand.nextInt(people.size()));
        Person p2 = people.get(rand.nextInt(people.size()));

        while (p1.equals(p2))
        {
            p2 = people.get(rand.nextInt(people.size()));
        }

        list.add(new Friends(p1, p2));
        list.add(new Friends(p2, p1));

        return list;
    }

    public ArrayList<Friends> generateFriendGroup(ArrayList<Person> people, int mean, int min)
    {
        int goal = (int)(rand.nextGaussian() * ((mean - min) / 4) + mean);

        if (goal < min)
        {
            goal = min;
        }

        int count = 0;
        int attempts = 0;

        HashSet<Person> set = new HashSet<>();

        while(count < goal && attempts < people.size())
        {
            Person member = people.get(rand.nextInt(people.size()));
            if (set.add(member))
            {
                count++;
            }
            attempts++;
        }

        ArrayList<Person> peopleList = new ArrayList<>(set);
        ArrayList<Friends> list = new ArrayList<>();

        for(int i = 0; i < peopleList.size() - 1; i++)
        {
            for(int j = i + 1; j < peopleList.size(); j++)
            {
                list.addAll(generateFriendship(peopleList.get(i), peopleList.get(j)));
            }
        }

        return list;
    }
}
