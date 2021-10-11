import org.junit.Test;

public class MainClass {
    @Test
    public void myFirstTest()
    {
        int a = this.getLocalNumber();

        System.out.println(a);

    }
    public int getLocalNumber()
    {

        return 14;
    }



}

