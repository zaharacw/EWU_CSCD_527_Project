package socialMedia;

import socialMedia.Relationships.Friends;
import socialMedia.Relationships.Likes;
import socialMedia.Relationships.Member;
import socialMedia.generators.nodes.GroupGenerator;
import socialMedia.generators.nodes.PersonGenerator;
import socialMedia.generators.nodes.PostGenerator;
import socialMedia.generators.relationships.FriendsGenerator;
import socialMedia.generators.relationships.LikesGenerator;
import socialMedia.generators.relationships.MemberGenerator;
import socialMedia.nodes.Group;
import socialMedia.nodes.Person;
import socialMedia.nodes.Post;

import java.util.ArrayList;
import java.util.HashSet;
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

    public ArrayList<Person> generatePeople()
    {
        return PersonGenerator.createPeople(1, people);
    }

    public ArrayList<Group> generateGroups(ArrayList<Person> people)
    {
        return GroupGenerator.generateGroups(1, groups, people);
    }

    public ArrayList<Post> generatePosts(ArrayList<Person> people)
    {
        return PostGenerator.generatePosts(1, posts, people);
    }

    public ArrayList<Friends> generateFriends(ArrayList<Person> people, int groups, int singles)
    {
        HashSet<Friends> set = new HashSet<>();
        FriendsGenerator generator = new FriendsGenerator();

        for (int i = 0; i < groups; i++)
        {
            set.addAll(generator.generateFriendGroup(people, friendGroupMin, friendGroupMax));
        }

        for (int i = 0; i < singles; i++)
        {
            set.addAll(generator.generateRandomFriendship(people));
        }

        return new ArrayList<>(set);
    }

    public ArrayList<Likes> generateLikes(ArrayList<Person> people, ArrayList<Post> posts)
    {
        HashSet<Likes> set = new HashSet<>();
        LikesGenerator generator = new LikesGenerator();

        for (Person p : people)
        {
            set.addAll(generator.generateLikesList(p, posts, likeMin, likeMax));
        }

        return new ArrayList<>(set);
    }

    public ArrayList<Member> generateMembers(ArrayList<Person> people, ArrayList<Group> groups)
    {
        HashSet<Member> set = new HashSet<>();
        MemberGenerator generator = new MemberGenerator();

        for (Group g : groups)
        {
            set.addAll(generator.generateMemeberList(people, g, groupMin, groupMax));
        }

        return new ArrayList<>(set);
    }
}
