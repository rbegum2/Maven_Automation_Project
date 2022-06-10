package day3_043022;

public class multiple_conditional_statements {
    public static void main(String[] args) {

        int a = 1;
        int b = 2;
        int c = 3;

        // if a+b is less than c then print the result
        // if a+b is greater than c then print the result
        // finally print a+b is equal to c
        if(a+b <c){
            System.out.println("a & b is less than c");
        } else if (a+b >c){
            System.out.println("a & b is greater than c");
        }else{
            System.out.println("a & b is equal to c");
        }// end of conditions

        // declare additional variables
        int d = 4;
        int e = 5;
        int f = 6;
        // or operator with if statement at least one has to be true for the condition to return
        if(d<e || f<e){
            System.out.println();
        }else {
            System.out.println();
        }

        // and operator && both of the con
        if(d < e && f<e){
            System.out.println("");
        }else{
            System.out.println();
        }

    }//end of main method
}// end of java class
