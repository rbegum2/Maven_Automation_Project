package day11_052922;

import ReusableLibraries.Reusable_Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class USPS_List_webelement {
    // declare the local driver outside so that it can be reuseble with other annotation methods
    WebDriver driver;

    //before suite will set the driver you are using
    @BeforeSuite
    public void SetChromeDriver(){
        driver= Reusable_Actions.setDriver();
    }// end of before suite annotation
    @AfterSuite
    public void quitSession(){
        driver.quit();
    }//end of after suite

    @Test()
    public void USPS_Tabs_Count() throws InterruptedException {
        driver.navigate().to("https://www.usps.com");
        Thread.sleep(1500);
        //declare explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        //store the navifation tabs as a list  to get the count
        List<WebElement> tabsCount = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[contains(@class,'menuheader')]")));
        System.out.println("tabs count is "+ tabsCount.size());

        for (int i=0; i<tabsCount.size();i++){
            driver.navigate().to("https://www.usps.com");
            //store the navifation tabs as a list  to get the count
    //        List<WebElement> tabsCount2 = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[contains(@class,'menuheader')]")));
            //click on each tab
     //       tabsCount2.get(i).click();

            // can also redefine the list (best practice)
            tabsCount = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[contains(@class,'menuheader')]")));
            tabsCount.get(i).click();
        }
    }// end of test



}// end of java class
