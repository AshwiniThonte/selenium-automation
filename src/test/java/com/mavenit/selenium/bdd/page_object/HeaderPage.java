package com.mavenit.selenium.bdd.page_object;

import com.mavenit.selenium.bdd.driver.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPage extends DriverHelper {

    @FindBy(css = "#searchTerm")
    private WebElement searchTextbox;

    public void doSearch(String searchTerm) {
        searchTextbox.sendKeys(searchTerm);
        searchTextbox.sendKeys(Keys.ENTER);
        sleep(3000);
        /*WebElement element1 = driver.findElement(By.cssSelector(".font-condensed.search-title__term"));
        System.out.println("This element is present"+element1);*/
//        new WebDriverWait(driver,5)
//                .until(ExpectedConditions.
//                        textToBePresentInElementLocated(By.cssSelector(".font-condensed.search-title__term"), searchTerm));
    }


    public String getCurrentPageURL(){
       return driver.getCurrentUrl();
    }
}
