import org.junit.Test;

public class MainClassTest02 {
    int a = 50;
    @Test

    public void testGetClassNumber() {
        int a = this.getClassNumber();
        System.out.println(a);
        if (a > 45) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public int getClassNumber() {

        return (a);

    }
}