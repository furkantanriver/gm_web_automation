package com.getmobile.pages;

import com.getmobile.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class BasePage {

    @FindBy(xpath = "//input[@class='header-search-input']")
    WebElement searchBox;
    @FindBy(xpath = "//span[@data-testid='search-list-phone-name']")
    List<WebElement> phoneName;

    String phoneModel = "Apple iPhone 11";
    // 15 pro ------- stok olmayan cihaz negatif case için kullanılabilir.
    // Apple iPhone 11
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Search yapar ve ürün detay sayfasına gider.
     */
    public void selectPhone() {
        driver.get("https://getmobil.com");
        Log.pass("Search Bar Tıklanıyor...");
        searchBox.click();
        Log.pass("Search Bar Tıklandı");
        Log.pass("Search Boxa Girildi");
        Log.pass("Telefon modeli giriliyor...");
        searchBox.sendKeys(phoneModel);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread was interrupted: " + e.getMessage());
        }
        Log.pass("Telefon modeli girildi: " + phoneModel);
        Log.pass("Arama sonuçları kontrol ediliyor...");
        boolean isPhoneFound = false;
        for (WebElement phone : phoneName) {
            String phoneText = phone.getText();
            Log.pass("Telefon Bulundu: " + phoneText);
            if (phoneModel.equals(phoneText)) {
                Log.pass("Aranan Telefon Bulundu " + phoneText);
                phone.click();
                isPhoneFound = true;
                break;
            }
        }
        if (!isPhoneFound) {
            Log.fail("Aranan telefon modeli bulunamadı: " + phoneModel);
        }


    }
}
