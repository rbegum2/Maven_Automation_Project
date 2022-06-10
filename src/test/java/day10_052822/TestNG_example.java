package day10_052822;

import ReusableLibraries.Reusable_Actions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNG_example {

    // declare the local driver outside so that it can be reusaeble with other annotation methods
    WebDriver driver;

    //before suite will set the driver you are using
    @BeforeSuite
    public void SetChromeDriver(){
        driver= Reusable_Actions.setDriver();
    }// end of before suite annotation

    //test case 1: navigate to google and enter a keyword on search field
    @Test(priority=1)
    public void SearchForKeyword(){
            driver.navigate().to("https://www.google.com");
            //enter keyword on search field
            Reusable_Actions.sendKeysAction(driver, "//*[@name='q']", "BMW", "Search Field");
            //submit the go button
            Reusable_Actions.submitAction(driver, "//*[@name='btnk']", "Google search button");
        }// end of test 1

    @Test(dependsOnMethods = "SearchForKeyword")
    public void CaptureSearchNumber(){
        //capture search result
        String result= Reusable_Actions.getTextAction(driver,"//*[@id='result-stats']","Search Result Text");
        //split the results by space and print out the search number
        String[] arrayResult = result.split(" ");
        System.out.println("Search number is "+ arrayResult[1]);
    }//end of test 2

    @AfterSuite
    public void quitSession(){
        driver.quit();
    }//end of after suite

}// end of java class
