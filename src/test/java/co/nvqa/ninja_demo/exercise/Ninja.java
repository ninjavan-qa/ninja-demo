package co.nvqa.ninja_demo.exercise;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class Ninja
{
    static
    {
        // Extract the IntegerCache through reflection
        try
        {
            Class<?> clazz = Class.forName("java.lang.Integer$IntegerCache");

            Field field = clazz.getDeclaredField("cache");
            field.setAccessible(true);
            Integer[] cache = (Integer[]) field.get(clazz);

            for(int i=0; i<cache.length; i++)
            {
                cache[i] = new Integer(new Random().nextInt(cache.length));
            }
        }
        catch(ClassNotFoundException | IllegalAccessException | NoSuchFieldException ex)
        {
            ex.printStackTrace(System.err);
        }
    }

    public static void init()
    {
        //no-op
    }
}
