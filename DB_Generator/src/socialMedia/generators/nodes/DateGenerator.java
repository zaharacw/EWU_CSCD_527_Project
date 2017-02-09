package socialMedia.generators.nodes;

import socialMedia.utilityStructs.CustomDate;

import java.time.Month;
import java.time.Year;
import java.util.Random;

/**
 * Created by zaharacw on 2/5/17.
 */
public class DateGenerator
{
    private static Random rand = new Random();
    private static int curYear = Year.now().getValue();

    //Inclusive, will not generate 2017
    public static CustomDate generateDateAfter(int year)
    {
        int yr = year + rand.nextInt(curYear - year - 1);

        Month month = Month.of(1 + rand.nextInt(12));

        int day = 1 + rand.nextInt(month.maxLength());

        return new CustomDate(month, day, yr);
    }

    public static CustomDate generateDateAfter(Year year)
    {
        return generateDateAfter(year.getValue());
    }

    //Inclusive
    public static CustomDate generateDateAfter(CustomDate date)
    {
        CustomDate cd = generateDateAfter(date.getYear());

        while(cd.compareTo(date) < 0)
        {
            cd = generateDateAfter(date.getYear());
        }

        return cd;
    }

    //Inclusive
    public static CustomDate generateDateBetween(int beg, int end)
    {
        int yr = beg + rand.nextInt(end - beg);

        Month month = Month.of(1 + rand.nextInt(12));

        int day = 1 + rand.nextInt(month.maxLength());

        return new CustomDate(month, day, yr);
    }
}
