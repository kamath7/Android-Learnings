package com.kamathinc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //While loop

        int x = 0;
        while(x <=10){
            System.out.println(x);
            x+=2;
        }

        //For loop

        for (int i = 0 ; i <= 10 ; i++){
            System.out.println(i);
        }

        for (int i = 0; i <=10 ; i++){
            if (i%3 == 0 ){
                System.out.println("Ahoy! Found a multiple of 3. "+i);
            }
        }

        for (int i = 0 ; i <=10 ; i++){
            System.out.println((i*(i + 1))/2);
        }
    }
}
