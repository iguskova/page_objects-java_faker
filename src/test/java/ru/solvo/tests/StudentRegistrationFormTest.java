package ru.solvo.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import ru.solvo.page.RegistrationPage;

import java.util.Locale;

public class StudentRegistrationFormTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker(new Locale("en"));
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String gender = "Female";
    String number = faker.phoneNumber().subscriberNumber(10);
    String day = "27";
    String month = "April";
    String year = "1993";
    String subject = "English";
    String hobby = "Sports";
    String pic = "ava1.jpeg";
    String address = faker.address().fullAddress();
    String state = "Haryana";
    String city = "Panipat";


    @Test
    void fillFormTest() {
        registrationPage.openPage();
        registrationPage.typeFirstName(firstName)
                        .typeLastName(lastName)
                        .typeUserEmail(userEmail)
                        .chooseGender(gender)
                        .typeNumber(number)
                        .calendar.setDate(day, month, year);
        registrationPage.chooseSubject(subject)
                        .chooseHobby(hobby)
                        .uploadPic(pic)
                        .typeAddress(address)
                        .chooseState(state)
                        .chooseCity(city)
                        .pressSubmit();
        registrationPage.checkResults(firstName + ' ' + lastName, userEmail, gender,
                number, day +  ' ' + month + ',' + year, subject, hobby, pic, address,
                state + ' ' + city);

    }


}

