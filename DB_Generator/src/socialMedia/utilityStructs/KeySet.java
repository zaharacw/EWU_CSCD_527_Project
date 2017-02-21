package socialMedia.utilityStructs;

/**
 * Created by zaharacw on 2/20/17.
 */
public class KeySet
{
    private int first;
    private int last;

    public KeySet(int first, int last)
    {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KeySet keySet = (KeySet) o;

        if (first != keySet.first) return false;
        return last == keySet.last;
    }

    @Override
    public int hashCode()
    {
        int result = first;
        result = 31 * result + last;
        return result;
    }
}
