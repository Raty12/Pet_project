package ru.donjon;

class RegistrationDataValues {
    /*Pages URL*/
    String mainPageUrl = "https://donjon.ru/", registrationPageUrl = "https://donjon.ru/register/#menu"; /*I will add new pages here, as long as I'll need them*/

    /*Valid data sets*/
    /*Required fields*/
    /*last name*/
    String lastNameValid = "Иванова", lastNameShort = "Ю",
            lastNameMaxLong = "РылееваБесстужеваРюминаАлексееваКозловскаяИвановаС",
    lastNameEnglish = "Smith";

    /*Name*/
    String nameValid = "Катя", nameShort = "Ё",
            nameMaxLong = "марияАнжеликаАрвенЭстебанЖелтофиольТретьяПрекрасна",
    nameAzerbajanian = "Çmzxoö";

    /*Email*/
    String emailValid = "krisota123456789@gmail.com", emailManyDotsAddress = "Krisota@mail.com.uk",
    emailSymbols = "$kr!sota$.mail.ru"; /*this field has no max length*/

    /*Phone number*/
    String phoneValidMobile = "9178067522", phoneValidHome = "4994567853";

    /*Password*/
    String passwordValidSimple = "1234", passwordValidComplicated = "@7mlkgLgv8*kcd";

    /*Optional fields Valid*/
    String patronymicValid = "Ивановна", yearValue = "2005", monthValue = "Фев", dayValue = "30", countryName = "Россия",
    cityName = "Владивосток", streetName = "Ленина", indexName = "06542323556", houseNumber = "14",
            apartmentNumber = "2";

    /*Various invalid data values*/

    String tooLong = "трплнбрвеувньчвавапвттроьбллдбпгльлоаавыыыритмсчсвольиааероьисыырррлмрвеы",
            onlyNumbers = "1234567892", simbols = "@!%^$#@^&", space = " ", SQlInjection = "SELECT * FROM Users WHERE UserId = 105 OR 1=1;";


}
