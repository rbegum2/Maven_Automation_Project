package ReusableClasses;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Reusable_Actions_Loggers {
    //set a static timeout variable so it can cover all explicit for all methods
    public static int timeout = 30;

    //resuable function for webdriver as a return method
    public static WebDriver setDriver(){
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-maximized");
        //for mac use full screen
        //options.addArguments("start-fullscreen");
        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }//end of setDriver method

    //create a mouse hover method
    public static void mouseHover(WebDriver driver,String xpath,ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        Actions actions = new Actions(driver);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
            logger.log(LogStatus.PASS,"Successfully hovered over element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to hover on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to hover on element " + elementName + " " + e);
        }
    }//end of mouseHover

    //create a click method
    public static void clickAction(WebDriver driver,String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
            logger.log(LogStatus.PASS,"Successfully clicked on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click on element " + elementName + " " + e);
        }
    }//end of clickAction

    //create a submit method
    public static void submitAction(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.submit();
            logger.log(LogStatus.PASS,"Successfully submit on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to submit on element " + elementName + " " + e);
        }
    }//end of submit


    //create a sendkeys method
    public static void sendKeysAction(WebDriver driver, String xpath, String userValue, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
            element.clear();
            element.sendKeys(userValue);
            logger.log(LogStatus.PASS,"Successfully enter user value on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to send keys to element " + elementName + " " + e);
        }
    }//end of sendkeys method
    public static void sendKeysIndexAction(WebDriver driver, String xpath, String userValue, int index ,ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index);
            element.click();
            element.clear();
            element.sendKeys(userValue);
            logger.log(LogStatus.PASS,"Successfully enter user value on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to send keys to element " + elementName + " " + e);
        }
    }//end of sendkeys method

    //create a getText method
    public static String getTextAction(WebDriver driver,String xpath,ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        String result = "";
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            result = element.getText();
            logger.log(LogStatus.PASS,"Successfully capture text on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to capture text on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to capture text on element " + elementName + " " + e);
        }
        return result;
    }//end of getTextAction method

    //create a click by index method
    public static void clickByIndexAction(WebDriver driver,String xpath, int indexNumber, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            element.click();
            logger.log(LogStatus.PASS, "Successfully clicked on element index " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click on element index " + elementName + " " + e);
        }
    }//end of clickByIndexAction

    // create a selectByText method
    public static void selectByText(WebDriver driver, String xpath, String visibleText, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);

        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            Select elementDropdown = new Select(element);
            elementDropdown.selectByVisibleText(visibleText);
            logger.log(LogStatus.PASS,"");
        }catch (Exception e){
            System.out.println("Unable to select element by text "+ elementName + " "+ e);
            logger.log(LogStatus.FAIL,"Unable to select element by text "+ elementName + " "+ e);
        }// end of try/catch for selectByText
    }// end of selectByText method

    // create a switchToTabByIndex method
    public static void switchToTabByIndex(WebDriver driver, int tabIndex){
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabIndex));
    }// end of switchToTabByIndex method

    // create a verifyTitle method
    public static void verifyTitleAction(WebDriver driver, ExtentTest logger, String expectedTitle ){
        String actualTitle = driver.getTitle();
        if(actualTitle.contains(expectedTitle)){
            System.out.println("My title matches the expected condition");
            logger.log(LogStatus.PASS, "My title matches the expected condition");
        }else {
            System.out.println("Title doesn't match, actual title is "+ actualTitle);
            logger.log(LogStatus.FAIL,"Title doesn't match, actual title is "+ actualTitle);
        }// end of if else for verify title
    } // end of verifyTitle method


    // boolean is checkout selected
    public static void verifyIsSelected(WebDriver driver, String xpath, Boolean expected, ExtentTest logger, int radioButtonIndex, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try {
            boolean elementState = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))).get(radioButtonIndex).isSelected();

            if (expected == elementState){
                System.out.println("Is element selected?" + elementState);
            } else{
                System.out.println("Is element selected " + elementState);
            }// end of if conditional

            logger.log(LogStatus.PASS, "Successfully verified radio button is selected" + elementName);
        }catch (Exception e){
            System.out.println("Unable to locate radio button "+ elementName + " "+ e);
            logger.log(LogStatus.FAIL,"Unable to locate radio button "+ elementName + " "+ e);

        }// end of try catch for verify is selected
    }// end of verify if checkbox selected method

    // boolean to verify
    //scrollMethod
    public static void scrollToElementAction(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        //add explicit wait
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        // declare javascript executor variable
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        // declare element you want to scroll to
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            jse.executeScript("arguments[0].scrollIntoView(true);",element);
            logger.log(LogStatus.PASS, "Successfully scrolled to element "+ elementName);
        }catch (Exception e){
            System.out.println("Unable to scroll to element " + elementName+ " " +e);
            logger.log(LogStatus.FAIL, "Unable to scroll to element " + elementName+ " " +e);
        }

    }//end of scrollAction


    public static void verifyStatusOfElement(WebDriver driver, String xpath, Boolean expectedStatus, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try {
            Boolean actualStatus = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='checkbox']"))).isSelected();
            if (expectedStatus == actualStatus) {
                logger.log(LogStatus.PASS, "Checkbox is selected as expected");
            } else {
                logger.log(LogStatus.FAIL, "Checkbox is not selected");
            }// end of if else
        }catch(Exception e){
            logger.log(LogStatus.FAIL,"Unable to verify status of element "+ elementName+" "+ e);
        }//end of try catch
    }// end of verify status of boolean checkbox

}//end of java class
