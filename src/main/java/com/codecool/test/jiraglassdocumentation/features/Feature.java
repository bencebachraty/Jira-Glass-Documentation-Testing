package com.codecool.test.jiraglassdocumentation.features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Feature {
    protected final String glassDocumentationUrl = "https://jira2.codecool.codecanvas.hu/projects/TGD?selectedItem=com.codecanvas.glass:glass";

    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(xpath = "//span[@title='Glass Documentation']")
    WebElement glassDocSideBar;

    public Feature(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void closeDriver() {
        driver.quit();
    }

    public void goToGlassPage() {
        driver.get(glassDocumentationUrl);

        wait.until(ExpectedConditions.visibilityOf(glassDocSideBar));
    }

    public WebDriver getDriver() {
        return driver;
    }
}
