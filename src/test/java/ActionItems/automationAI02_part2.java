package ActionItems;

import java.util.ArrayList;

public class automationAI02_part2 {
    /* using array, loop & conditions with the following values */
    public static void main(String[] args) {
        // create the array
        ArrayList<String> Cities = new ArrayList<>();
        Cities.add("Brooklyn");
        Cities.add("Queens");
        Cities.add("Manhattan");
        Cities.add("Staten");

        //iterate through array and print out only when city is brooklyn or manhattan
        for(int i=0; i < Cities.size(); i++){
            if(Cities.get(i) == "Brooklyn" || Cities.get(i) == "Manhattan"){
                System.out.println(Cities.get(i));
            }//end of conditional
        }//end of for loop
    }//end of main method
}// end of java class

