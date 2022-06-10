package day2_042422;

import java.util.ArrayList;

public class ForLoop {
    public static void main(String[] args) {
        // create an arrayList for cities and loop through all the values using for loop
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Brooklyn");
        cities.add("Queens");
        cities.add("Bronx");
        cities.add("Long Island");
        cities.add("Staten Island");

        for(int i=0; i< cities.size(); i++){
            //i++ = incrementing by 1 (adding 0+1=1 , 1+1 =2, 2+1 = 3)
            System.out.println("i is now " + i);
            System.out.println("My city is " + cities.get(i));


        }// end of for loop

    }// end main method

}// end java class
