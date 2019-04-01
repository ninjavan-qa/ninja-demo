package co.nvqa.ninja_demo.exercise;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class WrapperClass
{
    public static void main(String[] args)
    {
        Ninja.init();

        Integer data;

        for(int i=0; i<10; i++)
        {
            data = i;
            System.out.println(data);
        }
    }
}
