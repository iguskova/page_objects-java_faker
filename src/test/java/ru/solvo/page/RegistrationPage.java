package ru.solvo.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.solvo.page.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            gender = $("#genterWrapper"),
            mobileNumber = $("#userNumber"),
            subject = $("#subjectsInput"),
            hobby = $("#hobbiesWrapper"),
            pic = $("#uploadPicture"),
            address=$("#currentAddress"),
            state=$("#stateCity-wrapper"),
            city=$("#stateCity-wrapper"),
            submit= $("#submit"),
            checkResults = $(".table-responsive");
    public CalendarComponent calendar = new CalendarComponent();

    @Step("Открываем страницу регистрации")
    public void openPage(){
        open("/automation-practice-form");
    }

    @Step("Заполняем имя")
    public RegistrationPage typeFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Заполняем фамилию")
    public RegistrationPage typeLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Заполняем e-mail")
    public RegistrationPage typeUserEmail(String value){
        userEmailInput.setValue(value);
        return this;
    }

    @Step("Выбираем пол")
    public RegistrationPage chooseGender(String value){
        gender.$(byText(value)).click();
        return this;
    }

    @Step("Заполняем номер телефона")
    public RegistrationPage typeNumber(String value){
        mobileNumber.setValue(value);
        return this;
    }

    @Step("Выбираем предмет")
    public RegistrationPage chooseSubject(String value){
        subject.setValue(value).pressEnter();
        return this;
    }

    @Step("Выбираем хобби")
    public RegistrationPage chooseHobby(String value){
        hobby.$(byText(value)).click();
        return this;
    }

    @Step("Загружаем фото")
    public RegistrationPage uploadPic(String value){
        pic.uploadFromClasspath(value);
        return this;
    }

    @Step("Заполняем адресс")
    public RegistrationPage typeAddress(String value){
        address.setValue(value);
        $("#submit").scrollIntoView(true);
        return this;
    }

    @Step("Выбираем штат")
    public RegistrationPage chooseState(String value){
        state.$("#state").click();
        $("#state").$(byText(value)).click();
        return this;
    }

    @Step("Выбираем город")
    public RegistrationPage chooseCity(String value){
        city.$("#city").click();
        $("#city").$(byText(value)).click();
        return this;
    }

    @Step("Нажимаем подтвердить")
    public void pressSubmit(){
        submit.click();
    }

    @Step("Проверяем результаты")
    public RegistrationPage checkResults(String fullName, String email,
                                         String gender, String number,
                                         String dateOfBirth, String subject,
                                         String hobby, String pic, String address, String stateAndCity){
        checkResults.shouldHave(text(fullName),text(email),
                text(gender), text(dateOfBirth),
                text(subject), text(hobby), text(pic),
                text(address), text(stateAndCity));
        return this;
    }

}
