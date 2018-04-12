package com.webstore.test;

import com.webstore.pages.LoginPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    @Test
    public void valid_login(){
        WebDriver driver=new ChromeDriver();
        LoginPage loginPage=LoginPage.launch(driver,System.getenv("BASE_URL"));
        loginPage.login("naik.atmaram@gmail.com","hello");
        driver.quit();
    }
}
