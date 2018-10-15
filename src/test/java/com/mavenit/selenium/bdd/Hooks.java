package com.mavenit.selenium.bdd;

import com.mavenit.selenium.bdd.driver.DriverHelper;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.net.MalformedURLException;

public class Hooks {

    private DriverHelper driverHelper = new DriverHelper();

    @Before
    public void setUp() throws MalformedURLException {
        driverHelper.openBrowser();
       // driverHelper.navigateTo(System.getProperty("url"));
        driverHelper.navigateTo("http://www.argos.co.uk");
        driverHelper.maxBrowser();
        driverHelper.applyImpWait();
        driverHelper.handleCookeis();
    }

    @After
    public void tearDown() {
        driverHelper.closeBrowser();
    }
}
