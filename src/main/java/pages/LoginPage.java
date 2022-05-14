package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends NavBarPage {
    public static final String LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";

    @FindBy(how = How.XPATH, using = "//h2[text() = 'Вход']")
    private SelenideElement titleLogin;

    @FindBy(how = How.XPATH, using = "//label[text() = 'Email']/../input")
    private SelenideElement fieldEmail;

    @FindBy(how = How.XPATH, using = "//label[text() = 'Пароль']/../input")
    private SelenideElement fieldPassword;

    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'Войти')]")
    private SelenideElement buttonEnter;

    @FindBy(how = How.XPATH, using = "//a[contains(text(), 'Зарегистрироваться')]")
    private SelenideElement linkRegister;

    @Step ("Проверяем виден ли заголовок 'Вход'")
    public boolean checkVisibleTitleLogin(){
        return titleLogin.hover().is(Condition.visible);
    }

    @Step("Заполняем поле 'Email'")
    public void setFieldEmail(String email) {
        fieldEmail.sendKeys(email);
    }

    @Step("Заполняем поле 'Пароль'")
    public void setFieldPassword(String password) {
        fieldPassword.sendKeys(password);
    }

    @Step("Нажатие кнопки 'Войти'")
    public void clickButtonEnter(){
        buttonEnter.click();
    }

    @Step("Нажатие ссылки 'Зарегистрироваться'")
    public void clickButtonRegister(){
        linkRegister.click();
    }

    public SelenideElement getTitleLogin() {
        return titleLogin;
    }

    public SelenideElement getFieldEmail() {
        return fieldEmail;
    }

    public SelenideElement getFieldPassword() {
        return fieldPassword;
    }

    public SelenideElement getButtonEnter() {
        return buttonEnter;
    }

    public SelenideElement getLinkRegister() {
        return linkRegister;
    }
}