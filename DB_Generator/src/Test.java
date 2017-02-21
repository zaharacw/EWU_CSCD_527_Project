import socialMedia.DBGenerator;
import socialMedia.Relationships.Friends;
import socialMedia.Relationships.Likes;
import socialMedia.Relationships.Member;
import socialMedia.enums.Content;
import socialMedia.enums.Gender;
import socialMedia.enums.State;
import socialMedia.enums.Topic;
import socialMedia.nodes.Group;
import socialMedia.nodes.Person;
import socialMedia.nodes.Post;

import java.util.ArrayList;

/**
 * Created by zaharacw on 2/5/17.
 */
public class Test
{
    public static final String PATH ="/Users/zaharacw/Documents/EWU/CSCD/CSCD_527/EWU_CSCD_527_Project/DB_Generator/name_keys/";
/*   //xsmall output 10 friends per
    public static final String OUT = "xsmallout/";
    public static final int PEOPLE = 100;
    public static final int FRIENDS = 10;*/

/*    //small out 25 friends per
    public static final String OUT = "smallout/";
    public static final int PEOPLE = 1000;
    public static final int FRIENDS = 25;*/

/*    //med out 50 friends per
    public static final String OUT = "medout/";
    public static final int PEOPLE = 10000;
    public static final int FRIENDS = 50;*/

    //large out 50 friends per
    public static final String OUT = "largeout/";
    public static final int PEOPLE = 100000;
    public static final int FRIENDS = 50;


    public static void main(String [] args)
    {
        DBGenerator dbGen = new DBGenerator(PEOPLE, FRIENDS, FRIENDS / 4,PEOPLE / 10,
                PEOPLE * 25, PATH + "male_name_keys.csv",
                PATH + "female_name_keys.csv", PATH + "surname_keys.csv");
        ArrayList<Person> people = dbGen.generatePeople();
        ArrayList<Group> groups = dbGen.generateGroups(people);
        ArrayList<Post> posts = dbGen.generatePosts(people);

        ArrayList<Friends> friends = dbGen.generateFriends(people);
        ArrayList<Likes> likes = dbGen.generateLikes(people, posts);
        ArrayList<Member> members = dbGen.generateMembers(people, groups);

        Content.toCSV(OUT + "content.csv");
        State.toCSV(OUT + "state.csv");
        Topic.toCSV(OUT + "topic.csv");
        Person.toCSV(people, OUT + "people.csv");
        Group.toCSV(groups, OUT + "groups.csv");
        Post.toCSV(posts, OUT + "posts.csv");
        Friends.toCSV(friends, OUT + "friends.csv");
        Member.toCSV(members, OUT + "members.csv");
        Likes.toCSV(likes, OUT + "likes.csv");
        Gender.toCSV(OUT + "gender.csv");
    }
}
