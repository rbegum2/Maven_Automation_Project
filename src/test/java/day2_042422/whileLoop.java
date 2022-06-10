package day2_042422;

public class whileLoop {
    public static void main(String[] args) {
        // iterate through zipcode and its streetNumber using linear array and while loop

        String[] zipCodes = new String[]{"11218","11219", "11232"};
        int[] houseNumber = new int[]{111,222,333};

        //initialize your starting point before calling while loop
        int i=0;
        //define the end point in while loop
        while(i < houseNumber.length){

            System.out.println("My zip code is "+ zipCodes[i] + " house number " + houseNumber[i]);

            //incrementing
            i = i +1;

        }// end while loop

    }// end of main method

}// end of java class
