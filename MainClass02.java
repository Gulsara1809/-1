import org.junit.Test;

public class MainClass02 {
    int a = 20;
    @Test
    public void myFirstTest()
    {
       int class_number = this.getClassNumber();
        System.out.println(class_number);

    }
    public int getClassNumber()
    {

        return (a);
    }

}
