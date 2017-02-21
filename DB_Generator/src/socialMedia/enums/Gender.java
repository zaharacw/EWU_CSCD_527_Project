package socialMedia.enums;

import socialMedia.CSVWriter;

/**
 * Created by zaharacw on 2/17/17.
 */
public enum Gender
{
    MALE(1, "M", "male"),
    FEMALE(2, "F", "female");

    private int id;
    private String abv;
    private String fullName;

    Gender(int id, String abv, String fullName)
    {
        this.id = id;
        this.abv = abv;
        this.fullName = fullName;
    }

    public int getId()
    {
        return this.id;
    }

    public String toString()
    {
        return "" + id + "," + abv + "," + fullName;
    }

    public String getName()
    {
        return fullName;
    }

    public String getAbv()
    {
        return abv;
    }

    public static Gender of(int id)
    {
        for(Gender g : Gender.values())
        {
            if(g.getId() == id)
            {
                return g;
            }
        }

        throw new IllegalArgumentException("Gender ID must be between 1 and 2 inclusive: " + id);
    }

    public static void toCSV(String fileName)
    {
        CSVWriter.toCSV(Gender.values(), "id,abv,name", fileName);
    }
}
