package day12_060422;

import PageObjects.BaseClass;
import org.testng.annotations.Test;

import static ReusableClasses.Reusable_Annotations_Class.driver;

public class GoogleSearch_POM {
    @Test
    public void SearchForAKeywordOnGoogleHome(){
        driver.navigate().to("https://www.google.com");
        BaseClass.googleHomePage().searchUserValue("BMW");
        BaseClass.googleHomePage().submitOnGoogleSearch();
    }//end of test

    @Test(dependsOnMethods = "SearchForAKeywordOnGoogleHome")
    public void CaptureSearchNumberFromGoogle(){
        BaseClass.googleSearchResultPage().CaptureSearchNumberAndPrintIt();
    }//end of test

}//end of java class
