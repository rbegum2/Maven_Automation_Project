package ActionItems;
public class automationAI02_part1 {
    /* using conditional statements I want you to create a numeric variable with name as grade with some value using that variable
        using that variable I want to change the variable each time with conditions.
        90 to 100 print grade as A
        80 to less than 90 as B
        70 to less than 80 as C
        60 to less than 70 as D
        anything below 60 is F
     */
    public static void main(String[] args) {

        int grade = 70; //declare and define data type

        if(grade >= 90 && grade <=100){

            System.out.println("A");
        }else if(grade >= 80 && grade <90){

            System.out.println("B");
        }else if(grade >= 70 && grade <80){

            System.out.println("C");
        }else if(grade >= 60 && grade <70){

            System.out.println("D");
        }else {
            System.out.println("F");
        }// end of conditional
    }// end of main method
}// end of java class
