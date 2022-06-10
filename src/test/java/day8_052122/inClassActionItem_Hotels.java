package day8_052122;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class inClassActionItem_Hotels {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen");
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);

        ArrayList<String> location = new ArrayList<>();
        location.add("Las Vegas");
        location.add("New York");
        location.add("New Jersey");

        ArrayList<String> checkInDate = new ArrayList<>();
        checkInDate.add("Jun 10, 2022");
        checkInDate.add("Jul 1, 2022");
        checkInDate.add("Jul 20, 2022");

        ArrayList<String> checkOutDate = new ArrayList<>();
        checkOutDate.add("Jun 14, 2022");
        checkOutDate.add("Jul 5, 2022");
        checkOutDate.add("Jul 27, 2022");

        ArrayList<Integer> travelers = new ArrayList<>();
        travelers.add(3);
        travelers.add(4);
        travelers.add(5);

     //   for(int i=0; i<location.size();i++) {

            driver.navigate().to("https://www.hotels.com/");
            Thread.sleep(2000);

            //web element for location search box
            try{
                WebElement searchBox = driver.findElement(By.xpath("//*[@aria-label='Going to']"));
                searchBox.click();
                Thread.sleep(2000);
                WebElement searchInput = driver.findElement(By.xpath("//*[@id='location-field-destination']"));
                searchInput.click();
              //  searchInput.sendKeys(location.get(i));
                searchInput.sendKeys("New York");
                Thread.sleep(2000);

            }catch (Exception e){
                System.out.println(" Unable to locate search field " + e);
            }// end of try catch for search field

            try {
                WebElement searchOption1 = driver.findElements(By.xpath("//*[@data-stid='location-field-destination-result-item']")).get(0);
                searchOption1.click();
            }catch (Exception e){
                System.out.println("Unable to select search option 1" + e);
            }// end of try catch for search dropdown

            // select check in date
            try{
                driver.findElement(By.id("d1-btn")).click();
             //   driver.findElement(By.xpath("//*[@aria-label='"+checkInDate.get(i)+"']")).click();
                driver.findElement(By.xpath("//*[@aria-label='Jun 14, 2022']")).click();

            }catch (Exception e){
                System.out.println("line74" + e);
            }
            // select check out date
            try{
           //     driver.findElement(By.xpath("//*[@aria-label='"+checkOutDate.get(i)+"']")).click();
                driver.findElement(By.xpath("//*[@aria-label='Jun 20, 2022']")).click();
                Thread.sleep(1000);
                //click done
                driver.findElement(By.xpath("//*[@data-stid='apply-date-picker']")).click();
            }catch (Exception e){
                System.out.println("line 84" + e);
            }

            // add travelers
            try{
                driver.findElements(By.xpath("//*[@class='uitk-fake-input uitk-form-field-trigger']")).get(1).click();
                Thread.sleep(1000);
               WebElement addTraveler = driver.findElements(By.xpath("//*[@class='uitk-layout-flex-item uitk-step-input-touch-target']")).get(1);
                addTraveler.click();

            }catch(Exception e){
                System.out.println("line 95"+ e);
            }

            try{
                //click done for travelers
                driver.findElement(By.xpath("//*[@class='uitk-button uitk-button-large uitk-button-fullWidth uitk-button-has-text uitk-button-primary uitk-button-floating-full-width']")).click();
            }catch(Exception e){
                System.out.println("line 101"+ e);
            }

            try {
               // click search button
                driver.findElement(By.xpath("//*[@data-testid='submit-button']")).click();
                Thread.sleep(2000);
            } catch(Exception e){
        System.out.println("line 108"+ e);
    }

            //click on first link
        try{
            driver.findElements(By.xpath("//*[@class='listing__link uitk-card-link']")).get(0).click();
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //within the second tab
            driver.switchTo().window(tabs.get(1));

            String resortName = driver.findElement(By.xpath("//*[@class='uitk-heading-3']")).getText();
            System.out.println("My resort name is " + resortName);
        }catch (Exception e){

        }
        //scroll down the page and capture price
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement price = driver.findElements(By.xpath("//*[@class='uitk-text uitk-type-600 uitk-type-bold uitk-text-emphasis-theme']")).get(0);
       // jse.executeScript()




        //   }// end of for loop
       // driver.quit();
    }//end of main method
}// end of java class
