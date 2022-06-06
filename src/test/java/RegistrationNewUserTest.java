import com.UserOperations;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

import static com.UserOperations.EMAIL_POSTFIX;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationNewUserTest {
    MainPage mainPage;
    private String email;
    private String password;

    @After
    public void tearDown() {
        UserOperations userOperations = new UserOperations();
        userOperations.authorizationUserForGetToken(email, password);
        userOperations.delete();
        webdriver().driver().close();
    }

    @Test
    @DisplayName("Successful user Authorization")
    @Description("Успешная авторизация пользователя")
    public void successfulUserAuthorizationTest() {
        mainPage = open(MainPage.MAIN_URL, MainPage.class);
        mainPage.getTitleAssembleBurger().shouldBe(Condition.visible);
        mainPage.clickLinkPersonalAccount();

        LoginPage loginPage = page(LoginPage.class);
        Assert.assertTrue("Страница 'Вход' не открылась", loginPage.checkVisibleTitleLogin());
        loginPage.clickButtonRegister();

        RegisterPage registerPage = page(RegisterPage.class);
        email = RandomStringUtils.randomAlphabetic(10) + EMAIL_POSTFIX;
        password = RandomStringUtils.randomAlphabetic(10);
        String name = RandomStringUtils.randomAlphabetic(10);
        registerPage.setFieldName(name);
        registerPage.setFieldEmail(email);
        registerPage.setFieldPassword(password);
        registerPage.clickButtonRegister();

        Assert.assertTrue("Страница 'Вход' не открылась", loginPage.checkVisibleTitleLogin());
        loginPage.setFieldEmail(email);
        loginPage.setFieldPassword(password);
        loginPage.clickButtonEnter();

        mainPage.getButtonPlaceOrder().shouldBe(Condition.visible);    }

    @Test
    @DisplayName("Entering an incorrect password during registration")
    @Description("Ввод не корректного пароля при регистрации")
    public void enteringIncorrectPasswordDuringRegistrationTest() {
        mainPage = open(MainPage.MAIN_URL, MainPage.class);
        mainPage.getTitleAssembleBurger().shouldBe(Condition.visible);
        mainPage.clickButtonLoginAccount();

        LoginPage loginPage = page(LoginPage.class);
        Assert.assertTrue("Страница 'Вход' не открылась", loginPage.checkVisibleTitleLogin());
        loginPage.clickButtonRegister();

        RegisterPage registerPage = page(RegisterPage.class);
        email = RandomStringUtils.randomAlphabetic(10) + EMAIL_POSTFIX;
        password = RandomStringUtils.randomAlphabetic(5);
        String name = RandomStringUtils.randomAlphabetic(10);
        registerPage.setFieldName(name);
        registerPage.setFieldEmail(email);
        registerPage.setFieldPassword(password);
        registerPage.clickButtonRegister();
        Assert.assertTrue("Отсутствует предупреждение 'Некорректный пароль'", registerPage.checkVisibleLabelErrorFieldPassword());
    }
}