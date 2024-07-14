package com.AmazonAutomationService;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.stream.Collectors;

public class AmazonScraper {
    private WebDriver driver;

    public AmazonScraper(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getBestSellers() {
        driver.get("https://www.amazon.com/Best-Sellers/zgbs");
        List<WebElement> products = driver.findElements(By.cssSelector(".zg-item-immersion .p13n-sc-truncated"));
        return products.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getTodaysDeals() {
        driver.get("https://www.amazon.com/gp/goldbox");
        List<WebElement> products = driver.findElements(By.cssSelector(".dealTitle"));
        return products.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getNewReleases() {
        driver.get("https://www.amazon.com/gp/new-releases");
        List<WebElement> products = driver.findElements(By.cssSelector(".zg-item-immersion .p13n-sc-truncated"));
        return products.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
