package day6_051422;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scroll_MortgageCalc {
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

        driver.navigate().to("https://www.mortgagecalculator.org");
        Thread.sleep(3000);

        //declare javascriptexecutor variable
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //scroll to pixel 400 on mortgage calc website
   //     jse.executeScript("scroll(0,800)");
        //wait a bit for browser to perform scrolling
  //      Thread.sleep(3000);

        //declare a webelement variable that we want to scroll into
        WebElement shareButton = driver.findElement(By.xpath("//*[@id='share_button']"));

        //scroll into share this calculation button
        jse.executeScript("arguments[0].scrollIntoView(true);", shareButton);
        Thread.sleep(3000);
        //click share this calculation button
        shareButton.click();
        //scroll back up
        jse.executeScript("scroll(0,-400)");

        //quit the chrome browser
       // driver.quit();
    }//end of main method
}// end of java class
