import socialMedia.DBGenerator;
import socialMedia.Relationships.Friends;
import socialMedia.Relationships.Likes;
import socialMedia.Relationships.Member;
import socialMedia.enums.Content;
import socialMedia.enums.State;
import socialMedia.enums.Topic;
import socialMedia.generators.nodes.GroupGenerator;
import socialMedia.generators.nodes.PostGenerator;
import socialMedia.nodes.Group;
import socialMedia.nodes.Person;
import socialMedia.generators.nodes.PersonGenerator;
import socialMedia.nodes.Post;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by zaharacw on 2/5/17.
 */
public class Test
{
    public static void main(String [] args)
    {
        DBGenerator dbGen = new DBGenerator(100, 25, 250);
        ArrayList<Person> people = dbGen.generatePeople();
        ArrayList<Group> groups = dbGen.generateGroups(people);
        ArrayList<Post> posts = dbGen.generatePosts(people);

        ArrayList<Friends> friends = dbGen.generateFriends(people,5, 20);
        ArrayList<Likes> likes = dbGen.generateLikes(people, posts);
        ArrayList<Member> members = dbGen.generateMembers(people, groups);

        Content.toCSV("content.csv");
        State.toCSV("state.csv");
        Topic.toCSV("topic.csv");
        Person.toCSV(people, "people_test1.csv");
        Group.toCSV(groups, "groups_test1.csv");
        Post.toCSV(posts, "posts_test1.csv");
        Friends.toCSV(friends, "friends_test1.csv");
        Member.toCSV(members, "members_test1.csv");
        Likes.toCSV(likes, "likes_test1.csv");
    }
}
