# SmartShoppingAssistant

This paper presents a novel automation framework designed to interface with Amazon's e-commerce platform to retrieve product lists such as Best Sellers, Today's Deals, and New Releases. The framework employs Selenium WebDriver for web automation and integrates OpenAI's ChatGPT to facilitate natural language processing and interaction. The objective is to streamline the data extraction process and enhance user interaction with e-commerce data through conversational AI.

# Table of Contents

Introduction
Features
Setup
Usage
Project Structure
Dependencies
License

# Introduction

The Amazon Automation Service is a Java application that uses Selenium WebDriver to scrape product information from Amazon and generate a structured HTML report and include a response from ChatGPT for each category. This report lists product names and prices under categories like Best Sellers, Today's Deals, and New Releases.

# Features

Scrapes Amazon for:

 Best Sellers
 Today's Deals
 New Releases

Extracts product names and prices

Generates an HTML report with the extracted information

# Setup

Prerequisites

 Java 11 or higher
 
 Maven
 
 WebDriver (configured to allow automation if using SafariDriver or others)

# Installation

Clone the repository:

git clone https://github.com/ylhm86/SmartShoppingAssistant.git

cd SmartShoppingAssistant

Set up the environment:

# Ensure you have the OpenAI API key set up in your environment variables:

export OPENAI_API_KEY=your_openai_api_key

Install dependencies:

mvn clean install

# Usage

Run the application:

mvn exec:java -Dexec.mainClass="com.AmazonAutomationService.Main"

Output:

The application will generate an AmazonProductReport.html file in the project directory. Open this file in a web browser to view the formatted report.

# Project Structure

AmazonScraper.java: Contains the logic to scrape Amazon for product names and prices.

HTMLReportGenerator.java: Generates an HTML report from the scraped data.

Main.java: The entry point of the application.

WebDriverSetup.java: Manages WebDriver setup and teardown.

# Dependencies

Selenium WebDriver: For web scraping.

Gson: For JSON processing.

OkHttp: For making HTTP requests.

Maven: For project management and dependency resolution.

Maven Dependencies

# License

This project is licensed under the MIT License - see the LICENSE file for details.
