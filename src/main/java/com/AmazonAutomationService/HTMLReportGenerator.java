package com.AmazonAutomationService;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HTMLReportGenerator {

    public void generateReport(List<String> bestSellers, String bestSellersResponse,
                               List<String> todaysDeals, String todaysDealsResponse,
                               List<String> newReleases, String newReleasesResponse) throws IOException {
        StringBuilder html = new StringBuilder();
        html.append("<html><head><title>Amazon Product Report</title></head><body>");
        html.append("<h1>Amazon Product Report</h1>");

        // Best Sellers
        html.append("<h2>Best Sellers</h2>");
        html.append("<ul>");
        for (String product : bestSellers) {
            html.append("<li>").append(product).append("</li>");
        }
        html.append("</ul>");
        html.append("<h3>ChatGPT Response for Best Sellers</h3>");
        html.append("<p>").append(bestSellersResponse).append("</p>");

        // Today's Deals
        html.append("<h2>Today's Deals</h2>");
        html.append("<ul>");
        for (String product : todaysDeals) {
            html.append("<li>").append(product).append("</li>");
        }
        html.append("</ul>");
        html.append("<h3>ChatGPT Response for Today's Deals</h3>");
        html.append("<p>").append(todaysDealsResponse).append("</p>");

        // New Releases
        html.append("<h2>New Releases</h2>");
        html.append("<ul>");
        for (String product : newReleases) {
            html.append("<li>").append(product).append("</li>");
        }
        html.append("</ul>");
        html.append("<h3>ChatGPT Response for New Releases</h3>");
        html.append("<p>").append(newReleasesResponse).append("</p>");

        html.append("</body></html>");

        // Write the HTML content to a file
        try (FileWriter writer = new FileWriter("AmazonProductReport.html")) {
            writer.write(html.toString());
        }
    }
}
