package Scenarios;

import Views.Provider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Test1 {
    public static void main(String[] args) throws InterruptedException {

        /*
        Create a Selenium scenario with the following steps:
            ● enter Gmail mailbox
            ● create a new email with a subject and body
            ● send to the same mailbox
        Verify that the email received and containing the proper subject and body
         */


        String mail = "etesting849@gmail.com";
        String subject = "Test Subject";
        String body = "Test Body";

        System.setProperty("Webdriver.Chrome.driver", "C:\\Users\\orang\\Desktop\\Task_GeoComply\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Provider provider = new Provider(driver);
        driver.get("http://gmail.com");
        driver.manage().window().maximize();
        provider.loginScreen.enterMailAndClickNext("etesting849@gmail.com");
        provider.loginScreen.waitForPasswordScreen();
        provider.loginScreen.enterPasswordAndClickNext("Test.1234");
        provider.mainView.waitForMainPageToLoad();
        provider.mainView.openCreateNewMailScreen();
        provider.createMailScreen.waitForCreatorMenuToLoad();
        provider.createMailScreen.createAndSendNewMail(mail, subject, body);
        provider.mainView.verifyIfMailCameCorrectly(subject, body);
        driver.quit();
    }
}
