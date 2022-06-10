package day4_050722;

public class splitMessage {
    public static void main(String[] args) {
        //declare string variable
        String splitMessage = "My_name_is_John";
        //declare an array of string to store the string split
        String[] splitMessageArray = splitMessage.split("_");

        //print out john to the console
        System.out.println("My first name is "+ splitMessageArray[3]);

    }// end of main method
}//end of java class
