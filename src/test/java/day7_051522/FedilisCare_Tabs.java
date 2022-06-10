package day7_051522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class FedilisCare_Tabs {
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

        driver.navigate().to("https://www.fideliscare.org");
        Thread.sleep(3000);

        //click on shop for a plan
        //we are clicking on index 0 because there are two elements for this xpath
        driver.findElements(By.xpath("//*[text()='Shop For a Plan']")).get(0).click();
        //wait for a bit for page to load
        Thread.sleep(1000);

        //click on medicaid managed care
        driver.findElements(By.xpath("//*[text()='Medicaid Managed Care']")).get(0).click();
        //wait for a bit
        Thread.sleep(1000);

        //click on search under find a doctor card
        driver.findElement(By.xpath("//*[@href='/findadoctor']")).click();
        Thread.sleep(1000);

        //store new tabs in an array list, we use getWindowHandles method to get a list of tabs
        ArrayList <String> tabs = new ArrayList<>(driver.getWindowHandles());
        //switch to a new tab, it should be at index 1
        driver.switchTo().window(tabs.get(1));
        //click on new search
        driver.findElement(By.xpath("//*[@class='fal fa-search-plus']")).click();
        Thread.sleep(1000);
        //close the new tab
        driver.close();
        //swirch back to the default tab
        driver.switchTo().window(tabs.get(0));
        //then click on providers card
        driver.findElement(By.xpath("//*[@class = 'fal fa-stethoscope fa-fw']")).click();
        //wait until provider card is clicked on
        Thread.sleep(1000);

        driver.quit();
    }// end of java class
}// end of main class
