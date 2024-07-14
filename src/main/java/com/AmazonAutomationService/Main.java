package com.AmazonAutomationService;

import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        WebDriverSetup webDriverSetup = new WebDriverSetup();
        WebDriver driver = webDriverSetup.getDriver();
        AmazonScraper scraper = new AmazonScraper(driver);
        ChatGPTClient chatGPTClient = new ChatGPTClient();
        HTMLReportGenerator reportGenerator = new HTMLReportGenerator();

        try {
            List<String> bestSellers = scraper.getBestSellers();
            List<String> todaysDeals = scraper.getTodaysDeals();
            List<String> newReleases = scraper.getNewReleases();

            System.out.println("Best Sellers:");
            System.out.println(chatGPTClient.getChatGPTResponse(bestSellers, "Best Sellers"));

            System.out.println("Today's Deals:");
            System.out.println(chatGPTClient.getChatGPTResponse(todaysDeals, "Today's Deals"));

            System.out.println("New Releases:");
            System.out.println(chatGPTClient.getChatGPTResponse(newReleases, "New Releases"));

            String bestSellersResponse = chatGPTClient.getChatGPTResponse(bestSellers, "Best Sellers");
            String todaysDealsResponse = chatGPTClient.getChatGPTResponse(todaysDeals, "Today's Deals");
            String newReleasesResponse = chatGPTClient.getChatGPTResponse(newReleases, "New Releases");

            reportGenerator.generateReport(bestSellers, bestSellersResponse,
                    todaysDeals, todaysDealsResponse,
                    newReleases, newReleasesResponse);

            System.out.println("HTML report generated successfully.");



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            webDriverSetup.closeDriver();
        }
    }
}
