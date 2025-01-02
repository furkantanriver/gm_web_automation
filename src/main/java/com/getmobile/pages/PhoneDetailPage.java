package com.getmobile.pages;

import com.getmobile.Log;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class PhoneDetailPage extends BasePage {

    @FindBy(xpath = "//button[@data-testid='product-detail__add-to-cart-desktop-button']")
    WebElement addButton;
    @FindBy(xpath = "(//button[@class='btn w-100 d-flex justify-content-center align-items-center'])[1]")
    WebElement otherSeller;
    @FindBy(xpath = "(//div[@class='marketPlaceVendorTitle d-none d-lg-block'])[1]")
    WebElement vendorName;
    @FindBy(xpath = "(//a[@style='text-decoration:none;cursor:pointer;color:#000'])[11]")
    WebElement mainSeller;
    @FindBy(xpath = "//h1[@class='mantine-Text-root mantine-Title-root mantine-2exlwx']")
    WebElement productName;
    @FindBy(xpath = "(//a[@class='breadcrumbs-links'])[4]")
    WebElement breadCrumb;
    @FindBy(xpath = "//div[@class='mantine-Text-root mantine-byxdhh']")
    WebElement lastPrice;
    @FindBy(xpath = "//div[@class='mantine-Text-root mantine-jsxecz']")
    WebElement basePrice;


    public PhoneDetailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Ürün detay sayfasında sepete birden fazla satıcıdan ürün ekler.
     * Bu metod ana satıcı veya farklı stoklara sahip diğer satıcıların 'Stokta Yok' durumunuda kapsar.
     */
    public void addToCart() {
        selectPhone();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Log.pass("Sepete Ürün Ekleniyor...");
        try {
            wait.until(ExpectedConditions.elementToBeClickable(addButton));
            addButton.click();
            String sellerName = mainSeller.getText();
            Log.pass("Sepete " + sellerName + " Satıcısından Ürün Eklendi");
        } catch (Exception e) {
            Log.fail("Ana satıcıdan ürün eklenemedi: " + e.getMessage());
        }
        Log.pass("Sepete Farklı Bir Satıcıdan Ürün Ekleniyor...");
        try {
            wait.until(ExpectedConditions.elementToBeClickable(otherSeller));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", otherSeller);
            String otherSellerName = vendorName.getText();
            Log.pass("Sepete " + otherSellerName + " Satıcısından Ürün Eklendi");
        } catch (Exception e) {
            Log.fail("Diğer satıcıdan ürün eklenemedi: " + e.getMessage());
        }

    }

    /**
     * Ürün detay sayfasında ürün adını kontrol eder.
     * Ürün detaydaki breadcrump textini ürün adında arayarak sağlama yapar.
     */
    public void checkPhoneNameDetails() {
        selectPhone();
        String model = breadCrumb.getText();
        String productTitle = productName.getText();
        Log.pass("Ürün tam adı : " + productTitle);
        Log.pass("Ürün model kontrolü yapılıyor...");
        Assert.assertTrue(productTitle.contains(model), "Ürün detaylarında model bilgisi bulunamadı !!! Beklenen: " + model + " | Bulunan: " + productTitle);
        Log.pass("Ürün detaylarında model bilgisi doğrulandı: " + model);

    }

    /**
     * Ürün detay sayfasında ürün fiyatlarını kontrol eder.
     * Base fiyatın her üründe olup olmadığını kontrol eder.
     */
    public void checkPriceDetails() {
        String availablePrice = lastPrice.getText();
        String oldPrice = null;

        Log.pass("Ürün fiyatı kontrol ediliyor...");
        try {
            oldPrice = basePrice.getText();
            Log.pass("Eski fiyat: " + oldPrice);
        } catch (Exception e) {
            Log.fail("Eski fiyat alınırken bir hata oluştu: " + e.getMessage());
        }

        Log.pass("Güncel fiyat: " + availablePrice);
    }

    /**
     * Ürün detay sayfasında ürün stok durumunu kontrol eder.
     * 'Stok Yok' durumunda hata mesajı fırlatır. Bkz : 15 pro
     */
    public void checkStockStatus() {
        selectPhone();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Log.pass("Sepete Ürün Ekleniyor...");
        try {
            wait.until(ExpectedConditions.elementToBeClickable(addButton));
            addButton.click();
            String sellerName = mainSeller.getText();
            Log.pass("Sepete " + sellerName + " Satıcısından Ürün Eklendi");
        } catch (Exception e) {
            Log.fail("Ana satıcıdan ürün eklenemedi: " + e.getMessage());
        }

    }

}

