import com.codeborne.selenide.Condition;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class BuilderTest {
    MainPage mainPage;

    @Before
    @DisplayName("Открыть браузер")
    public void setUp() {
        mainPage = open(MainPage.MAIN_URL, MainPage.class);
    }

    @Test
    @DisplayName("Переход на страницу 'Соберите бургер'")
    public void transitionsSectionsBuilderMainPageTest() {
        mainPage.getTitleAssembleBurger().shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("Переход на страницу 'Соусы'")
    public void transitionsSectionsBuilderSaucePageTest() {
        mainPage.clickButtonSauce();
        mainPage.getLabelSauce().shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("Переход на страницу 'Начинки'")
    public void transitionsSectionsBuilderFillingPageTest() {
        mainPage.clickButtonFilling();
        mainPage.getLabelFilling().shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("Переход на страницу 'Булки'")
    public void transitionsSectionsBuilderBunsPageTest() {
        mainPage.getLabelBun().shouldBe(Condition.visible);
    }

}