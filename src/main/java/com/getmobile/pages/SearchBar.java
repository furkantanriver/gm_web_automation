package com.getmobile.pages;

import com.getmobile.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchBar extends BasePage {

    @FindBy(xpath = "(//a[@class='breadcrumbs-links'])[4]")
    WebElement breadCrumb;

    public SearchBar(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Search yapar ve gidilen ürün detay sayfasını kontrol eder.
     */
    public void selectPhoneController() {
        selectPhone();
        Log.pass("Ürün detay sayfasına gidiliyor...");
        Log.pass("Ürün Detay Sayfasına Gidildi");
        String model = breadCrumb.getText();
        Log.pass("Bulunan Breadcrumb Değeri: " + model);
        Assert.assertEquals(model, "iPhone 11", "Hatalı Ürün Detay Sayfasına Gidildi");
    }

}

