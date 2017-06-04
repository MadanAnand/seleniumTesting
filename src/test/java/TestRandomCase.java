import java.util.Random;


public class TestRandomCase {

public static int returnOneRand()
{
            Random randomno = new Random();
                return randomno.nextInt(6);
            // check next int value
            //System.out.println("Next int value: " + randomno.nextInt(4));

    }
}