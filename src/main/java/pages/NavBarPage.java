package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NavBarPage {
    @FindBy(how = How.XPATH, using = "//p[contains(text(), 'Конструктор')]/..")
    private SelenideElement linkBuilder;

    @FindBy(how = How.XPATH, using = "//p[contains(text(), 'Лента Заказов')]/..")
    private SelenideElement linkOrderList;

    @FindBy(how = How.XPATH, using = "//p[contains(text(), 'Личный Кабинет')]/..")
    private SelenideElement linkPersonalAccount;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'logo')]//a")
    private SelenideElement linkLogo;

    @Step("Нажатие кнопки 'Конструктор'")
    public void clickLinkBuilder(){
        linkBuilder.click();
    }

    @Step("Нажатие кнопки 'Лента Заказов'")
    public void clickLinkOrderList(){
        linkOrderList.click();
    }

    @Step("Нажатие кнопки 'Личный кабинет'")
    public void clickLinkPersonalAccount(){
        linkPersonalAccount.click();
    }

    @Step("Нажатие на лого 'Stellar Burders'")
    public void clickLinkLogo(){
        linkLogo.click();
    }

}