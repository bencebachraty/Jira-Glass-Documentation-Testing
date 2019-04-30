package com.codecool.test.jiraglassdocumentation.features;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Components extends Feature {

    private final String COMPONENTS_SETTINGS_URL = "https://jira2.codecool.codecanvas.hu/plugins/servlet/project-config/TGD/administer-components";

    @FindBy(xpath = "//form[@id='components-add__component']//input[@name='name']")
    WebElement componentNameField;

    @FindBy(id = "assigneeType-field")
    WebElement assigneeTypeField;

    @FindBy(xpath = "//form[@id='components-add__component']//button")
    WebElement addComponentButton;

    public Components(WebDriver driver) {
        super(driver);
    }

    public void addNewComponent(String componentName, String assignee) {
        driver.get(COMPONENTS_SETTINGS_URL);
        wait.until(ExpectedConditions.elementToBeClickable(componentNameField));

        componentNameField.sendKeys(componentName);

        assigneeTypeField.sendKeys(assignee);
        assigneeTypeField.submit();

        addComponentButton.click();
    }

    public boolean validateComponentPresent(String componentName) {
        WebElement component = null;

        try {
            component = driver.findElement(By.xpath("//table[@id='components-table']//a[text()='" + componentName + "']"));
        } catch (NoSuchElementException e) {
            System.out.println(e);
        }

        return component != null;
    }
}
