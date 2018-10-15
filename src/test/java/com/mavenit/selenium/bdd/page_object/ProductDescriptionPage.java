package com.mavenit.selenium.bdd.page_object;

import com.mavenit.selenium.bdd.driver.DriverHelper;
import org.openqa.selenium.By;

public class ProductDescriptionPage  extends DriverHelper{

    public double getPriceOfSelectedProduct()
    {
        String price = driver.findElement(By.cssSelector(".product-price-wrap.prices>li")).getText().replace("£","").replace("*","");
        System.out.println("price from desc page: "+price);
        double actualPriceOf1Prod = Double.parseDouble(price);
        return actualPriceOf1Prod;
    }

    public void addToTrolley(){
        driver.findElement(By.cssSelector(".add-to-trolley-main button")).click();
        sleep(5000);
    }
    public  void goToTrolley(){
        driver.findElement(By.cssSelector(".button.button--full.xs-hidden.sm-block")).click();
        sleep(5000);
    }
}
