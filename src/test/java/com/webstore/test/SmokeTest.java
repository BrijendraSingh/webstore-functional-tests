package com.webstore.test;

import com.webstore.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
public class SmokeTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver=new ChromeDriver();
    }
    @Test
    public void valid_login(){
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");

        LoginPage loginPage=LoginPage.launch(driver,System.getenv("BASE_URL"));
    }
    @Test
    public void buy_product(){
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        LoginPage loginPage=LoginPage.launch(driver,System.getenv("BASE_URL"));
        assertThat(
                loginPage.login("user1@localhost.com","user@1")
                        .buy("Tata Tea 100g",1)
                        .getStock("Tata Tea 100g"),
                is(equalTo("9")));
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
