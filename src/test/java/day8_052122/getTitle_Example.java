package day8_052122;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class getTitle_Example {
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

        driver.navigate().to("https://www.google.com");
        Thread.sleep(3000);

        //capture the title of the page and compare ikt with your expected title 'GOOGLE'
        String actualTitle = driver.getTitle();
        if(actualTitle.equals("Google")){
            System.out.println("My title matches");
        }else{
            System.out.println("Title doesn't match. Actual title is "+ actualTitle);

         //   driver.findElement(By.xpath("//*[@arialabel = '"+startDate.get(i)"'));
        }// end of if else
    }// end of main method
}// end of java class
