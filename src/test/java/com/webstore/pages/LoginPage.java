package com.webstore.pages;
import com.webstore.helpers.Click;
import com.webstore.helpers.Enter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage extends BasePage {
    public By usernameTextbox = By.cssSelector("#username");
    public By passwordTextbox = By.cssSelector("#password");
    public By loginButton = By.cssSelector("#loginButton");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public static LoginPage launch(WebDriver driver,String baseURL){
        driver.get(baseURL+"/ui/");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LoginPage loginPage=new LoginPage(driver);
        return loginPage;
    }
    public HomePage login(String username,String password){
        Enter.textInto(this.driver,username,usernameTextbox);
        Enter.textInto(this.driver,password,passwordTextbox);
        Click.on(this.driver,loginButton);
        return new HomePage(this.driver);
    }
}
