package day3_043022;

import java.util.ArrayList;

public class loop_with_conditions {
    public static void main(String[] args) {
        //create an array with fruits and print only when fruit is apple or orange
        ArrayList<String>fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Grape");
        fruits.add("Strawberry");

        for(int i=0; i<fruits.size(); i++){
         /*   if(fruits.get(i) == "Apple"){
                System.out.println("My fruit is " +fruits.get(i));
            }else if (fruits.get(i) == "Grape"){
                System.out.println("My fruit is " + fruits.get(i));
            }
            */
            //with or operator
            // can use fruits.get(i).equalsIgnoreCase or .toLowerCase .toUpperCase
            /*
             if(fruits.get(i).equalsIgnoreCase("Apple") || fruits.get(i) == "Grape"){
                System.out.println("My fruit is " + fruits.get(i));
            }
             */
            if(fruits.get(i)=="Apple" || fruits.get(i) == "Grape"){
                System.out.println("My fruit is " + fruits.get(i));
            }
        }//end of for loop
    }//end of main method
}//end of java class
