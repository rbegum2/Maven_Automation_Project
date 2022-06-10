package day9_52222;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
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
        driver.navigate().to("https://www.usps.com");
        Thread.sleep(3000);


        //declare and define mouse action
        Actions mouseActions = new Actions(driver);
        //hover to send tab
        WebElement sendTab = driver.findElement(By.xpath("//*[@id='mail-ship-width']"));
        mouseActions.moveToElement(sendTab).perform();

        // click on tracking using mouse Actions
        WebElement tracking = driver.findElement(By.xpath("//*[text()='Tracking']"));
        mouseActions.moveToElement(tracking).click().perform();

        // click on tracking input field using mouse Actions
        WebElement trackingField = driver.findElement(By.xpath("//*[@id='tracking-input']"));
        mouseActions.moveToElement(trackingField).click().perform();
        mouseActions.moveToElement(trackingField).sendKeys("1234567890").perform();



    }// end of main method

}// end of java class
