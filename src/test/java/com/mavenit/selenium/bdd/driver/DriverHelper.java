package com.mavenit.selenium.bdd.driver;

import cucumber.api.Scenario;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class DriverHelper {

    protected static WebDriver driver;
    //private String browser = System.getProperty("brows");
    private String browser = "chrome";
    private String machine = "local";

    public DriverHelper()
    {
        PageFactory.initElements(driver, this);
    }

    private void remoteRun() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser);
        driver = new RemoteWebDriver(new URL("http://192.168.170.1:4444/wd/hub"),capabilities);
    }

    public void openBrowser() throws MalformedURLException {
        switch (browser) {
            case "chrome":
                if(machine.equalsIgnoreCase("local"))
                {
                    ChromeDriverManager.getInstance().setup();
                    driver = new ChromeDriver();
                }
                else
                {
                    remoteRun();
                }
                break;
            case "ie":
                if(machine.equalsIgnoreCase("local"))
                {
                    InternetExplorerDriverManager.getInstance().setup();
                    driver = new InternetExplorerDriver();
                }
                else
                {
                    remoteRun();
                }
                break;
            case "safari":
                if(machine.equalsIgnoreCase("local")){
                    driver = new SafariDriver();
                }
                else
                {
                    remoteRun();
                }
                break;

            default:
                if(machine.equalsIgnoreCase("local")) {
                    FirefoxDriverManager.getInstance().setup();
                    driver = new FirefoxDriver();
                }
                else
                {
                    remoteRun();
                }
                break;
        }
    }

    public void closeBrowser() {
        driver.quit();
    }

    public void embedScreenshot(Scenario scenario)
    {
        try{
         byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
         scenario.embed(screenshot,"image/png");
        }
        catch(WebDriverException e)
        {
            e.getMessage();
        }
    }

    public void navigateTo(String url){
        driver.get(url);
    }

    public void maxBrowser(){
        driver.manage().window().maximize();
    }

    public void applyImpWait(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    public void sleep(int ms) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

     /*@FindBy(linkText = "GOT IT")
   private WebElement cookieBtn;*/
    public void handleCookeis(){
        driver.findElement(By.linkText("GOT IT")).click();
    }
}
