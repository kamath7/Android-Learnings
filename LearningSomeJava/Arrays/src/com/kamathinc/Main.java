package com.kamathinc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //Arrays
        int[] myFavoriteNumbers = {69,7,10,18,17};
        for (int i = 0; i < myFavoriteNumbers.length; i ++){
            System.out.println(myFavoriteNumbers[i]);
        }
        System.out.println(myFavoriteNumbers[1]);

        //ArrayList

        List list = new ArrayList();
        list.add(0,"Great food!");
        list.add(1, "Awesome Ambience!");
        list.add(2,"Garbage service");

        System.out.println(list.get(1));
        list.remove(2);
        System.out.println(list.toString());

        List favoriteFoods = new ArrayList();
        favoriteFoods.add(0,"Palak Paneer");
        favoriteFoods.add(1,"Paneer Pulav");
        favoriteFoods.add(2,"Rasmalai");

        System.out.println(favoriteFoods.toString());
        favoriteFoods.remove(1);
        System.out.println(favoriteFoods.toString());

        Map map = new HashMap();
        map.put("Captain","Dhoni");
        map.put("Batsman","Rohit");
        map.put("Bowler","Bumrah");
        System.out.println(map.get("Captain"));
        map.remove("Bowler");
        System.out.println(map);
    }
}
