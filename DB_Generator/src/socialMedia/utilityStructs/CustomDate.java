package socialMedia.utilityStructs;

import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;

/**
 * Created by zaharacw on 2/5/17.
 */
public class CustomDate implements Comparable<CustomDate>
{
    private Month month;
    private int day;
    private Year year;

    public CustomDate(int month, int day, int year)
    {
        this(Month.of(month), day, year);
    }

    public CustomDate(Month month, int day, int year)
    {
        this.month = month;

        if (day > this.month.maxLength())
            throw new IllegalArgumentException("Invalid month day combination");

        this.day = day;
        this.year = Year.of(year);
    }

    public int getAge()
    {
        int age = Year.now().getValue() - this.year.getValue();

        if (YearMonth.now().getMonthValue() < this.month.getValue())
        {
            age--;
        }
        else if (YearMonth.now().getMonthValue() == this.month.getValue())
        {
            if (MonthDay.now().getDayOfMonth() < this.day)
            {
                age --;
            }
        }

        return age;
    }

    public Year getYear()
    {
        return year;
    }

    public Month getMonth()
    {
        return month;
    }

    public int getDay()
    {
        return day;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomDate that = (CustomDate) o;

        if (getDay() != that.getDay()) return false;
        if (getMonth() != that.getMonth()) return false;
        return getYear().equals(that.getYear());
    }

    @Override
    public int hashCode()
    {
        int result = getMonth().hashCode();
        result = 31 * result + getDay();
        result = 31 * result + getYear().hashCode();
        return result;
    }

    public String toString()
    {
        return "" + month.getValue() + "/" + day + "/" + year.getValue();
    }

    public int compareTo(CustomDate cd)
    {
        int result = this.year.compareTo(cd.getYear());

        if (result != 0)
        {
            return result;
        }

        result = this.month.compareTo(cd.getMonth());

        if (result != 0)
        {
            return result;
        }

        return this.day - cd.getDay();
    }
}
