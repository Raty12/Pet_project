package ru.donjon;

import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.title;


public class Tests extends PageObjectRegistration {

    /*Positive tests*/
    @Test
    @Description("User can register, when all required (and only them) fields are filled with valid data. " +
            "And 'Я прочитал(-а) \"Политику конфиденциальности\" и согласен(-на) с ней' checkbox " +
            "and 'Я не работ' checkbox are clicked\"")
    public void userCanRegisterWithValidRequiredFieldsAndCheckboxes() throws Exception {
        open(registrationPageUrl);
        email.sendKeys(emailValid);
        last_nameField.sendKeys(lastNameValid);
        nameField.sendKeys(nameValid);
        phoneNumber.sendKeys(phoneValidMobile);
        password.sendKeys(passwordValidComplicated);
        password_repeat.sendKeys(passwordValidComplicated);
        confidentialPolicy.submit();
        iAmNotRobot.submit(); /*Here I am stuck now. */
        submitButton.submit();
        Assert.assertTrue(title.equals("Завершение регистрации"));
        System.out.println("User can register.");
    }

    @Test
    @Description("User can register, when all fields are filled with valid data (different from test 'userCanRegisterWithValidRequiredFieldsAndCheckboxes'). " +
            "And 'Я прочитал(-а) \"Политику конфиденциальности\" и согласен(-на) с ней' checkbox " +
            "and 'Я не работ' checkbox are clicked")
    public void userCanRegisterWithAllFieldsFilledValidData() {
        open(registrationPageUrl);
        email.sendKeys(emailValid);
        last_nameField.sendKeys(lastNameShort);
        nameField.sendKeys(nameShort);
        phoneNumber.sendKeys(phoneValidHome);
        password.sendKeys(passwordValidComplicated);
        password_repeat.sendKeys(passwordValidComplicated);
        patronymic.sendKeys(patronymicValid);
        setDate(monthValue, yearValue, dayValue);
        country.sendKeys(countryName);
        city.sendKeys(cityName);
        street.sendKeys(streetName);
        index.sendKeys(indexName);
        house_number.sendKeys(houseNumber);
        apartment_number.sendKeys(apartmentNumber);
        confidentialPolicy.submit();
        iAmNotRobot.submit(); /*here it all fails, because I can't find the right locator for that button. After all it was made to prevent this*/
        Assert.assertTrue(submitButton.isEnabled());
        submitButton.click();
        Assert.assertTrue(title.equals("Завершение регистрации"));
        System.out.println("User can register.");
    }
    /*Negative tests*/

    @Test
    @Description("User can't input numbers to required field 'last_name'")
    public void userCanNotInputInvalidData() {
        open(registrationPageUrl);
        last_nameField.sendKeys(onlyNumbers);
        String newValue = last_nameField.getText();
        Assert.assertEquals(newValue,"",newValue);
    }

    @Test
    @Description("User can't register without submitting the 'Я прочитал(-а) \"Политику конфиденциальности\" и согласен(-на) с ней' checkbox")
    public void userCanNotRegisterWithoutPrivacipolicyCheckbox() {
        open(registrationPageUrl);
        email.sendKeys(emailValid);
        last_nameField.sendKeys(lastNameValid);
        nameField.sendKeys(nameValid);
        phoneNumber.sendKeys(phoneValidMobile);
        password.sendKeys(passwordValidComplicated);
        password_repeat.sendKeys(passwordValidComplicated);
        if (submitButtonEnable() == true) {
            submitButton.click();
            Assert.assertTrue(title.equals("Завершение регистрации"));
            System.out.println("User could register without clicking 'I am not a robot' checkbox");

        } else {
            System.out.println("Submit button is not interactive.");

        }
    }

    @Test
    @Description("User can't register without filling all the requared fields")
    public void userCanNotRegisterWithoutFillingRequaredFilds() {
        open(registrationPageUrl);
        confidentialPolicy.submit();
        iAmNotRobot.submit();
        if (submitButtonEnable() == true) {
            submitButton.click();
            Assert.assertTrue(title.equals("Завершение регистрации"));
            System.out.println("User could register without filling all of the required fields");

        } else {
            System.out.println("Submit button is not interactive.");
        }
    }

}

