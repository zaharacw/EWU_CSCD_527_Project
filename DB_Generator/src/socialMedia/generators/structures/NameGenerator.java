package socialMedia.generators.structures;

import socialMedia.utilityStructs.KeySet;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by zaharacw on 2/20/17.
 */
public class NameGenerator
{
    private KeySetGenerator keys;
    private Random rand = new Random();

    public NameGenerator(KeySetGenerator keys)
    {
        this.keys = keys;
    }

    public String generateName()
    {
        int key = rand.nextInt(keys.getMax()) + 1;
        return keys.getValue(key);
    }
}
