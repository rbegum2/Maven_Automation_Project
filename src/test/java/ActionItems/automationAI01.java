package ActionItems;
import java.util.ArrayList;
public class automationAI01 {
    /*using String country & int countryCode with for loop and ArrayList
    create at least 4 data for each variable and iterate through each to print out the i for both variables
    */
    public static void main(String[] args) {
        ArrayList<String> country = new ArrayList<>(); // creating the array for variable country
        country.add("Spain"); // index 0 - adding values to the array
        country.add("USA"); //1
        country.add("Canada");//2
        country.add("India"); //3
        country.add("Bangladesh");//4

        ArrayList<Integer> countryCode = new ArrayList<>(); // wrapper class is Integer instead of int
        countryCode.add(34);
        countryCode.add(1);
        countryCode.add(1);
        countryCode.add(91);
        countryCode.add(880);

        for(int i =0; i < country.size(); i++){

            System.out.println("My country is " + country.get(i) + " and my country code is +" + countryCode.get(i) + ".");

        } // end of for loop

        /* Using String[] region & int[] areaCode with while loop and linear array
        create at least 4 data for each variable and iterate through each to print out the i for both variables
        * */

        String[] region = new String[]{"New Jersey","New York","Los Angeles","Dallas"};

        int[] areaCode = new int[]{201,347,213,214};

        int j=0; // initializing starting point
        while (j < region.length){

            System.out.println("My region is "+ region[j]+ " and my area code is " + areaCode[j] + ".");
            j++; // increment count to iterate through array

        }// end of while loop
    }//end of main method
}//end of java class
