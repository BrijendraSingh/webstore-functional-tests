package com.webstore.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public By getProductBuyButtonLocator(String name){
        return By.xpath("//span[contains(text(),'"+name+"')]//ancestor::div[@class='product']/div[@class='product-buy']/div/button");
    }
    public By quantity=By.id("quantity");
    public By order=By.id("order");
}
