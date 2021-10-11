import org.junit.Test;

public class MainClassTest {
    @Test
    public void myFirstTest()
    {
        int a = this.getLocalNumber();

        System.out.println(a);
        if (a > 10) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }

    }
    public int getLocalNumber()
    {

        return 14;
    }



}

