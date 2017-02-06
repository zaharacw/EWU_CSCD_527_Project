package socialMedia.enums;

/**
 * Created by zaharacw on 2/5/17.
 */
public enum Content
{
    TEXT(1, "Text"),
    VIDEO(2, "Video"),
    IMAGE(3, "Image"),
    LINE(4, "Link");

    private int id;
    private String name;

    Content (int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public int getId()
    {
        return id;
    }

    public static Content of(int id)
    {
        for(Content c : Content.values())
        {
            if(c.getId() == id)
            {
                return c;
            }
        }

        throw new IllegalArgumentException("Content ID must be between 1 and 4 inclusive");
    }
}
