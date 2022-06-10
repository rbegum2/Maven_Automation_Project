package ReusableLibraries;

public class reuseableMethods {
    //creating a void method to add two numbers
    public static void addTwoNumbers(int num1, int num2){

        System.out.println("The result of two numbers is " + (num1+num2));

    }//end of number method

    // create a return integer method to subtract two numbers
    public static int subtractTwoNumber(int a, int b){
        int result = a - b;
        System.out.println("The result of two numbers for subtraction is " + result);
        return result;

    }// end of subtract method
}//end of java class

