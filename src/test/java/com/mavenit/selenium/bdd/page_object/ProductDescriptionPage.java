package com.mavenit.selenium.bdd.page_object;

import com.mavenit.selenium.bdd.driver.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductDescriptionPage  extends DriverHelper{

    @FindBy(css = ".product-price-wrap.prices>li")
     WebElement prodPriceInDesc;

    @FindBy(css =".add-to-trolley-main button")
    WebElement addToTolleyBtn;

    @FindBy(xpath = "//section[@class='pdp-pricing-module']//div//div[contains(@class,'add-to-trolley-modal')]//div[@class='ac-drawer']//a[@class='button button--full xs-hidden sm-block'][contains(text(),'Go to Trolley')]")
    WebElement goToTrolleyBtn;

    public double getPriceOfSelectedProduct()
    {
        String price = prodPriceInDesc.getText().replace("£","").replace("*","");
        System.out.println("price from desc page: "+price);
        double actualPriceOf1Prod = Double.parseDouble(price);
        return actualPriceOf1Prod;
    }

    public void addToTrolley(){
        addToTolleyBtn.click();
        sleep(2000);
    }
    public  void goToTrolley(){

        goToTrolleyBtn.click();
        sleep(5000);
    }
}
