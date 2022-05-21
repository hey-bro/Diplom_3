import com.UserOperations;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class LoginUserTest {

    public UserOperations userOperations;
    public Map<String, String> userData;
    MainPage mainPage;


    @Before
    public void setup() {
        userOperations = new UserOperations();
        userData = userOperations.register();
    }

    @After
    public void tearDown() {
        userOperations.delete();
        webdriver().driver().close();
    }

    @Test
    @DisplayName("User Login")
    @Description("Вход пользователя по линку 'Личный кабинет'")
    public void userLoginPersonalAccountTest(){
        mainPage = open(MainPage.MAIN_URL, MainPage.class);
        mainPage.getTitleAssembleBurger().shouldBe(Condition.visible);
        mainPage.clickLinkPersonalAccount();

        LoginPage loginPage = page(LoginPage.class);
        Assert.assertTrue("Страница 'Вход' не открылась", loginPage.checkVisibleTitleLogin());
        loginPage.setFieldEmail(userData.get("email"));
        loginPage.setFieldPassword(userData.get("password"));
        loginPage.clickButtonEnter();

        MainPage mainPage = page(MainPage.class);
        mainPage.getButtonPlaceOrder().shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("User Login")
    @Description("Логин пользователя - страница регистрации")
    public void userLoginRegisterPageTest(){
        RegisterPage registerPage = open(RegisterPage.REGISTER_URL, RegisterPage.class);
        registerPage.getTitleRegister().shouldBe(Condition.visible);
        registerPage.clickButtonLogin();

        LoginPage loginPage = page(LoginPage.class);
        Assert.assertTrue("Страница 'Вход' не открылась", loginPage.checkVisibleTitleLogin());
        loginPage.setFieldEmail(userData.get("email"));
        loginPage.setFieldPassword(userData.get("password"));
        loginPage.clickButtonEnter();

        MainPage mainPage = page(MainPage.class);
        mainPage.getButtonPlaceOrder().shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("User Login")
    @Description("Логин пользователя - страница сброса пароля")
    public void userLoginPasswordPageTest(){
        ForgotPasswordPage forgotPasswordPage = open(ForgotPasswordPage.FORGOT_PASSWORD_URL, ForgotPasswordPage.class);
        forgotPasswordPage.getTitleForgotPassword().shouldBe(Condition.visible);
        forgotPasswordPage.clickButtonLogin();

        LoginPage loginPage = page(LoginPage.class);
        Assert.assertTrue("Страница 'Вход' не открылась", loginPage.checkVisibleTitleLogin());
        loginPage.setFieldEmail(userData.get("email"));
        loginPage.setFieldPassword(userData.get("password"));
        loginPage.clickButtonEnter();

        MainPage mainPage = page(MainPage.class);
        mainPage.getButtonPlaceOrder().shouldBe(Condition.visible);
    }

}