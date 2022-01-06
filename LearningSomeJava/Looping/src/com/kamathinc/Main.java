package com.kamathinc;

import java.util.ArrayList;
import java.util.List;

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

        String[] favoriteFootballers = {"Ronaldo","Vidic","Rooney"};
        for (int j = 0 ; j < favoriteFootballers.length; j++){
            System.out.println(favoriteFootballers[j]);
        }

        //Using forEach
        for(String name: favoriteFootballers){
            System.out.println(name);
        }
        List<String> myList = new ArrayList<String>();
        myList.add(0, "Paneer butter masala");
        myList.add(1, "Kulcha");
        myList.add(2, "Cashewnut pulao");

        for(String name: myList){
            System.out.println(name);
        }

    }
}
