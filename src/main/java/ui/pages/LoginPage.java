package ui.pages;

import ui.settings.ConfigProvider;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private ConfigProvider configProvider = new ConfigProvider();

    private String emailSelector = "#email";
    private String passSelector = "#pass";
    private String loginButtonSelector = "#loginbutton";

    public void login() {
        $(emailSelector).val(configProvider.getProperty("userEmail"));
        $(passSelector).val(configProvider.getProperty("userPass"));
        $(loginButtonSelector).click();
        $(loginButtonSelector).should(disappear);
    }
}
