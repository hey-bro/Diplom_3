package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage extends NavBarPage{
    public static final String MAIN_URL = "https://stellarburgers.nomoreparties.site/";

    @FindBy(how = How.XPATH, using = "//h1[text() = 'Соберите бургер']")
    private SelenideElement titleAssembleBurger;

    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'Войти в аккаунт')]")
    private SelenideElement buttonLoginAccount;

    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'Оформить заказ')]")
    private SelenideElement buttonPlaceOrder;

    @FindBy(how = How.XPATH, using = "//span[contains(text(), 'Булки')]/..")
    private SelenideElement buttonBun;

    @FindBy(how = How.XPATH, using = "//span[contains(text(), 'Соусы')]/..")
    private SelenideElement buttonSauce;

    @FindBy(how = How.XPATH, using = "//span[contains(text(), 'Начинки')]/..")
    private SelenideElement buttonFilling;

    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Булки')]")
    private SelenideElement labelBun;

    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Соусы')]")
    private SelenideElement labelSauce;

    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Начинки')]")
    private SelenideElement labelFilling;

    @Step("Нажатие кнопки 'Войти в аккаунт'")
    public void clickButtonLoginAccount(){
        buttonLoginAccount.click();
    }

    @Step("Нажатие кнопки 'Оформить заказ'")
    public void clickButtonPlaceOrder(){
        buttonPlaceOrder.click();
    }

    @Step("Нажатие кнопки 'Булки'")
    public void clickButtonBun(){
        buttonBun.click();
    }

    @Step("Нажатие кнопки 'Соусы'")
    public void clickButtonSauce(){
        buttonSauce.click();
    }

    @Step("Нажатие кнопки 'Начинки'")
    public void clickButtonFilling(){
        buttonFilling.click();
    }

    public SelenideElement getTitleAssembleBurger() {
        return titleAssembleBurger;
    }

    public SelenideElement getButtonLoginAccount() {
        return buttonLoginAccount;
    }

    public SelenideElement getButtonPlaceOrder() {
        return buttonPlaceOrder;
    }

    public SelenideElement getButtonBun() {
        return buttonBun;
    }

    public SelenideElement getButtonSauce() {
        return buttonSauce;
    }

    public SelenideElement getButtonFilling() {
        return buttonFilling;
    }

    public SelenideElement getLabelBun() {
        return labelBun;
    }

    public SelenideElement getLabelSauce() {
        return labelSauce;
    }

    public SelenideElement getLabelFilling() {
        return labelFilling;
    }
}