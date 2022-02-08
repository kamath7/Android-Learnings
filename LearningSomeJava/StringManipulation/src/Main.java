import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
       String myBigString = "the quick brown fox jumped over the lazy dog";
        String [] splitString = myBigString.split(" ");
        System.out.println(Arrays.toString(splitString));
    }
}
