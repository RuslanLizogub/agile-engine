package ui.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static ui.settings.BaseTestSettings.generatePostText;

public class MainPage {
    private String generateText = generatePostText();

    private String createPostSelector = "//span[text()=\"Create Post\"]";
    private String writePostSelector = "div[data-testid=\"status-attachment-mentions-input\"]";
    private String savePostButtonSelector = "button[data-testid=\"react-composer-post-button\"]";
    private String postTextSelector = "div[data-testid=\"post_message\"]";
    private String postMenuSelector = "a[data-testid=post_chevron_button]";
    private String postMenuEditSelector = "a[data-testid=feed_post_edit]";
    private String updatePostSelector = "(//div[@data-testid='status-attachment-mentions-input'])[2]";
    private String postEditSaveButtonSelector = "button[data-testid=\"react-composer-post-button\"]";
    private String postMenuDeleteSelector = "(//span[text()=\"Delete\"])[2]";
    private String confirmDeleteButtonSelector = "//button[text()=\"Delete\"]";

    public void postCreate() {
        $x(createPostSelector).shouldBe(Condition.visible).click();
        $(writePostSelector).setValue(" " + generateText);
        $(savePostButtonSelector).click();
        $(postTextSelector).shouldHave(text(generateText));
    }

    public void postEdit() {
        $(postMenuSelector).click();
        $(postMenuEditSelector).click();
        $x(updatePostSelector).setValue(generateText + "1");
        $(postEditSaveButtonSelector).click();
        $(postTextSelector).shouldHave(text(generateText + "1"));
    }

    public void postDelete() {
        $(postMenuSelector).click();
        $x(postMenuDeleteSelector).shouldBe(visible).click();
        $x(confirmDeleteButtonSelector).click();
        $(postTextSelector).shouldNotHave(text(generateText + "1"));
    }
}
