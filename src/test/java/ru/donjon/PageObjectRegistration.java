package ru.donjon;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v103.network.model.Cookie;

import java.sql.Date;

import static com.codeborne.selenide.Selenide.*;

public class PageObjectRegistration extends RegistrationDataValues {

    /*Locate all interactive elements on the page*/

    /*text fields*/
    WebElement last_nameField = $(By.name("last_name"));
    WebElement nameField = $(By.name("name"));
    WebElement patronymic = $(By.name("patronymic"));
    WebElement birthdayDate = $(By.name("birthday")); /* this field is a Datepicker*/
    WebElement email = $(By.name("email"));
    WebElement phoneNumber = $(By.name("phone"));
    WebElement country = $(By.name("country"));
    WebElement city = $(By.name("city"));
    WebElement street = $(By.name("street"));
    WebElement index = $(By.name("zip"));
    WebElement house_number = $(By.name("house_number"));
    WebElement apartment_number = $(By.name("apartment_number"));
    WebElement password = $(By.name("password"));
    WebElement password_repeat = $(By.name("password_repeat"));

    /*checkboxes*/
    WebElement newsletter = $(By.id("newsletter"));
    WebElement iAmNotRobot = $("[class=\"recaptcha-checkbox-checkmark\"]");
    WebElement confidentialPolicy = $(By.id("politika"));

    /*button*/
    WebElement submitButton = $(By.tagName("button"));

    /*Create methods for common actions on the page*/

    /*Fill in the BirhtdayDate Datepicker*/

    public PageObjectRegistration setDate (String month, String year, String day) {
        birthdayDate.click();
        $(By.className("ui-datepicker-month")).click();
        $(By.xpath("//option[text()='Фев']")).click();
        $(By.xpath("//option[text()='2005']")).click();
        $(By.xpath("//a[text()='5']")).click();
        return this;
    }

    /*Check if the submit button is enable, before clicking it*/
    public boolean submitButtonEnable() {
        if (submitButton.isEnabled()) {
            submitButton.click();
            return true;
        } else {
            System.out.println("Submit button is not interactive.");
            return false;
        }
    }

    /*Extracting text from the alert error warning*/

    public String getErrorText() {

        String txt = Selenide.switchTo().alert().getText();
        System.out.println("The text is - " +txt);
        return String.valueOf(txt);
    }

    /*Shut down the alert error warning*/

    public void shutDownAlert() {
        Selenide.switchTo().alert().accept();
    }

    /*Trying to deal with ReCapcha*/

    // Создаем cookie
    /*public void sendCookies() {
        Cookie COOKIE = new Cookie("searchuid", "7872272821650056225", "\t.mail.ru", "/", new Date("2032-07-23T21:18:35.210Z"));
        ChromeOptions options = null;
        // Создаем браузер
        WebDriver driver = new ChromeDriver(options);
// Добавляем cookie в браузер
        driver.manage().addCookie(COOKIE);
    }*/
 }

