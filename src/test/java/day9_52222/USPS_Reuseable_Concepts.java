package day9_52222;

import ReusableLibraries.Reusable_Actions;
import org.openqa.selenium.WebDriver;

public class USPS_Reuseable_Concepts  {

    public static void main(String[] args) {
        //setting the local driver to reusable setDriver method
        WebDriver driver = Reusable_Actions.setDriver();

        //navigate to usps
        driver.navigate().to("https://www.usps.com");

        //hover to the quick tools
        Reusable_Actions.mouseHover(driver,"//*[text()='Quick Tools']","Quick Tools");

        //hover to send tab
        Reusable_Actions.mouseHover(driver,"//*[@id='mail-ship-width']","Send Tab");

        //click on calculate a price
        Reusable_Actions.clickActions(driver,"//*[@class='tool-calc']","Calculate Price");

        //enter the zip code
        Reusable_Actions.sendKeysAction(driver,"//*[@id='Origin']","11218","Zip Code");

        //print out header text info
        String result = Reusable_Actions.getTextAction(driver,"//*[@class='header-usps row']","Header Info");
        System.out.println("My header info is " + result);


    }//end of main method
}// end of java class