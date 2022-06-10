package AutomationPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class bpManageSubscriptions {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.brainpop.com/subscription/");
        Thread.sleep(2000);
        driver.findElement(By.id("subscription_log_in_link")).click();
        Thread.sleep(2000);
        //login to bp
        driver.findElement(By.id("login")).sendKeys("prod128");
        driver.findElement(By.id("password")).sendKeys("brainpop1");
        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(3000);

        //verify text choose your profile
    //   String title = driver.findElement(By.cssSelector("h1[class='title]")).getText();
    //    System.out.println(title);
        driver.findElement(By.xpath("//button[@class='avatar-container selectable']")).click();

       //  driver.quit();
    }// end of main method

}// end of java class
