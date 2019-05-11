package com.webstore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected By pageLoadElement=null;
    public BasePage(WebDriver driver,By pageLoadElement) {
        this.driver = driver;
        this.pageLoadElement=pageLoadElement;
        waitForPageLoad();
    }
    public void waitForPageLoad(){
        if(pageLoadElement!=null);
        WebDriverWait wait=new WebDriverWait(this.driver,15);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(pageLoadElement));
    }
}
