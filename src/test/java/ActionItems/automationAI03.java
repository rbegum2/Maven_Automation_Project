package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class automationAI03 {
    /*  1. go to bing.com
        2. put few seconds to wait
        3. Enter a keyword on a search field
        4. Click on search button
        5. Wait few seconds
        6. capture the search message
        7. Split and print out only the search number for each values (on print
        statement mention which values from arraylist you are printing as well and their search numbers)
        8. Outside of the loop quit the driver
     */
    public static void main(String[] args) throws InterruptedException {


        // set up webdriver manager and chrome driver
        WebDriverManager.chromedriver().setup();
        //initiate webdriver for chrome with chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen");
      //  options.addArguments("");

        WebDriver driver = new ChromeDriver(options);


        ArrayList<String> hobbies = new ArrayList<>();
        hobbies.add("writing music");
        hobbies.add("playing basketball");
        hobbies.add("going hiking");
        hobbies.add("kite flying");
        hobbies.add("playing video games");

        for(int i = 0; i< hobbies.size(); i++) {
            // go to https://www.bing.com/
            driver.navigate().to("https://www.bing.com/");
            Thread.sleep(3000);
            // get element for search box and send keys and submit
            driver.findElement(By.id("sb_form_q")).sendKeys(hobbies.get(i));
            driver.findElement(By.id("sb_form_q")).submit();
            Thread.sleep(2500);
            //store result message in a string variable
            String searchMessage = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();

           // System.out.println(searchMessage);
            //split string variable into an array and get index for search number
            String[] messageArray = searchMessage.split(" ");
            System.out.println("My hobby is "+ hobbies.get(i)+ " and my search number is " + messageArray[0] +".");

        }// end of for loop
        driver.quit();
    }// end of main class
}// end of java class
