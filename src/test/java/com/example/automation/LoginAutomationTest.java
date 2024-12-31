package com.example.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class LoginAutomationTest {

    @Test
    public void testLogin() {
        // Set up the WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the login page
            driver.get("https://example.com/login");

            // Validate page load
            assertEquals("Login Page", driver.getTitle(), "Page title does not match");

            // Set up WebDriverWait to wait for elements
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Locate and wait for the username, password, and login button
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
            WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginButton")));

            // Validate elements exist
            assertNotNull(usernameField, "Username field is not found");
            assertNotNull(passwordField, "Password field is not found");
            assertNotNull(loginButton, "Login button is not found");

            // Perform login
            usernameField.sendKeys("testUser");
            passwordField.sendKeys("testPassword");
            loginButton.click();

            // Wait until the dashboard page is loaded
            wait.until(ExpectedConditions.titleIs("Dashboard"));

            // Validate successful login by checking the page title
            String expectedTitle = "Dashboard";
            String actualTitle = driver.getTitle();
            assertEquals(expectedTitle, actualTitle, "Login failed, dashboard not loaded");

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
