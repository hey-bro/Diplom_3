import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class BuilderTest {
    MainPage mainPage;

    @Test
    @DisplayName("Transitions to sections of the builder")
    @Description("Переходы к разделам конструктора")
    public void transitionsSectionsBuilderTest() {
        mainPage = open(MainPage.MAIN_URL, MainPage.class);
        Assert.assertTrue("Страница 'Соберите бургер' не открылась", mainPage.checkVisibleTitleAssembleBurger());

        mainPage.clickButtonSauce();
        Assert.assertTrue("Переход меню к категории 'Соусы' не произведен", mainPage.checkVisibleLabelSauce());

        mainPage.clickButtonFilling();
        Assert.assertTrue("Переход меню к категории 'Начинки' не произведен", mainPage.checkVisibleLabelFilling());

        mainPage.clickButtonBun();
        Assert.assertTrue("Переход меню к категории 'Булки' не произведен", mainPage.checkVisibleLabelBun());
    }
}