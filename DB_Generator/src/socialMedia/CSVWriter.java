package socialMedia;

import socialMedia.Relationships.Friends;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Created by zaharacw on 2/9/17.
 */
public class CSVWriter
{
    public static int toCSV(Object[] objects, String header, String fileName)
    {
        File file = new File(fileName);
        PrintStream out = null;

        try
        {
            out = new PrintStream(file);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
            return -1;
        }

        out.println(header);
        for (Object o : objects)
        {
            out.println(o.toString());
        }

        return 0;
    }
}
