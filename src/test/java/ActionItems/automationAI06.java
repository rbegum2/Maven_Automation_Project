package ActionItems;

import ReusableLibraries.Reusable_Actions;
import ReusableClasses.Reusable_Actions_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class automationAI06 {

    // go to brainpop.com
    // navigate to families dropdown and click family
    // click on x on modal and scroll to find the plan that fits your family
    // select best value option
    // on new tab in enter contact info
    // create username and password
    //click continue, enter payment info and click place order
    //get error message

    //declare local variable
    WebDriver driver;
    ExtentReports reports;

    ExtentTest logger;
    //set driver in before suite
    @BeforeSuite
    public void setChromeDriver(){
        driver = Reusable_Actions.setDriver();
        //define the path to the report
         reports = new ExtentReports("src/main/java/HTML_Report/Automation.html",true);
    }//end of before suite annotation

    /* use case: As a new customer I am able to navigate to the family landing page pick a plan section from the brainpop homepage */
    @Test(priority = 1)
    public void familyLandingPagePickAPlan() throws InterruptedException {
        logger = reports.startTest("familyLandingPagePickAPlan");
        //goto brainpop homepage
        driver.navigate().to("https://www.brainpop.com/");
        //hover on Families dropdown from homepage
        Reusable_Actions_Loggers.mouseHover(driver,"//*[@id='__BVID__283__BV_toggle_']",logger,"Families Dropdown on homepage");
        //click on BrainPOP Family option
        Reusable_Actions_Loggers.clickAction(driver,"//*[@id='link56']",logger,"BrainPOP Family dropdown option");
        Thread.sleep(2000);
        //click on the x to close the modal button
        Reusable_Actions_Loggers.clickAction(driver, "//*[@class='close_button button-wrapper medium']", logger,"X button to close modal");
        //scroll down to pick a plan container
        Reusable_Actions_Loggers.scrollToElementAction(driver,"//*[@class='pick_a_plan_container']",logger,"Pick a plan container");

        //Verify pick a plan header
        String pickAPlanHeader = Reusable_Actions_Loggers.getTextAction(driver,"//*[text()='Find the plan that fits your family']",logger,"Pick a Plan header ");
        String expectedHeader= "Find the plan that fits your family";
        //Assert.assertEquals("Find the plan that fits your family",pickAPlanHeader);
        if(expectedHeader.equals(pickAPlanHeader)){
            System.out.println("My header matches expected: "+ pickAPlanHeader);
            logger.log(LogStatus.PASS,"My header matches expected: "+ pickAPlanHeader);
        }else{
            System.out.println("My header does not match, my expected header is: "+ expectedHeader+ " and my actual header is: "+ pickAPlanHeader);
            logger.log(LogStatus.FAIL,"My header does not match, my expected header is: "+ expectedHeader+ " and my actual header is: "+ pickAPlanHeader);
        }
        //end the logger per test
        reports.endTest(logger);
    }// end of familyLandingPagePickAPlan test

    /* use case: As a user I am able to get to the payment page and verify the text of the BrainPOP Combo subscription (best value) from family landing page */
    @Test(dependsOnMethods = "familyLandingPagePickAPlan")
    public void checkOutBrainPOPComboYearlyOption() throws InterruptedException {
        logger = reports.startTest("Checkout BrainPOP Combo");
        //store userValues in string
        String firstName = "Rumi";
        String lastName = "Begum";
        String email = "rumib+autoTest@brainpop.com";
        String username = "rumiautotest";
        String password = "brainpop1";
        String retypePassword = "brainpop1";
        String country = "USA";
        String state = "New York";
        String zipcode= "11219";
        String creditCardNumber = "3333 3333 3333 3333";
        String expDate = "2323";
        String secCode = "232";

        // click on Start Free Trial button for BrainPOP Combo
        Reusable_Actions_Loggers.clickAction(driver,"//*[@id='buyNowButtonplanCard1']", logger, "Start Free Trial BrainPOP Combo");
        Thread.sleep(1500);
        //switch to new tab that opened
        Reusable_Actions_Loggers.switchToTabByIndex(driver,1);
        // Enter First Name
        Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@id='first_name_input']",firstName,logger,"First Name Field");
        // Enter Last Name
        Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@id='last_name_input']",lastName,logger,"Last Name Field");
        // Enter Email
        Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@id='email_input']",email,logger,"Email Field");
        // Enter Username
        Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@id='username_input']",username,logger,"Username Field");
        // Enter password
        Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@id='password_input']",password,logger,"Password Field");
        // Enter Retype Password
        Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@id='retype_password']",retypePassword,logger,"Retype Password Field");
        //click Next: Enter Payment Info button
        Reusable_Actions_Loggers.clickAction(driver,"//*[@id='goto_enter_payment_info_button']",logger,"Next: Enter payment info button");
        //country select dropdown
        Reusable_Actions_Loggers.selectByText(driver,"//*[@id='country_drop_down']",country,logger,"Country dropdown");
        //state select dropdown
        Reusable_Actions_Loggers.selectByText(driver,"//*[@id='billing_info_state_drop_down']",state,logger,"State dropdown");
        //zipcode
        Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@id='billing_info_zip_input']",zipcode,logger,"Zipcode field ");
        Thread.sleep(2000);

       // Reusable_Actions_Loggers.clickByIndexAction(driver,"//*[@class='InputElement is-empty Input Input--empty']",0,logger,"Click on credit card ");
       WebElement zipCodeField = driver.findElement(By.xpath("//*[@id='billing_info_zip_input']"));
       zipCodeField.sendKeys(Keys.TAB);
       // driver.findElements(By.xpath("//*[@class='InputElement is-empty Input Input--empty']")).get(1).sendKeys("3333 3333 3333 3333");
        // credit card number

        Reusable_Actions_Loggers.sendKeysIndexAction(driver,"//input[@name='cardnumber']",creditCardNumber,0,logger,"Credit Card Number");
        //expiration date


        Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@id='card_exp_element']",expDate,logger,"Expiration date field");
        //sexurity code
        Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@id='card_cvc_element']",secCode,logger,"Security code field ");
        // place order

        reports.endTest(logger);
    }// end of checkOutBrainPOPComboYearlyOption

    //checkout brainpop yearly subscription
    @Test(dependsOnMethods = "familyLandingPagePickAPlan")
    public void checkOutBrainPOPYearlyOption() throws InterruptedException {
        logger = reports.startTest("Checkout BrainPOP Yearly");
        //store userValues in string
        String firstName = "Rumi";
        String lastName = "Begum";
        String email = "rumib+autoTest@brainpop.com";
        String username = "rumiautotest";
        String password = "brainpop1";
        String retypePassword = "brainpop1";
        String country = "USA";
        String state = "New York";
        String zipcode = "11219";
        String creditCardNumber = "3333 3333 3333 3333";
        String expDate = "2323";
        String secCode = "232";

        // click on Start Free Trial button for BrainPOP Combo
        Reusable_Actions_Loggers.clickAction(driver, "//*[@id='buyNowButtonplanCard0']", logger, "Start Free Trial BrainPOP Yearly");
        Thread.sleep(1500);
        //switch to new tab that opened
        Reusable_Actions_Loggers.switchToTabByIndex(driver, 1);
        // Enter First Name
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id='first_name_input']", firstName, logger, "First Name Field");
        // Enter Last Name
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id='last_name_input']", lastName, logger, "Last Name Field");
        // Enter Email
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id='email_input']", email, logger, "Email Field");
        // Enter Username
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id='username_input']", username, logger, "Username Field");
        // Enter password
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id='password_input']", password, logger, "Password Field");
        // Enter Retype Password
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id='retype_password']", retypePassword, logger, "Retype Password Field");
        //click Next: Enter Payment Info button
        Reusable_Actions_Loggers.clickAction(driver, "//*[@id='goto_enter_payment_info_button']", logger, "Next: Enter payment info button");
        //country select dropdown
        Reusable_Actions_Loggers.selectByText(driver, "//*[@id='country_drop_down']", country, logger, "Country dropdown");
        //state select dropdown
        Reusable_Actions_Loggers.selectByText(driver, "//*[@id='billing_info_state_drop_down']", state, logger, "State dropdown");
        //zipcode
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id='billing_info_zip_input']", zipcode, logger, "Zipcode field ");
        Thread.sleep(2000);

        Reusable_Actions_Loggers.clickByIndexAction(driver, "//*[@class='InputElement is-empty Input Input--empty']", 0, logger, "Click on credit card ");

        //credit card number
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@aria-label='Credit or debit card number']", creditCardNumber, logger, "Credit Card Number");
        //expiration date


        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id='card_exp_element']", expDate, logger, "Expiration date field");
        //sexurity code
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id='card_cvc_element']", secCode, logger, "Security code field ");
        // place order

        reports.endTest(logger);
    }//end of checkOutBrainPOPYearlyOption
        //checkout brainpop jr yearly
        @Test(dependsOnMethods = "familyLandingPagePickAPlan")
        public void checkOutBrainPOPJRYearlyOption() throws InterruptedException {
            logger = reports.startTest("Checkout BrainPOP JR Yearly");
            //store userValues in string
            String firstName = "Rumi";
            String lastName = "Begum";
            String email = "rumib+autoTest@brainpop.com";
            String username = "rumiautotest";
            String password = "brainpop1";
            String retypePassword = "brainpop1";
            String country = "USA";
            String state = "New York";
            String zipcode = "11219";
            String creditCardNumber = "3123213213213";
            String expDate = "2323";
            String secCode = "232";

            // click on Start Free Trial button for BrainPOP Combo
            Reusable_Actions_Loggers.clickAction(driver, "//*[@id='buyNowButtonplanCard2']", logger, "Start Free Trial BrainPOP JR Yearly");
            Thread.sleep(1500);
            //switch to new tab that opened
            Reusable_Actions_Loggers.switchToTabByIndex(driver, 1);
            // Enter First Name
            Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id='first_name_input']", firstName, logger, "First Name Field");
            // Enter Last Name
            Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id='last_name_input']", lastName, logger, "Last Name Field");
            // Enter Email
            Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id='email_input']", email, logger, "Email Field");
            // Enter Username
            Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id='username_input']", username, logger, "Username Field");
            // Enter password
            Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id='password_input']", password, logger, "Password Field");
            // Enter Retype Password
            Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id='retype_password']", retypePassword, logger, "Retype Password Field");
            //click Next: Enter Payment Info button
            Reusable_Actions_Loggers.clickAction(driver, "//*[@id='goto_enter_payment_info_button']", logger, "Next: Enter payment info button");
            //country select dropdown
            Reusable_Actions_Loggers.selectByText(driver, "//*[@id='country_drop_down']", country, logger, "Country dropdown");
            //state select dropdown
            Reusable_Actions_Loggers.selectByText(driver, "//*[@id='billing_info_state_drop_down']", state, logger, "State dropdown");
            //zipcode
            Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id='billing_info_zip_input']", zipcode, logger, "Zipcode field ");
            Thread.sleep(2000);

            Reusable_Actions_Loggers.clickByIndexAction(driver, "//*[@class='InputElement is-empty Input Input--empty']", 0, logger, "Click on credit card ");

            //credit card number
            Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@aria-label='Credit or debit card number']", creditCardNumber, logger, "Credit Card Number");
            //expiration date


            Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id='card_exp_element']", expDate, logger, "Expiration date field");
            //sexurity code
            Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id='card_cvc_element']", secCode, logger, "Security code field ");
            // place order

            reports.endTest(logger);
        }//end of checkOutBrainPOPJRYearlyOption


    //checkout brainpop monthly subscription

    //checkout brainpop combo monthly

    //checkout brainpop jr monthly



   //verify Bill me yearly radio button is selected
 //   @Test(dependsOnMethods = "familyLandingPagePickAPlan")
    public void billMeYearlyIsSelected() throws InterruptedException {
        //store reports in logger
        logger = reports.startTest("Verify Bill me yearly radio button is selected ");

        //verify if Bill me yearly is selected
        Reusable_Actions_Loggers.verifyIsSelected(driver,"//*[@class='laptop radio_button']", true, logger,2,"Bill me yearly radio button");
        //end the logger per test
        reports.endTest(logger);
    }// end of billMeYearlyIsSelected


    @AfterSuite
    public void quitDriverSession(){
      //  driver.quit();
        reports.flush();
    }//end of after suite annotation


}// end of java class
