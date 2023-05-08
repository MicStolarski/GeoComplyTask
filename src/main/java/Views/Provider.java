package Views;

import org.openqa.selenium.WebDriver;

public class Provider {
    public LoginScreen loginScreen;
    public CreateMailScreen createMailScreen;
    public MainView mainView;

    public Provider(WebDriver driver) {
        loginScreen = new LoginScreen(driver);
        createMailScreen = new CreateMailScreen(driver);
        mainView = new MainView(driver);
    }
}
