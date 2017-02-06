package socialMedia.enums;

/**
 * Created by zaharacw on 2/5/17.
 */
public enum Topic
{
    FITTNESS(1, "Fitness"),
    POLITICS(2, "Politics"),
    FOOD(3, "Food"),
    MOVIES(4, "Movies"),
    TV(5, "TV"),
    SPORTS(6, "Sports"),
    MUSIC(7, "Music"),
    LITERATURE(8, "Literature"),
    CATS(9, "Cats"),
    GAMES(10, "Games");

    private int id;
    private String name;

    Topic(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public String toString()
    {
        return this.name;
    }

    public int getId()
    {
        return id;
    }

    public static Topic of(int id)
    {
        for(Topic t : Topic.values())
        {
            if(t.getId() == id)
            {
                return t;
            }
        }

        throw new IllegalArgumentException("Topic ID must be between 1 and 10 inclusive");
    }
}
