package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage extends NavBarPage {
    public static final String FORGOT_PASSWORD_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    @FindBy(how = How.XPATH, using = "//h2[text() = 'Восстановление пароля']")
    private SelenideElement titleForgotPassword;

    @FindBy(how = How.XPATH, using = "//a[contains(text(), 'Войти')]")
    private SelenideElement linkLogin;

    @Step ("Проверяем виден ли заголовок 'Регистрация'")
    public boolean checkVisibleTitleForgotPassword(){
        return titleForgotPassword.hover().is(Condition.visible);
    }

    @Step("Нажатие ссылки 'Войти'")
    public void clickButtonLogin(){
        linkLogin.click();
    }

    public SelenideElement getTitleForgotPassword() {
        return titleForgotPassword;
    }
}