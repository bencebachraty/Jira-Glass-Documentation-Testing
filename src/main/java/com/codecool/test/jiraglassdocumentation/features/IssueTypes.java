package com.codecool.test.jiraglassdocumentation.features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class IssueTypes extends Feature {

    @FindBy(xpath = "//li[@id='glass-workflow-nav']//div")
    WebElement issueTypesButton;

    By dropdownElements = By.xpath("//div[@role='group']/*[@data-target='workflow']");
    By typeIcons = By.xpath("//div[@id='glass-general-panel']//img[@class='section-icon']");

    public IssueTypes(WebDriver driver) {
        super(driver);
    }

    public int getNumberOfTypesFromDropdown() {
        List<WebElement> listOfTypes = new ArrayList<>();

        issueTypesButton.click();

        listOfTypes = driver.findElements(dropdownElements);

        return listOfTypes.size();
    }

    public int getNumberOfTypesFromSummary() {
        List<WebElement> listOfTypes = new ArrayList<>();

        listOfTypes = driver.findElements(typeIcons);

        return listOfTypes.size();
    }
}
