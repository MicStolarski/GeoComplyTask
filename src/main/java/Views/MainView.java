package Views;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainView {
    private WebDriver driver;

    public MainView(WebDriver driver_) {
        driver = driver_;
    }

    public void waitForMainPageToLoad() {
        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(new By.ByCssSelector(".aic .z0 div")));
        } catch (TimeoutException e) {
            System.out.println("Website have a problem to load main screen, user can have a bad connection");
        }
    }

    public void openCreateNewMailScreen() {
        try {
            driver.findElement(new By.ByCssSelector(".aic .z0 div")).click();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            System.out.println("Problem with NEW MAIL button");
        }
    }

    public void verifyIfMailCameCorrectly(String subject, String body) {
        List<WebElement> mailList = driver.findElements(new By.ByCssSelector(".xS .y6 .bog"));
        for (WebElement webElement : mailList) {
            System.out.println(webElement.getText());
            if (webElement.getText().equals("Test Subject")) {
                webElement.click();
                break;
            }
        }

        String temp_subject = driver.findElement(new By.ByCssSelector(".ha .hP")).getText();
        if (!temp_subject.equals(subject)) {
            System.out.println("Subject is incorrect");
        }

        String temp_body = driver.findElement(new By.ByCssSelector(".a3s.aiL")).getText();
        if (!temp_body.equals(body)) {
            System.out.println("Body is incorrect");
        }
    }
}
