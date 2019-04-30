package com.codecool.test.jiraglassdocumentation.features;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Versions extends Feature{

    private final String VERSIONS_SETTINGS_URL = "https://jira2.codecool.codecanvas.hu/plugins/servlet/project-config/TGD/administer-versions";

    @FindBy(xpath = "//form[@id='releases-add__version']//input[@name='name']")
    WebElement versionFieldName;

    @FindBy(xpath = "//form[@id='releases-add__version']//button")
    WebElement addVersionButton;

    @FindBy(id = "aui-uid-2")
    WebElement versionsButton;

    public Versions(WebDriver driver) {
        super(driver);
    }

    public void addNewVersion(String versionName) {
        driver.get(VERSIONS_SETTINGS_URL);
        wait.until(ExpectedConditions.elementToBeClickable(versionFieldName));

        versionFieldName.sendKeys(versionName);
        versionFieldName.submit();

        addVersionButton.click();
    }

    public boolean validateVersionPresent(String versionName) {
        versionsButton.click();

        WebElement version = null;

        try {
            version = driver.findElement(By.xpath("//table[@id='versions-table']//a[text()='" + versionName + "']"));
        } catch (NoSuchElementException e) {
            System.out.println(e);
        }

        return version != null;
    }
}
