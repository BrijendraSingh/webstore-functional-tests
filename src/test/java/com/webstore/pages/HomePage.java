package com.webstore.pages;
import com.webstore.helpers.Click;
import com.webstore.helpers.Enter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver,By.cssSelector(".product"));
    }

    public By getProductBuyButtonLocator(String name){
        return By.xpath("//span[contains(text(),'"+name+"')]//ancestor::div[@class='product']/div[@class='product-buy']/div/button");
    }
    public By getProduct(String name){
        return By.xpath("//span[contains(text(),'"+name+"')]//ancestor::div[@class='product']");
    }
    public By quantity=By.id("quantity");
    public By order=By.id("order");
    public HomePage buy(String product,int q){
        String stock=getStock(product);
        Click.on(driver,getProductBuyButtonLocator(product));
        Enter.textInto(driver,""+q,quantity);
        Click.on(driver,order);
        WebDriverWait wait=new WebDriverWait(this.driver,15);
        wait.until(webDriver -> {
            return !getStock(product).equals(stock);
        });
        return this;
    }
    public String getStock(String product){
        return driver.findElement(getProduct(product)).findElement(By.cssSelector(".product-stock")).getText();
    }
}
