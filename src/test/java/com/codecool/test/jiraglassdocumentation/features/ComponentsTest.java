package com.codecool.test.jiraglassdocumentation.features;

import com.codecool.test.jiraglassdocumentation.utils.Utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComponentsTest {

    private Login login;
    private Components components;

    @BeforeAll
    static void init() { Utils.setDriverPath(); }

    @BeforeEach
    void setUp() {
        login = new Login(Utils.createWebdriver());
        components = new Components(login.getDriver());
        login.login();
    }

    @AfterEach
    void tearDown() { components.closeDriver(); }

    @Test
    void testNewComponentIsListedInGlass() {
        components.addNewComponent("test-comp", "component lead");

        components.goToGlassPage();

        assertTrue(components.validateComponentPresent("test-comp"));
    }
}