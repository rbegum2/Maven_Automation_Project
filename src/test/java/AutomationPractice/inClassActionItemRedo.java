package AutomationPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class inClassActionItemRedo {
    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> location = new ArrayList<>();
        location.add("");
        location.add("");
        location.add("");

        ArrayList<String> checkInDate = new ArrayList<>();
        checkInDate.add("");
        checkInDate.add("");
        checkInDate.add("");

        ArrayList<String> checkOutDate = new ArrayList<>();
        checkOutDate.add("");
        checkOutDate.add("");
        checkOutDate.add("");

        ArrayList<Integer> adultTravelers = new ArrayList<>();
        adultTravelers.add(3);
        adultTravelers.add(4);
        adultTravelers.add(5);

        //import webdiver manager,chrome options and chrome driver
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen");
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);

        // navigate to https://www.hotels.com/
        driver.navigate().to("https://www.hotels.com/");
        Thread.sleep(2000);

        //go to search input field and enter value
        try {
            WebElement goingToSearch = driver.findElement(By.xpath("//*[@aria-label='Going to']"));
            goingToSearch.click();
            goingToSearch.sendKeys("New York");
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println("Unable to locate go to search field " + e);
        }// end of try catch for go to search field

        //select first index of dropdown search options
        try{
           WebElement searchDropdownOption1 = driver.findElements(By.xpath("//*[@data-stid='location-field-destination-result-item-button']")).get(0);
           searchDropdownOption1.click();
        }catch (Exception e){
           System.out.println("Unable to locate go to search options " + e);
        }// end of try catch for go to search options

        //click on check in and select date
        try{
            WebElement checkIn = driver.findElement(By.id("d1-btn"));
            checkIn.click();
            WebElement selectCheckInDate = driver.findElement(By.xpath("//*[@aria-label='Jun 10, 2022']"));
            selectCheckInDate.click();
        }catch (Exception e){
            System.out.println("Unable to locate check in field " + e);
        }// end of try catch for check in field

        //select checkout date
        try{
            WebElement selectCheckOutDate = driver.findElement(By.xpath("//*[@aria-label='Jun 17, 2022']"));
            selectCheckOutDate.click();
        }catch (Exception e){
            System.out.println("Unable to locate checkout date " + e);
        }// end of try catch for checkout date

        //click done in date picker
        try{
            WebElement doneButtonDatePicker = driver.findElement(By.xpath("//*[@data-stid='apply-date-picker']"));
            doneButtonDatePicker.click();
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println("Unable to locate done button in date picker " + e);
        }// end of try catch for done button in date picker

        //click on travelers
        try{
            WebElement travelers = driver.findElement(By.xpath("//*[@data-testid='travelers-field-trigger']"));
            travelers.click();
        }catch (Exception e){
            System.out.println("Unable to locate travelers button " + e);
        }// end of try catch for travelers button

        //add adults to travelers
        try{

        }catch(Exception e){
            System.out.println("Unable to locate travelers button " + e);
        }// end of try catch for travelers button

    }// end of main method
}// end of java class
