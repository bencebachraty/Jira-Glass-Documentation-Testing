package com.codecool.test.jiraglassdocumentation.features;

import com.codecool.test.jiraglassdocumentation.utils.Utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VersionsTest {

    private Login login;
    private Versions versions;

    @BeforeAll
    static void init() { Utils.setDriverPath(); }

    @BeforeEach
    void setUp() {
        login = new Login(Utils.createWebdriver());
        versions = new Versions(login.getDriver());
        login.login();
    }

    @AfterEach
    void tearDown() { versions.closeDriver(); }

    @Test
    void testNewVersionIsListedInGlass() {
        versions.addNewVersion("v4-test");

        versions.goToGlassPage();

        assertTrue(versions.validateVersionPresent("v4-test"));
    }
}