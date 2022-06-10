package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class automationAI04 {

    /*create an array list store 3 zipCodes, using for loop through steps
    Test Steps:
1.Navigate to weightwatchers.com
2. Click on Attend dropdown on top left of the page
3 Click on Unlimited Workshops from the dropdown
4 On Next page click on Studio link
5. Clear the field and enteryour zipcode //this is where you pass your zipCode.get(i)
6. Click on Search arrow
7. Click on the specific link for the studios //you can use findElements with get() command locating by common property
**use if condition so for each iteration I you are clicking on different studio link. For instance, if i == 0 then click on second
studio link
**fi== 1 then click on the third studio link
*if i == 2 then click on first (0) studio link
** you will be storing your driver.findElments in WebElement variable to click on studio link on multiple if conditions for three
different zipcode //you can use this on one single try catch exception since you are location same findElements just the index
number is different based on your if conditions
7. Capture the entire address on a variable and print out the address
8. Now scroll to the bottom using JavascriptExecutor and then I want you to capture the entire table with days and hours for
the virtual studio and print it out on another separate print statement inside separate try catch
     */
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> zipCodes = new ArrayList<>();
        zipCodes.add("11003");
        zipCodes.add("22031");
        zipCodes.add("07424");

        // step 1:
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-fullscreen");
        WebDriver driver = new ChromeDriver(options);

        for(int i=0; i < zipCodes.size(); i++) {
            driver.navigate().to("https://www.weightwatchers.com/");
            //driver.manage().window().fullscreen();
            Thread.sleep(1000);

            // step 2: click on attend dropdown with try catch
            try{
                WebElement attendDropdown = driver.findElements(By.xpath("//*[@class='Button_button__KL9SJ MenuItem_menu-item__link__wdunp SecondaryMenu_menuItem__Ri9kt Button_button--no-style__N0tw6']")).get(0);
                attendDropdown.click();
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println("Unable to location Attend dropdown "+ e);
            }// end of try catch for attend dropdown

        // step 3 click on Unlimited Workshops from the dropdown
            try {
               WebElement unlimitedWorkshops =  driver.findElement(By.xpath("//*[@data-e2e-name='unlimited_workshops']"));
               unlimitedWorkshops.click();
               Thread.sleep(1000);
            }catch (Exception e){
                System.out.println("Unable to locate Unlimited Workshops " + e);
            }// end of try catch for unlimited workshops

        // step 4: click on studio link
            try {
                WebElement studioLink = driver.findElement(By.xpath("//*[text()='Studio']"));
                studioLink.click();

            }catch (Exception e){
                System.out.println("Unable to locate studio link " + e);
            }//end of try catch for studio link

        //step 5: Clear the field and enteryour zipcode
            try{
                WebElement searchField = driver.findElement(By.id("location-search"));
                searchField.click();
                searchField.clear();
                searchField.sendKeys(zipCodes.get(i));

            }catch (Exception e){
                System.out.println("Unable to locate search field "+ e);
            }// end of try catch for search field
        //Step 6: Click on Search arrow
            try{
                WebElement searchArrow = driver.findElement(By.id("location-search-cta"));
                searchArrow.click();
                Thread.sleep(1000);
            }catch(Exception e){
                System.out.println("Unable to locate search arrow " + e);
            }// end of try catch for search arrow
        // step 7: Click on the specific link for the studios
            try{
                WebElement specificLink1 = driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(0);
                WebElement specificLink2= driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(1);
                WebElement specificLink3= driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(2);
                if (i==0){
                    specificLink2.click();
           //         System.out.println("clicked on link 2");
                } else if(i==1){
                    specificLink3.click();
               //     System.out.println("clicked on link 3");
                } else if(i==2){
                    specificLink1.click();
            //       System.out.println("clicked on link 1");
                }
            }catch(Exception e){
                System.out.println("Unable to locate specific link " + e);
            }// end of try catch for clicking on specific link

        // step 8:  Capture the entire address on a variable and print out the address
            try {
                String getText = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
                String [] getAddress = getText.split("Studio");

                System.out.println("Entire address is: " + getAddress[0]) ;
            }catch (Exception e){
                System.out.println("Unable to locate address text "+ e);
            }// end of try catch for get address

        //step 9: Now scroll to the bottom using JavascriptExecutor and then I want you to capture the entire table with days and hours for
            //the virtual studio and print it out on another separate print statement inside separate try catch

            try {
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                WebElement virtualStudioText = driver.findElement(By.id("virtualWorkshopSchedule"));
                jse.executeScript("arguments[0].scrollIntoView(true);",virtualStudioText);
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println("Unable to locate virtual studio schedule " + e);
            }// end of try catch for scroll to element

            try{
                WebElement scheduleContainer = driver.findElements(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).get(1);
                String schedule = scheduleContainer.getText();
                System.out.println("The virtual studio schedule is: "+ "\n" + schedule);
            }catch (Exception e){
                System.out.println("Unable to locate schedule " + e);
            }// end of try catch for printing schedule

        }//end of for loop
        driver.quit();
    }// end of main method
}// end of java class
