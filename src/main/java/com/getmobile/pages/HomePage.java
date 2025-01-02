package com.getmobile.pages;

import com.getmobile.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@data-testid='main-slider']")
    List<WebElement> sliders;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Sayfanın 3 saniye içinde doğru şekilde yüklendiğini kontrol eder.
     */
    public void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        try {
            Log.pass("Sayfanın yüklenmesi bekleniyor...");
            var wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
            wait.until(expectation);
            Log.pass("Sayfa 3 Saniyeden Önce Yüklendi");
        } catch (TimeoutException timeoutException) {
            Log.fail("Sayfa Yükleme İsteğinin Tamamlanmasını Beklerken Zaman Aşımı Oluştu " + timeOutInSeconds + " saniye");
        }
    }

    public void navigateToHomePage() {
        driver.get("https://getmobil.com");
        waitForPageToLoad(3);
    }

    /**
     * Dinamik bannerların doğru şekilde görünüp görünmediğini kontrol eder.
     */
    public void areAllBannersDisplayed() {
        driver.get("https://getmobil.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        int sliderCount = sliders.size();
        Log.pass("Bulunan slider sayısı: " + sliderCount);
        if (sliderCount == 0) {
            Log.fail("Hiç slider bulunamadı. Test başarısız oldu !!!");
            return;
        }
        for (int i = 0; i < sliderCount; i++) {
            try {
                WebElement slider = sliders.get(i);
                wait.until(ExpectedConditions.visibilityOf(slider));
                Assert.assertTrue(slider.isDisplayed(), "Slider " + (i + 1) + " görünür değil.");
                Log.pass("Slider " + (i + 1) + " başarıyla yüklendi ve görünüyor.");
            } catch (Exception e) {
                Log.fail("Slider " + (i + 1) + " yüklenirken bir hata oluştu: " + e.getMessage());
            }

        }
    }

}


