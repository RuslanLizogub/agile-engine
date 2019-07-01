package ui;

import org.testng.annotations.Test;
import ui.pages.LoginPage;
import ui.pages.MainPage;
import ui.settings.BaseTestSettings;

public class CRUDfacebookPost extends BaseTestSettings {
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();

    @Test
    public void facebookCRUD () {
        loginPage.login();
        mainPage.postCreate();
        mainPage.postEdit();
        mainPage.postDelete();
    }
}
