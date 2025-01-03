# README #

Test Otomasyon Projesi

Bu proje, Getmobil için test otomasyon süreçlerini yönetmek ve çalıştırmak amacıyla geliştirilmiştir. Gradle ile
yapılandırılmıştır ve Selenium ile TestNG kullanılmıştır

## İçindekiler

- [Özellikler](#özellikler)
- [Gereksinimler](#gereksinimler)
- [Kurulum](#kurulum)
- [Testlerin Çalıştırılması ve Raporlama](#testlerin-çalıştırılması)

---

## Özellikler

- **Gradle ile yapı yönetimi:** Gradle, bağımlılıkları yönetmek ve testleri çalıştırmak için kullanılır.
- **Raporlama:** Allure ile detaylı test raporları alınır.

---

## Gereksinimler

Projeyi çalıştırmadan önce aşağıdaki yazılımların yüklü olduğundan emin olun:

- **Java** (11 veya üzeri)
- **Gradle** (7.x veya üzeri)
- **Tarayıcılar** ve uygun WebDriver’lar (ör. ChromeDriver)

---

## Kurulum

1. Depoyu klonlayın:
   ```bash
   git clone https://github.com/furkantanriver/gm_web_automation.git
   cd gm_web_automation

## Testlerin Çalıştırılması ve Raporlama

1. Testleri başlatın:
   ```bash
   gradle test
2. Raporları oluşturun ve alın:
    ```bash
   allure serve
   
