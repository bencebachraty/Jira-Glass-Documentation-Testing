package com.codecool.test.jiraglassdocumentation.features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Feature {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public Feature(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void closeDriver() {
        driver.quit();
    }
}
