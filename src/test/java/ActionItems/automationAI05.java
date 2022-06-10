package ActionItems;

import ReusableLibraries.Reusable_Actions;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class automationAI05 {
    public static void main(String[] args) throws InterruptedException {
        //call the webdrivers drivers from reusable methods
        WebDriver driver = Reusable_Actions.setDriver();
        // create array lists for values
        ArrayList<String> firstName = new ArrayList<>();
        firstName.add("Rumi");
        firstName.add("Sara");
        firstName.add("Sam");

        ArrayList<String> lastName = new ArrayList<>();
        lastName.add("Begum");
        lastName.add("Hart");
        lastName.add("lam");

        ArrayList<String> birthMonth = new ArrayList<>();
        birthMonth.add("June");
        birthMonth.add("July");
        birthMonth.add("August");

        ArrayList<String> birthDay = new ArrayList<>();
        birthDay.add("28");
        birthDay.add("24");
        birthDay.add("10");

        ArrayList<String> birthYear = new ArrayList<>();
        birthYear.add("1996");
        birthYear.add("1992");
        birthYear.add("1990");

        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11218");
        zipCode.add("22031");
        zipCode.add("11003");

        ArrayList<String> memberId = new ArrayList<>();
        memberId.add("12322");
        memberId.add("32233");
        memberId.add("33563");

        //iterate through arrays
        for (int i = 0; i < firstName.size(); i++) {
            //navigate to uhc.com
            driver.navigate().to("https://www.uhc.com/");
            //   Thread.sleep(2000);
            //verify homepage title contains health insurance plans
            Reusable_Actions.verifyTitleAction(driver, "Health insurance plans");
            // click on find a doctor button
            Reusable_Actions.clickActions(driver, "//*[@aria-label='Find a doctor']", "Find a doctor button");
            // click on sign in
            Reusable_Actions.clickActions(driver, "//*[@aria-label='Sign in menu']", "Sign in button");
            // click medicare plan
            Reusable_Actions.clickActions(driver, "//*[text()='Medicare plan?']","Medicare plan option");
            //switch to new tab
            Reusable_Actions.switchToTabByIndex(driver, 1);
            //click on register now
            Reusable_Actions.clickActions(driver, "//*[@class='uhc-tempo-link uhc-tempo-link--medium registerBtn ng-scope']", "Register Now");

            // first name
            Reusable_Actions.sendKeysAction(driver, "//*[@id='firstName']", firstName.get(i), "First Name");
            // last name
            Reusable_Actions.sendKeysAction(driver, "//*[@id='lastName']", lastName.get(i), "Last Name");
            //select birth month
            Reusable_Actions.selectByText(driver, "//*[@id='dob_month_input']", birthMonth.get(i), "Birth Month dropdown");
            //enter birth day
            Reusable_Actions.sendKeysAction(driver, "//*[@id='dob_day']", birthDay.get(i), "Birth day");
            //enter birth year
            Reusable_Actions.sendKeysAction(driver, "//*[@id='dob_year']", birthYear.get(i), "Birth year");
            //Enter zip code
            Reusable_Actions.sendKeysAction(driver, "//*[@id='zipCode']", zipCode.get(i), "Zipcode");
            //enter memerid
            Reusable_Actions.sendKeysAction(driver, "//*[@id='memberId']", memberId.get(i), "Member ID");
            //click continue
            Reusable_Actions.clickActions(driver, "//*[@id='submitBtn']", "Continue button");
            //capture error text
            String errorMessage = Reusable_Actions.getTextAction(driver, "//*[@id='personalInfo_errors']", "Error Message");
            System.out.println("Error message displayed is: " + errorMessage);
            //close the tab
            driver.close();

            //switch back to main tab
            Reusable_Actions.switchToTabByIndex(driver, 0);
        }// end of for loop

        Thread.sleep(3000);
        driver.quit();
    }// end of main mathod
}// end of java class
