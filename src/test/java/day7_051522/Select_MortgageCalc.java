package day7_051522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Select_MortgageCalc {
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

        //select start month from the dropdown
        WebElement startMonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));
        //define select command
      //  Select dropDown = new Select(startMonth);
        //select by visible text
   //     dropDown.selectByVisibleText("Jun");
        //select loan type from the dropdown

        //clicking on dropdown and its value if the dropdown tag is not n=under select tag
        startMonth.click();
        driver.findElement(By.xpath("//*[text()='Jun']")).click();


        WebElement loanType = driver.findElement(By.xpath("//*[@name='param[milserve]']"));
        //define select command
        Select loanTypeDropdown = new Select(loanType);
        //select by visible text
        loanTypeDropdown.selectByVisibleText("FHA");
        Thread.sleep(3000);
        driver.quit();

    }// end of main class
}// end of java class
