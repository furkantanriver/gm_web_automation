package com.getmobile.pages;

import com.getmobile.Log;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class BasketPage extends BasePage {
    @FindBy(xpath = "//div[@class='desktopSepetIconContainer basket-total']")
    WebElement myBasket;
    @FindBy(xpath = "//div[@data-testid='basket__trash-icon-desktop-vendor-1-product-1']")
    WebElement removeButton;
    @FindBy(xpath = "//div[@class='mantine-Text-root ms-1 mantine-1v23hdn']")
    WebElement basketCount;

    public BasketPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Sepetten ürün çıkarıldığı durumu kontrol eder.
     */

    public void changeBasket() {
        PhoneDetailPage phoneDetailPage = new PhoneDetailPage(driver);
        phoneDetailPage.addToCart();
        Log.pass("Sepete gidiliyor...");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", myBasket);
        Log.pass("Sepete gidildi");
        String basketCountText = basketCount.getText();
        Assert.assertEquals(basketCountText, "(2 Ürün)", "Sepette hatalı ürün adedi mevcut !!!");
        Log.pass("Sepette " + basketCountText + " bulundu");
        Log.pass("Sepetten 1 ürün çıkarılıyor...");
        removeButton.click();
        Log.pass("Sepetten 1 ürün çıkarıldı");
        String newBasketCount = basketCount.getText();
        Assert.assertEquals(newBasketCount, "(1 Ürün)", "Sepetten hatalı ürün adedi mevcut !!! ");
        Log.pass("Sepette mevcut ürün sayısı: " + newBasketCount);

    }
}
