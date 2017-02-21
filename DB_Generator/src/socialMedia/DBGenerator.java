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
import socialMedia.generators.structures.KeySetGenerator;
import socialMedia.generators.structures.NameGenerator;
import socialMedia.nodes.Group;
import socialMedia.nodes.Person;
import socialMedia.nodes.Post;
import socialMedia.utilityStructs.KeySet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * Created by zaharacw on 2/5/17.
 */
public class DBGenerator
{
    private int people;
    private int groups;
    private int posts;
    private int friendsPerPerson;
    private int friendGroups;
    private int friendSingles;
    private int friendGroupMin = 5;
    private int friendGroupMean;
    private int groupMin = 5;
    private int likeMean;
    private PersonGenerator personGen;

    public DBGenerator(int people, int friendsPerPerson, int friendGroupMean, int groups, int posts,
                       String maleNameFile, String femaleNameFile, String surnameFile)
    {
        this.people = people;
        this.friendsPerPerson = friendsPerPerson;
        this.friendGroupMean = friendGroupMean;
        this.groups = groups;
        this.posts = posts;
        this.personGen = new PersonGenerator(
                new NameGenerator(new KeySetGenerator(maleNameFile)),
                new NameGenerator(new KeySetGenerator(femaleNameFile)),
                new NameGenerator(new KeySetGenerator(surnameFile)));
        this.likeMean = this.posts / this.people * 4;

        this.friendGroups = (this.people * this.friendsPerPerson) /
                (this.friendGroupMean * (this.friendGroupMean - 1));

        this.friendSingles = (this.people * this.friendsPerPerson) / 2;
    }

    public ArrayList<Person> generatePeople()
    {
        return personGen.createPeople(1, people);
    }

    public ArrayList<Group> generateGroups(ArrayList<Person> people)
    {
        return GroupGenerator.generateGroups(1, groups, people);
    }

    public ArrayList<Post> generatePosts(ArrayList<Person> people)
    {
        return PostGenerator.generatePosts(1, posts, people);
    }

    public ArrayList<Friends> generateFriends(ArrayList<Person> people)
    {

        HashSet<Friends> set = new HashSet<>();
        FriendsGenerator generator = new FriendsGenerator();

        for (int i = 0; i < friendGroups; i++)
        {
            set.addAll(generator.generateFriendGroup(people, friendGroupMean, friendGroupMin));
        }

/*        for (int i = 0; i < friendSingles; i++)
        {
            set.addAll(generator.generateRandomFriendship(people));
        }*/

        return new ArrayList<>(set);
    }

    public ArrayList<Likes> generateLikes(ArrayList<Person> people, ArrayList<Post> posts)
    {
        HashSet<Likes> set = new HashSet<>();
        LikesGenerator generator = new LikesGenerator();

        for (Person p : people)
        {
            set.addAll(generator.generateLikesList(p, posts, likeMean));
        }

        return new ArrayList<>(set);
    }

    public ArrayList<Member> generateMembers(ArrayList<Person> people, ArrayList<Group> groups)
    {
        HashSet<Member> set = new HashSet<>();
        MemberGenerator generator = new MemberGenerator();

        for (Group g : groups)
        {
            set.addAll(generator.generateMemeberList(people, g, friendsPerPerson, groupMin));
        }

        return new ArrayList<>(set);
    }
}
