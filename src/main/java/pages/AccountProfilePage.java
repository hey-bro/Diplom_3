package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountProfilePage extends NavBarPage {
    public static final String ACCOUNT_PROFILE_URL = "https://stellarburgers.nomoreparties.site/account/profile";

    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'Выход')]")
    private SelenideElement buttonLogout;

    @Step("Нажимаем кнопку 'Выход'")
    public void clickButtonLogout() {
        buttonLogout.click();
    }

    public SelenideElement getButtonLogout() {
        return buttonLogout;
    }
}