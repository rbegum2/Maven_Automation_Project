package day5_050822;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chromeoptions_GoogleSearch {

    public static void main(String[] args) throws InterruptedException {
        //setup your chromedriver with webdriver
        WebDriverManager.chromedriver().setup();
        // set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incgonito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-fullscreen");
        //for windows users full screen:
        //options.addArguments("start-maximized");
        //setting your driver as headless which means running in the background
        options.addArguments("headless");

        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);
        //maximize the driver
        //driver.manage().window().fullscreen(); // fullscreen for mac .maximize for windows
        //goto goodle home page
        driver.navigate().to("https://www.google.com");
        Thread.sleep(3000); //3 seconds
        //locate element for search field and type keyword "cars"
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars"); // can be //*[@name='q'] as well the * means ignore tag
        //.submit if element is blocked instead of .click (mouse click compared to keyboard enter
        //submit on google search button
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();
        Thread.sleep(2500);
        //capture the google search and print it
        String searchResult =  driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        //  System.out.println("Result is "+ searchResult);
        // extract out the number and print in search number only
        String[] arrayResult =searchResult.split(" ");
        String replaceParanth = arrayResult[3].replace("(","").replace(")",""); //-- get only part of an array
        // look into substring
        System.out.println("My search number is " + arrayResult[1]);


        //quit the driver
        driver.quit();


    }
}// end of java class
