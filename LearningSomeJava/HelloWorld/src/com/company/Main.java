package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
     //Printing a simple Hello World
        System.out.println("Hello Kams!");

    //variables
        int a = 10;
        int myFavoriteNumber = 69;
        double someOtherNumber = 45.57;
        System.out.println("My fav number "+myFavoriteNumber);
        System.out.println("Another type "+someOtherNumber);
        System.out.println();

        boolean isChild = true;
        boolean userHatesPineAppleonPizza = true;

        String firstName = "Adithya";
        String lastName = "Kamath";
        int age = 25;
        System.out.println("First Name: "+firstName+" Last Name:"+lastName+". I'm "+age+" years old!");

       //Operations

        double a1 = 2.5;
        double a2 = 3.0;

        System.out.println(a1+a2);

        String someString = "The quick brown fox jumped over the lazy dog";
        System.out.println(someString.length());
        System.out.println("Total characters in fullName -> "+(firstName.length() + lastName.length()));
    }
}
