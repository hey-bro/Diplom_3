import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class BuilderTest {
    MainPage mainPage;

    @Before
    @DisplayName("Открыть вкладку браузера")
    public void setUp() {
        mainPage = open(MainPage.MAIN_URL, MainPage.class);
    }

    @Test
    @DisplayName("Переход на страницу 'Соберите бургер'")
    @Description("Проверка по тайтлу")
    public void transitionsSectionsBuilderMainPageTest() {
        mainPage.getTitleAssembleBurger().shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("Переход на страницу 'Соусы'")
    @Description("Проверка по кнопке")
    public void transitionsSectionsBuilderSaucePageTest() {
        mainPage.clickButtonSauce();
        assertTrue(mainPage.assertChooseSauceButton());
    }

    @Test
    @DisplayName("Переход на страницу 'Начинки'")
    @Description("Проверка по кнопке")
    public void transitionsSectionsBuilderFillingPageTest() {
        mainPage.clickButtonFilling();
        assertTrue(mainPage.assertChooseFillingButton());
    }

    @Test
    @DisplayName("Переход на страницу 'Булки'")
    @Description("Проверка по кнопке")
    public void transitionsSectionsBuilderBunsPageTest() {
        assertTrue(mainPage.assertChooseBunButton());
    }

}