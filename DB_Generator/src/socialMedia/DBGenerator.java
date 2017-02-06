package socialMedia;

import socialMedia.generators.GroupGenerator;
import socialMedia.generators.PersonGenerator;
import socialMedia.generators.PostGenerator;
import socialMedia.nodes.Group;
import socialMedia.nodes.Person;
import socialMedia.nodes.Post;

import java.util.Random;

/**
 * Created by zaharacw on 2/5/17.
 */
public class DBGenerator
{
    private Random rand = new Random();
    private int people;
    private int groups;
    private int posts;
    private int friendGroupMin = 5;
    private int friendGroupMax = 15;
    private int groupMin = 5;
    private int groupMax = 100;
    private int likeMin = 0;
    private int likeMax = 50;

    public DBGenerator(int people, int groups, int posts)
    {
        this.people = people;
        this.groups = groups;
        this.posts = posts;
    }

    public void setFriendGroupMin(int friendGroupMin)
    {
        this.friendGroupMin = friendGroupMin;
    }

    public void setFriendGroupMax(int friendGroupMax)
    {
        this.friendGroupMax = friendGroupMax;
    }

    public void setGroupMin(int groupMin)
    {
        this.groupMin = groupMin;
    }

    public void setGroupMax(int groupMax)
    {
        this.groupMax = groupMax;
    }

    public void setLikeMin(int likeMin)
    {
        this.likeMin = likeMin;
    }

    public void setLikeMax(int likeMax)
    {
        this.likeMax = likeMax;
    }

    public Person[] generatePeople()
    {
        Person[] p = new Person[this.people];

        for(int i = 0; i < p.length; i++)
        {
            p[i] = PersonGenerator.createPerson(i + 1);
        }

        return p;
    }

    public Group[] generateGroups(Person[] p)
    {
        Group[] g = new Group[this.groups];

        for(int i = 0; i < p.length; i++)
        {
            g[i] = GroupGenerator.generateGroup(i + 1, p[rand.nextInt(p.length)]);
        }

        return g;
    }

    public Post[] generatePosts(Person[] p)
    {
        Post[] postArray = new Post[this.posts];

        for(int i = 0; i < p.length; i++)
        {
            postArray[i] = PostGenerator.generatePost(i + 1, p[rand.nextInt(p.length)]);
        }

        return postArray;
    }

}
