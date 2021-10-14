import org.junit.Test;

public class MainClassTest03 {
    String class_string =  "Hello";
    @Test
    public void testGetClassString()
    {
        this.getClassString();
        if ( class_string == "Hello" | class_string == "hello" )
        {
        System.out.println(class_string);

    }

        else { System.out.println("Тест падает");
        }
    }
    public String getClassString()
    {

        return class_string;
    }


}

