import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
       String myBigString = "the quick brown fox jumped over the lazy dog";
        String [] splitString = myBigString.split(" ");
        System.out.println(Arrays.toString(splitString));

        String myBigString2 = "Mississippi";
        System.out.println(Arrays.toString(myBigString2.split("s")));

        String myBigString3 = "Palak Paneer";
        System.out.println(myBigString3.substring(6));
        System.out.println(myBigString2.substring(1,5));

        String myBigString4 = "Boblasticboom";
        Pattern p = Pattern.compile("Bo(.*?)om");
        Matcher m = p.matcher(myBigString4);

        while(m.find()){
            System.out.println(m.group(1));
        }
    }
}
