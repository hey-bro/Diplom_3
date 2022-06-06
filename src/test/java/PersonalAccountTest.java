import com.UserOperations;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AccountProfilePage;
import pages.LoginPage;
import pages.MainPage;

import java.util.Map;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class PersonalAccountTest {
    public UserOperations userOperations;
    public Map<String, String> userData;
    MainPage mainPage;

    @Before
    public void setup() {
        userOperations = new UserOperations();
        userData = userOperations.register();
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

    @After
    public void tearDown() {
        userOperations.delete();
        webdriver().driver().close();
    }

    @Test
    @DisplayName("Transfer to your personal account")
    @Description("Переход в личный кабинет")
    public void transferYourPersonalAccountTest(){
        mainPage.clickLinkPersonalAccount();
        Assert.assertTrue("Страницы личного кабинета не открыта", $(byXpath("//*[contains(@value, '" + userData.get("name") + "')]")).hover().is(Condition.visible));
    }

    @Test
    @DisplayName("Switching from your personal account to the constructor")
    @Description("Переход из личного кабинета в конструктор")
    public void transitionBuilderTest(){
        mainPage.clickLinkPersonalAccount();
        Assert.assertTrue("Страницы личного кабинета не открыта", $(byXpath("//*[contains(@value, '" + userData.get("name") + "')]")).hover().is(Condition.visible));
        mainPage.clickLinkBuilder();
        mainPage.getButtonPlaceOrder().shouldBe(Condition.visible);    }

    @Test
    @DisplayName("Switching from your personal account to the constructor by clicking on the logo")
    @Description("Переход из личного кабинета в конструктор нажатием на логотип")
    public void transitionBuilderClickLogoTest(){
        mainPage.clickLinkPersonalAccount();
        Assert.assertTrue("Страницы личного кабинета не открыта", $(byXpath("//*[contains(@value, '" + userData.get("name") + "')]")).hover().is(Condition.visible));
        mainPage.clickLinkLogo();
        mainPage.getButtonPlaceOrder().shouldBe(Condition.visible);    }

    @Test
    @DisplayName("Log out of your account")
    @Description("Выход из аккаунта")
    public void logoutAccountTest() {
        mainPage.clickLinkPersonalAccount();
        Assert.assertTrue("Страницы личного кабинета не открыта", $(byXpath("//*[contains(@value, '" + userData.get("name") + "')]")).hover().is(Condition.visible));
        AccountProfilePage accountProfilePage = page(AccountProfilePage.class);
        accountProfilePage.clickButtonLogout();
        LoginPage loginPage = page(LoginPage.class);
        Assert.assertTrue("Страница 'Вход' не открылась", loginPage.checkVisibleTitleLogin());
    }
}