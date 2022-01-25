import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int []someArr = {1,2,3};

        try{
            System.out.println(someArr[3]);

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Out of bounds exception "+e);
        }
        catch(Exception e){
            System.out.println("Looks like there was a problem. Error is "+e);
        }
        System.out.println("Array - "+ Arrays.toString(someArr));

    }
}
