package day2_042422;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        //create an ArrayList for countries
        ArrayList<String> countries = new ArrayList<>();
        countries.add("USA"); //0
        countries.add("Bangladesh");//1
        countries.add("India"); //2
        countries.add("Canada"); //3
        countries.add("Pakistan"); //4

        //I want to print the 4th value from the list
        System.out.println("My country is " + countries.get(3) + " and my third country is " + countries.get(2));


    }// end of main method
}// end java class

