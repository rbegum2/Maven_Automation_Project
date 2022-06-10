package day6_051422;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FindElementsExample {
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
        // options.addArguments("start-maximized");
        //setting your driver as headless which means running in the background
        //    options.addArguments("headless");

        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.bing.com");
        Thread.sleep(3000);

        driver.findElements(By.xpath("//li[contains(@class, 'scope')]")).get(0).click();
    }//end of main method
}// end of java class
