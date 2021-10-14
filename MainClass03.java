import org.junit.Test;

public class MainClass03 {

    String class_string =  "Hello, world";
        @Test
        public void myFirstTest()
        {
          this.getClassString();
            System.out.println(class_string);

        }
        public String getClassString()
        {

            return class_string;
        }


}
