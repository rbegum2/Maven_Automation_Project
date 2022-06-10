package ReusableLibraries;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Reusable_Actions {

    //reusable function for webdriver as return method
    //set a timeout variable so it can cover all explicit wait
    public static int timeout = 10;
    public static WebDriver setDriver(){
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
        return driver;
    }//end of setDriver

    //create a mouse hover method
    public static void mouseHover(WebDriver driver, String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
        }catch (Exception e){
            System.out.println("Unable to hover on element "+ elementName+ " "+ e);
        }// end of try/catch for mouseHover
    }// of mouseHover method

    //create a click method
    public static void clickActions(WebDriver driver, String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();
        }catch (Exception e){
            System.out.println("Unable to click on element "+ elementName + " "+ e);
        }// end of try/catch for clickAction
    }// of clickAction method
    //create a submit method
    public static void submitAction(WebDriver driver,String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.submit();
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + " " + e);
        }
    }//end of submit

    //create a sendKeysAction method
    public static void sendKeysAction(WebDriver driver, String xpath, String userValue, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();
            element.clear();
            element.sendKeys(userValue);
        }catch (Exception e){
            System.out.println("Unable to click on element "+ elementName + " "+ e);
        }// end of try/catch for sendKeysAction
    }// end of sendKeysAction method

    // create a getText method
    public static String getTextAction(WebDriver driver, String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        String result = null;
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            result =element.getText();
        }catch (Exception e){
            System.out.println("Unable to click on element "+ elementName + " "+ e);
        }// end of try/catch for getTextAction
        return result;
    }// end of getTextAction method

    //create a clickByIndexActions method
    public static void clickByIndexActions(WebDriver driver, String xpath, int indexNumber, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();
        }catch (Exception e){
            System.out.println("Unable to click on element "+ elementName + " "+ e);
        }// end of try/catch for clickByIndexActions
    }// end of clickByIndexActions method

    // create a selectByText method
    public static void selectByText(WebDriver driver, String xpath, String visibleText, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);

        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            Select elementDropdown = new Select(element);
            elementDropdown.selectByVisibleText(visibleText);

        }catch (Exception e){
            System.out.println("Unable to click on element "+ elementName + " "+ e);
        }// end of try/catch for selectByText

    }// end of selectByText method
    // create a switchToTabByIndex method
    public static void switchToTabByIndex(WebDriver driver, int tabIndex){
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabIndex));
    }// end of switchToTabByIndex method

    // create a verifyTitle method
    public static void verifyTitleAction(WebDriver driver, String expectedTitle ){
            String actualTitle = driver.getTitle();
            if(actualTitle.contains(expectedTitle)){
                System.out.println("My title matches the expected condition");
            }else {
                System.out.println("Title doesn't match, actual title is "+ actualTitle);
            }// end of if else for verify title
    } // end of verifyTitle method

    // boolean is checkout selected
    public static void verifyIsSelected(WebDriver driver, String xpath, String elementName, Boolean expected){
       WebDriverWait wait = new WebDriverWait(driver,timeout);
        try {
           boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).isSelected();

            if (expected == elementState){
                System.out.println("Is element checked?" + elementState);
            } else{
                System.out.println("Is element checked " + elementState);
            }// end of if conditional
        }catch (Exception e){
           System.out.println("Unable to locate checkbox "+ elementName + " "+ e);

       }// end of try catch for verify is selected
    }// end of verify if checkbox selected method



}//end of java class
