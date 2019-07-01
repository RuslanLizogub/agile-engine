package ui.settings;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.UUID;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseTestSettings {
    ConfigProvider configProvider = new ConfigProvider();

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver webDriver = new ChromeDriver(options);
        setWebDriver(webDriver);
        // Window maximize
        webDriver.manage().window().maximize();

        Configuration.baseUrl = configProvider.getProperty("baseUrl");
        Configuration.timeout= 10000;
        open("/");
    }


    @AfterClass
    public void tearDown() {
        WebDriverRunner.getWebDriver().quit();
    }

    public static String generatePostText() {
        String uuid = UUID.randomUUID().toString();
        String post = "Post = " + uuid;
        System.out.println("Post text: " + post);
        return post;
    }
}
