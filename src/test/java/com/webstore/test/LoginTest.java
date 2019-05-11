package com.webstore.test;

import com.webstore.pages.LoginPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
public class LoginTest {
    @Test
    public void valid_login(){
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        WebDriver driver=new ChromeDriver();
        LoginPage loginPage=LoginPage.launch(driver,System.getenv("BASE_URL"));
        assertThat(
        loginPage.login("user1@localhost.com","user@1")
                .buy("Tata Tea 100g",1)
                .getStock("Tata Tea 100g"),
        is(equalTo("9")));
        driver.quit();
    }
}
