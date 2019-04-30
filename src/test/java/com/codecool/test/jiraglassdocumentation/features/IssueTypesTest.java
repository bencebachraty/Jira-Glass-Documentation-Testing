package com.codecool.test.jiraglassdocumentation.features;

import com.codecool.test.jiraglassdocumentation.utils.Utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IssueTypesTest {

    private Login login;
    private IssueTypes issueTypes;

    @BeforeAll
    static void init() { Utils.setDriverPath(); }

    @BeforeEach
    void setUp() {
        login = new Login(Utils.createWebdriver());
        issueTypes = new IssueTypes(login.getDriver());
        login.login();
        issueTypes.goToGlassPage();
    }

    @AfterEach
    void tearDown() { issueTypes.closeDriver(); }

    @Test
    void testNumberOfTypesFromDropdown() {
        int expectedResult = 7;
        int actualResult = issueTypes.getNumberOfTypesFromDropdown();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testNumberOfTypesFromSummary() {
        int expectedResult = 7;
        int actualResult = issueTypes.getNumberOfTypesFromSummary();

        assertEquals(expectedResult, actualResult);
    }

}