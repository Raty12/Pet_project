package ru.donjon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
    WebElement iAmNotRobot = $(By.className("recaptcha-checkbox-checkmark"));
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
            return true;
        } else {
            return false;
        }
    }
 }

