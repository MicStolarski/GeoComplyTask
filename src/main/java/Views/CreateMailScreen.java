package Views;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateMailScreen {
    private WebDriver driver;

    public CreateMailScreen(WebDriver driver_) {
        driver = driver_;
    }

    public void waitForCreatorMenuToLoad() {
        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(new By.ByCssSelector(".aH9 input")));
        } catch (TimeoutException e) {
            System.out.println("Website have a problem to load menu to create new mail, user can have a bad connection");
        }
    }

    public void createAndSendNewMail(String mail, String subject, String body) {
        try {
            driver.findElement(new By.ByCssSelector(".aH9 input")).sendKeys(mail);
        } catch (NoSuchElementException e) {
            System.out.println("Cant find place to enter a mail");
        }
        try {
            driver.findElement(new By.ByCssSelector(".aoD.az6 input")).sendKeys(subject);
        } catch (NoSuchElementException e) {
            System.out.println("Cant find place to enter a subject");
        }
        try {
            driver.findElement(new By.ByCssSelector(".Ap .Ar.Au div")).sendKeys(body);
        } catch (NoSuchElementException e) {
            System.out.println("Cant find place to enter a body");
        }
        try {
            driver.findElement(new By.ByCssSelector(".dC .T-I.J-J5-Ji.aoO.v7.T-I-atl.L3")).click();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            System.out.println("Problem with SEND button");
        }
    }
}
