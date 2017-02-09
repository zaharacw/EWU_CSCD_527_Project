package socialMedia.enums;

import socialMedia.CSVWriter;

/**
 * Created by zaharacw on 2/5/17.
 */
public enum State
{
    AL(1, "Alabama", "AL"),
    AK(2, "Alaska", "AK"),
    AZ(3, "Arizona", "AZ"),
    AR(4, "Arkansas", "AR"),
    CA(5, "California", "CA"),
    CO(6, "Colorado", "CO"),
    CT(7, "Connecticut", "CT"),
    DE(8, "Delaware", "DE"),
    FL(9, "Florida", "FL"),
    GA(10, "Georgia", "GA"),
    HI(11, "Hawaii", "HI"),
    ID(12, "Idaho", "ID"),
    IL(13, "Illinois", "IL"),
    IN(14, "Indiana", "IN"),
    IA(15, "Iowa", "IA"),
    KS(16, "Kansas", "KS"),
    KY(17, "Kentucky", "KY"),
    LA(18, "Louisiana", "LA"),
    ME(19, "Maine", "ME"),
    MD(20, "Maryland", "MD"),
    MA(21, "Massachusetts", "MA"),
    MI(22, "Michigan", "MI"),
    MN(23, "Minnesota", "MN"),
    MS(24, "Mississippi", "MS"),
    MO(25, "Missouri", "MO"),
    MT(26, "Montana", "MT"),
    NE(27, "Nebraska", "NE"),
    NV(28, "Nevada", "NV"),
    NH(29, "New Hampshire", "NH"),
    NJ(30, "New Jersey", "NJ"),
    NM(31, "New Mexico", "NM"),
    NY(32, "New York", "NY"),
    NC(33, "North Carolina", "NC"),
    ND(34, "North Dakota", "ND"),
    OH(35, "Ohio", "OH"),
    OK(36, "Oklahoma", "OK"),
    OR(37, "Oregon", "OR"),
    PA(38, "Pennsylvania", "PA"),
    RI(39, "Rhode Island", "RI"),
    SC(40, "South Carolina", "SC"),
    SD(41, "South Dakota", "SD"),
    TN(42, "Tennessee", "TN"),
    TX(43, "Texas", "TX"),
    UT(44, "Utah", "UT"),
    VT(45, "Vermont", "VT"),
    VA(46, "Virginia", "VA"),
    WA(47, "Washington", "WA"),
    WV(48, "West Virginia", "WV"),
    WI(49, "Wisconsin", "WI"),
    WY(50, "Wyoming", "WY");

    private int id;
    private String name;
    private String abv;

    State(int id, String name, String abbreviation)
    {
        this.id = id;
        this.name = name;
        this.abv = abbreviation;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getAbv()
    {
        return abv;
    }

    public String toString()
    {

        return "" + id + "," + this.getName() + "," + this.getAbv();
    }

    public static State of(int id)
    {
        for(State s : State.values())
        {
            if(s.getId() == id)
            {
                return s;
            }
        }

        throw new IllegalArgumentException("State ID must be between 1 and 50 inclusive");
    }

    public static void toCSV(String fileName)
    {
        CSVWriter.toCSV(State.values(), "id,name,abreviation", fileName);
    }
}
