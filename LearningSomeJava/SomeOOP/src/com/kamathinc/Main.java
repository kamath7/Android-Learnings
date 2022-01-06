package com.kamathinc;

public class Main {


    public static void main(String[] args) {

	// write your code here

        class Car{
            private int wheels;
            Car(){
                this.wheels = 4;
            }
            public boolean isAwesome(){
                if (wheels == 4){
                    return true;
                }
                return false;
            }
        }
        Car beetle = new Car();
        System.out.println(beetle.wheels);
        System.out.println(beetle.isAwesome());

        class Number {
            int number;

            public boolean isPositive(){
                return number > 0? true: false;
            }
        }
        Number lalleNumber = new Number();
        lalleNumber.number = 69;
        System.out.println(lalleNumber.isPositive());
    }
}
