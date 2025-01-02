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
   git clone https://github.com/kullanici/proje-adi.git
   cd proje-adi

## Testlerin Çalıştırılması ve Raporlama

1. Depoyu klonlayın:
   ```bash
   gradle test
2. Raporları oluşturun ve alın:
    ```bash
   gradle allureReport
   gradle allureServe
