package socialMedia.generators.structures;

import socialMedia.utilityStructs.KeySet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by zaharacw on 2/20/17.
 */
public class KeySetGenerator
{
    private String fileName;
    private int [] keyRanges;
    private int max;
    private HashMap<KeySet, String> map;

    public KeySetGenerator(String fileName)
    {
        this.fileName = fileName;
        this.map = new HashMap<>();

        this.setupKeys();
    }

    public int getMax()
    {
        return max;
    }

    public KeySet getKeySet(int value)
    {
        if (value < keyRanges[0] || value > keyRanges[keyRanges.length - 1])
        {
            throw new IllegalArgumentException("Value is not within key ranges");
        }

        int pos = Arrays.binarySearch(keyRanges, value);

        if (pos > - 1)
        {
            return new KeySet(keyRanges[pos], keyRanges[pos + 1] - 1);
        }

        return new KeySet(keyRanges[ - 2 - pos], keyRanges[ - 1 - pos] - 1);
    }

    public String getValue(int key)
    {
        return map.get(getKeySet(key));
    }

    private void setupKeys()
    {
        File inf = new File(fileName);
        Scanner fin = null;
        try
        {
            fin = new Scanner(inf);
        } catch (FileNotFoundException e)
        {
            System.out.println("Error: file \'" + fileName + "\' not found");
            System.exit(-1);
        }

        int total = fin.nextInt();
        this.keyRanges = new int[total + 1];
        fin.nextLine();
        int count = 0;

        String line = null;
        String [] splits = null;

        while(fin.hasNextLine())
        {
            line = fin.nextLine();
            splits = line.split(",");
            if (splits.length != 3)
            {
                throw new IllegalArgumentException("File is not formatted properly");
            }

            keyRanges[count] = Integer.parseInt(splits[1]);
            map.put(new KeySet(Integer.parseInt(splits[1]), Integer.parseInt(splits[2])), toCamelCase(splits[0]));

            count++;
        }

        keyRanges[count] = Integer.parseInt(splits[2]) + 1;
        max = Integer.parseInt(splits[2]);
    }

    private String toCamelCase(String s)
    {
        return ("" + s.charAt(0)).toUpperCase() + s.substring(1).toLowerCase();
    }
}
