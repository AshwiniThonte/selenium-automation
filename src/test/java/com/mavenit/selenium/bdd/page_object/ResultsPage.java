package com.mavenit.selenium.bdd.page_object;


import com.mavenit.selenium.bdd.driver.DriverHelper;
import com.mavenit.selenium.bdd.utils.UtilsHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ResultsPage extends DriverHelper {

    @FindBy(css = ".font-condensed.search-title__term")
    private WebElement prodTitle;

    @FindBy(css = ".ac-facet__label")
    private List<WebElement> filtersby;

    @FindBy(css = ".ac-star-rating")
    private List<WebElement> reviewRatings;

    /*@FindBy(css = "ac-product-card__rating")
    private List<WebElement> reviewRatings;*/

    @FindBy(css = ".icon--loading")
    private WebElement iconLoading;

    @FindBy(css = ".ac-product-price__amount")
    private List<WebElement> productPrice;

    @FindBy(css = ".font-standard.form-control.sort-select")
    private WebElement selectSortOption;

    @FindBy(css = ".ac-product-card__name")
    private List<WebElement> productName;

    public String getProductTitle() {
        sleep(5000);
        return prodTitle.getText();
    }

    public void selectFilterBy(String filterChoice) {
        for (WebElement filterElement : filtersby) {
            if (filterElement.getText().equalsIgnoreCase(filterChoice)) {
                new WebDriverWait(driver,20)
                        .until(ExpectedConditions.elementToBeClickable(filterElement));
                filterElement.click();
                break;
            }
        }
        /*new WebDriverWait(driver,30)
                .until(ExpectedConditions
                        .invisibilityOf(iconLoading));*/
        sleep(5000);
    }

    public List<Double> getAllRatingOnProducts() {
        List<Double> collectedRatingList = new ArrayList<>();
        for (WebElement filterWebelemt : reviewRatings) {
            String ratingValueInString = filterWebelemt.getAttribute("data-star-rating");
            double ratingValueInDouble = Double.parseDouble(ratingValueInString);
            collectedRatingList.add(ratingValueInDouble);
        }
        sleep(3000);
        return collectedRatingList;

    }

    public List<Double> getAllProductsPrices()  {
        List<Double> collectedPriceList = new ArrayList<>();

        List<WebElement> filterWebelements = productPrice;
        for (WebElement filterWebelement : filterWebelements) {
            double indiPrice = Double.parseDouble(filterWebelement.getText().replace("£", ""));
        }
        sleep(5000);
        return collectedPriceList;
    }

    public void selectSortingOptions(String choice) {
        Select dropDownSelect = new Select(selectSortOption);
        dropDownSelect.selectByVisibleText(choice);
        driver.manage().timeouts().pageLoadTimeout(2,TimeUnit.SECONDS);
    }

    public String selectAnyProduct() {
        List<WebElement> allProductsWebElement = productName;
        int productCount = allProductsWebElement.size();
       /* new WebDriverWait(driver,10)
                .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".ac-product-card__name"),30));
              */         //.numberOfElementsToBeMoreThan(By.cssSelector(".ac-product-card__name"),30));
        sleep(3000);
        System.out.println("total number of products count : " + productCount);
        int rdnNumber = new UtilsHelper().generateRandomNumber(1);

        WebElement indProduct = allProductsWebElement.get(rdnNumber);
        String expectedProduct = indProduct.getText();
        indProduct.click();
        sleep(4000);
        return expectedProduct;
    }
}
