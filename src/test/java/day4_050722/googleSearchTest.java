package day4_050722;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class googleSearchTest {
    public static void main(String[] args) throws InterruptedException {

        //setup your chromedriver with webdriver
        WebDriverManager.chromedriver().setup();
        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver();
        //maximize the driver
        driver.manage().window().fullscreen(); // fullscreen for mac .maximize for windows
        //goto goodle home page
        driver.navigate().to("https://www.google.com");
        Thread.sleep(3000);
        //locate element for search field and type keyword "cars"
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars"); // can be //*[@name='q'] as well the * means ignore tag
        //.submit if element is blocked instead of .click (mouse click compared to keyboard enter
        //submit on google search button
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();
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


    }// }//end of main method
}//end of java class
