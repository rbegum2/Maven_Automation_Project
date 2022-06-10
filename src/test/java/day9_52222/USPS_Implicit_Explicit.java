package day9_52222;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class USPS_Implicit_Explicit {
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

        //set your global implicit wait
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        //navigate to site
        driver.navigate().to("https://www.usps.com");

        //call mouse action
        Actions actions = new Actions(driver);

        //declare and define explicit wait
        WebDriverWait wait = new WebDriverWait(driver,8);

        //hover to quick tools
        WebElement quickTools = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Quick Tools']")));
        actions.moveToElement(quickTools).perform();

        //click on track package
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Track a Package']"))).click();

        //click and then type a package field
        WebElement packageField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tracking-input']")));
        packageField.click();
        packageField.sendKeys("1234567890");

    }// end of main method

}// end of java class
