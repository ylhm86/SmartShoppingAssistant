package com.AmazonAutomationService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverSetup {
    private WebDriver driver;

    public WebDriverSetup() {
        // Initialize the SafariDriver
        this.driver = new SafariDriver();
        this.driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}