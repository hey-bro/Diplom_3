package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage extends NavBarPage {
    public static final String REGISTER_URL = "https://stellarburgers.nomoreparties.site/register";

    @FindBy(how = How.XPATH, using = "//h2[text() = 'Регистрация']")
    private SelenideElement titleRegister;

    @FindBy(how = How.XPATH, using = "//label[text() = 'Имя']/../input")
    private SelenideElement fieldName;

    @FindBy(how = How.XPATH, using = "//label[text() = 'Email']/../input")
    private SelenideElement fieldEmail;

    @FindBy(how = How.XPATH, using = "//label[text() = 'Пароль']/../input")
    private SelenideElement fieldPassword;

    @FindBy(how = How.XPATH, using = "//button[text() = 'Зарегистрироваться']")
    private SelenideElement buttonRegister;

    @FindBy(how = How.XPATH, using = "//p[contains(@class, 'error')]")
    private SelenideElement labelErrorFieldPassword;

    @FindBy(how = How.XPATH, using = "//a[contains(text(), 'Войти')]")
    private SelenideElement linkLogin;

    @Step ("Проверяем виден ли заголовок 'Регистрация'")
    public boolean checkVisibleTitleRegister(){
        return titleRegister.hover().is(Condition.visible);
    }

    @Step("Заполняем поле 'Имя'")
    public void setFieldName(String name) {
        fieldName.sendKeys(name);
    }

    @Step("Заполняем поле 'Email'")
    public void setFieldEmail(String email) {
        fieldEmail.sendKeys(email);
    }

    @Step("Заполняем поле 'Пароль'")
    public void setFieldPassword(String password) {
        fieldPassword.sendKeys(password);
    }

    @Step("Нажатие ссылки 'Зарегистрироваться'")
    public void clickButtonRegister(){
        buttonRegister.click();
    }

    @Step ("Проверяем видна ли сообщение 'Некорректный пароль'")
    public boolean checkVisibleLabelErrorFieldPassword(){
        return labelErrorFieldPassword.hover().is(Condition.visible);
    }

    @Step("Нажатие ссылки 'Войти'")
    public void clickButtonLogin(){
        linkLogin.click();
    }

    public SelenideElement getTitleRegister() {
        return titleRegister;
    }

    public SelenideElement getFieldName() {
        return fieldName;
    }

    public SelenideElement getFieldEmail() {
        return fieldEmail;
    }

    public SelenideElement getFieldPassword() {
        return fieldPassword;
    }

    public SelenideElement getButtonRegister() {
        return buttonRegister;
    }

    public SelenideElement getLabelErrorFieldPassword() {
        return labelErrorFieldPassword;
    }

    public SelenideElement getLinkLogin() {
        return linkLogin;
    }
}