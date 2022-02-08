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

        String url = "<div class=\"lister-item-image\"> <a href=\"/name/nm0000216/?ref_=nmls_pst\"> <img alt=\"Arnold Schwarzenegger\" height=\"209\" src=\"https://m.media-amazon.com/images/M/MV5BMTI3MDc4NzUyMV5BMl5BanBnXkFtZTcwMTQyMTc5MQ@@._V1_UY209_CR13,0,140,209_AL_.jpg\" width=\"140\"> </a>        </div>";
        Pattern p1 = Pattern.compile("src=(.*?).jpg");
        Matcher m1 = p1.matcher(url);
        while(m1.find()){
            System.out.println(m1.group(1) +".jpg");
        }

        String celebName = "<div class=\"lister-item-image\">\n" +
                "<a href=\"/name/nm0000375/?ref_=nmls_pst\"> <img alt=\"Robert Downey Jr.\" height=\"209\" src=\"https://m.media-amazon.com/images/M/MV5BNzg1MTUyNDYxOF5BMl5BanBnXkFtZTgwNTQ4MTE2MjE@._V1_UX140_CR0,0,140,209_AL_.jpg\" width=\"140\">\n" +
                "</a>        </div>";
        Pattern p2 = Pattern.compile("img alt=\"(.*?)\"");
        Matcher m2 = p2.matcher(url);
        while(m2.find()){
            System.out.println(m2.group(1));
        }
    }
}
