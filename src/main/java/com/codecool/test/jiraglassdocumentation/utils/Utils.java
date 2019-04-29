package com.codecool.test.jiraglassdocumentation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utils {

    public static final String BASE_URL = "https://jira2.codecool.codecanvas.hu/secure/Dashboard.jspa";

    public static void setDriverPath() {
        String driverProperty = System.getenv("DRIVER_PROPERTY");
        String driverPath = System.getenv("DRIVER_PATH");
    }

    public static WebDriver createWebdriver() {
        WebDriver driver = new ChromeDriver();

        return driver;
    }
}
