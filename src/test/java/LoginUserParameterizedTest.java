import com.UserOperations;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

@RunWith(Parameterized.class)
public class LoginUserParameterizedTest {

    private int numCase;
    public UserOperations userOperations;
    public Map<String, String> userData;
    MainPage mainPage;

    public LoginUserParameterizedTest(int numCase) {
        this.numCase = numCase;
    }

    @Parameterized.Parameters
    public static Object[][] getLoginData() {
        return new Object[][]{
                {1},
                {2},
                {3},
                {4},
        };
    }

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
    @Description("Вход пользователя")
    public void userLoginTest(){
        switch (numCase){
            case 1:
                mainPage = open(MainPage.MAIN_URL, MainPage.class);
                Assert.assertTrue("Страница 'Соберите бургер' не открылась", mainPage.checkVisibleTitleAssembleBurger());
                mainPage.clickLinkPersonalAccount();
                break;
            case 2:
                mainPage = open(MainPage.MAIN_URL, MainPage.class);
                Assert.assertTrue("Страница 'Соберите бургер' не открылась", mainPage.checkVisibleTitleAssembleBurger());
                mainPage.clickButtonLoginAccount();
                break;
            case 3:
                RegisterPage registerPage = open(RegisterPage.REGISTER_URL, RegisterPage.class);
                Assert.assertTrue("Страница 'Регистрация' не открылась", registerPage.checkVisibleTitleRegister());
                registerPage.clickButtonLogin();
                break;
            case 4:
                ForgotPasswordPage forgotPasswordPage = open(ForgotPasswordPage.FORGOT_PASSWORD_URL, ForgotPasswordPage.class);
                Assert.assertTrue("Страница 'Восстановление пароля' не открылась", forgotPasswordPage.checkVisibleTitleForgotPassword());
                forgotPasswordPage.clickButtonLogin();
                break;
        }

        LoginPage loginPage = page(LoginPage.class);
        Assert.assertTrue("Страница 'Вход' не открылась", loginPage.checkVisibleTitleLogin());
        loginPage.setFieldEmail(userData.get("email"));
        loginPage.setFieldPassword(userData.get("password"));
        loginPage.clickButtonEnter();

        MainPage mainPage = page(MainPage.class);
        Assert.assertTrue("Страница 'Соберите бургер' авторизованного пользователя не открылась", mainPage.checkVisibleButtonPlaceOrder());
    }
}