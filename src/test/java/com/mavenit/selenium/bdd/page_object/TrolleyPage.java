package com.mavenit.selenium.bdd.page_object;

import com.mavenit.selenium.bdd.driver.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class TrolleyPage extends DriverHelper {

    @FindBy(css = "select[id^='quantity']")
    private WebElement selectProdQuantity;

    @FindBy(css = ".description>strong>a")
    private WebElement prodNameInBasket;//div[@class='ProductCard__content__jGRLE xsBlock lgHidden']/h2/a/span
    /*@FindBy(xpath ="//div[contains(@class,'ProductCard__wrapper__')]//div[contains(@class,'ProductCard__details')]/div[contains(@class,'ProductCard__content__')]/h2/a")
    private WebElement prodNameInBasket;*/

    @FindBy(xpath = ".//*[@id='trolleyForm']/table/tbody/tr/td[3]")
    private WebElement prodPriceInBasketMyTrolley;

    /*@FindBy(xpath = "//div[contains(@class,'ProductCard__price__')]")
    private WebElement prodPriceInBasket;*/

    @FindBy(id = "qasSearchTerm")
    private WebElement postcodeTextbox;

    @FindBy(css = ".primary-button.btn-md.enable-storelocator-lightbox")
    private WebElement collectButton;

    @FindBy(css = ".storelocator-location-item.storelocator-location-store")
    private List<WebElement> storesWebElements;

    @FindBy(css = "button[class='primary-button'][data-el='storelocator-choose-store']")
    private WebElement chooseStoreBtn;

    @FindBy(id = "Collection_Checkout")
    private WebElement continueWithCollection;

    @FindBy(css = ".colpaynow>h4")
    private WebElement payNowBtn;

    @FindBy(css = ".message")
    private List<WebElement> messages;

    public void increaseItem(String no)
    {
        Select select = new Select(selectProdQuantity);
        select.selectByVisibleText(no);
    }

      /* public void increaseItem(String no)
    {
        Select sel = new Select(driver.findElement(By.cssSelector("select[id^='quantity']")));
        sel.selectByVisibleText(no);
    }*/

    public String getProdcutInBasket() {
        sleep(2000);
        System.out.println("actual product name is"+prodNameInBasket.getText());
        return prodNameInBasket.getText();
    }

    public double getPriceOfProductInBasket()
    {
            String price = prodPriceInBasketMyTrolley.getText().replace("£","").replace("*","");
            double actualPriceOf1ProdInTrolley = Double.parseDouble(price);
            return actualPriceOf1ProdInTrolley;

    }

    public void collect(String postcode)
    {
        postcodeTextbox.sendKeys(postcode);
        collectButton.click();
    }

    public void chooseStore(String strName)
    {

        for(WebElement storeWebelement : storesWebElements)
        {
            String storeName = storeWebelement.getText();
            //System.out.println(storeName);
            if(storeName.contains(strName))
            {
                //System.out.println("=====");
                storeWebelement.click();
                break;
                //System.out.println("==========");
            }
        }
        chooseStoreBtn.click();
    }

    public String continueWithCollection()
    {
        List<WebElement> messageLists = messages;
        for(WebElement message:messageLists)
        {
            String msg = message.getText();
            if(msg.contains("collect"))
            {
                continueWithCollection.click();
                sleep(3000);
                break;
            }
            else
            {
                closeBrowser();
            }
        }
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".colpaynow>h4")));
        String actual = payNowBtn.getText();
        return actual;
    }

/*    public List<String> nameOfProductsInTrolley()
    {
        List<String> productsNamesList = new ArrayList<>();
        for(WebElement nameWebelement: prodNamesInBasket)
        {
            String prodName = nameWebelement.getText();
            productsNamesList.add(prodName);
        }
        return productsNamesList;
    }

    public List<Double> priceOfProductsInTrolley()
    {
        List<WebElement> priceWebelements = driver.findElements(By.xpath(".//*[@id='trolleyForm']/table/tbody/tr//td[@class='price']"));
        ArrayList<Double> productsPricesList = new ArrayList<Double>();
        for(WebElement priceWebelement : priceWebelements)
        {
            double priceOfProducts = Double.parseDouble(priceWebelement.getText().replace("£",""));
            productsPricesList.add(priceOfProducts);
        }
        return productsPricesList;
    }*/

}
