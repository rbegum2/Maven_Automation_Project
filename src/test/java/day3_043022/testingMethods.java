package day3_043022;

import ReusableLibraries.reuseableMethods;

public class testingMethods {
    public static void main(String[] args) {
        //call the add two number method and execute it

        reuseableMethods.addTwoNumbers(20,30);

        //call the return method and store it in a variable to perform something else
        int finalResult = reuseableMethods.subtractTwoNumber(20,30);
        System.out.println("New result is " + ((finalResult) + 10));

    }// end of main method
}// end of java class
