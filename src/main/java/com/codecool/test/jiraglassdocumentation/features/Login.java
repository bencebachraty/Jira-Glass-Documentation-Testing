package com.codecool.test.jiraglassdocumentation.features;

import com.codecool.test.jiraglassdocumentation.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Login extends Feature {

    @FindBy(id = "login-form-username")
    WebElement userNameField;

    @FindBy(id = "login-form-password")
    WebElement passwordField;

    @FindBy(xpath = "//*[@id='header-details-user-fullname']//img")
    WebElement userProfilePicture;

    final String USER_NAME = System.getenv("USER_NAME");
    final String PASSWORD = System.getenv("PASSWORD");

    public Login(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void login() {
        driver.get(Utils.BASE_URL);

        wait.until(ExpectedConditions.visibilityOf(userNameField));

        userNameField.sendKeys(USER_NAME);
        passwordField.sendKeys(PASSWORD);
        passwordField.submit();

        wait.until(ExpectedConditions.visibilityOf(userProfilePicture));
    }
}
