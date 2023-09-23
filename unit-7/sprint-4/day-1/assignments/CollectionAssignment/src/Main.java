import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


    public static void main(String[] args) {
//        System.out.println("Hello world!");

        String toyNumber = "A0B0C9";

        Pattern pattern = Pattern.compile("[A-Z]{3}[0-9]{3}");
        Matcher matcher = pattern.matcher(toyNumber);
        if(!matcher.matches()){
            System.out.println("true");
        }else{
            System.out.println("false");
        }


    }
}