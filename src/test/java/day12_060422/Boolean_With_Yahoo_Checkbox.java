package day12_060422;

import ReusableClasses.Reusable_Actions_Loggers;
import ReusableClasses.Reusable_Annotations_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Boolean_With_Yahoo_Checkbox extends Reusable_Annotations_Class {

    @Test(priority =1 )
    public void Yahoo_Stay_Signed_In_Checkbox_Verification(){
        //navigate to usps
        driver.navigate().to("https://www.yahoo.com");
        //click on Sign in
        Reusable_Actions_Loggers.clickAction(driver,"//*[text()='Sign in']",logger,"Sign In");
        Reusable_Actions_Loggers.verifyStatusOfElement(driver,"//input[@type='checkbox']",true,logger,"checkbox");

    }//end of test

    @Test(priority = 2)
    public void NavigateToYahooHome(){
        //navigate to
        logger.log(LogStatus.INFO,"Navigate to page");
        driver.navigate().to("https://www.yahoo.com");
    }//end of test


}//end of class



