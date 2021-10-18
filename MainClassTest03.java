import org.junit.Test;

public class MainClassTest03 {

    String class_string =  "test content which contains substring like helloworld";
    String my_string = "Hello";
    String my_string2 = "hello";

    @Test
    public void testGetClassString()
    {
        this.getClassString();

        if ( class_string.contains(my_string) || class_string.contains(my_string2) ) {
            System.out.print(true);
        } else {
            throw new java.lang.Error("text do not contain the substring");
        }
    }


    public String getClassString()
    {
        return class_string;
    }


}

