package Views;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginScreen {
    private WebDriver driver;

    public LoginScreen(WebDriver driver_) {
        driver = driver_;
    }

    public void enterMailAndClickNext(String mail) {
        try {
            driver.findElement(new By.ByCssSelector("#identifierId")).sendKeys(mail);
        } catch (NoSuchElementException e) {
            System.out.println("Cant find place to enter a mail");
        }

        try {
            driver.findElement(new By.ByCssSelector("#identifierNext")).click();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            System.out.println("Problem with NEXT button");
        }
    }

    public void waitForPasswordScreen() {
        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(new By.ByCssSelector("#passwordNext > div > button")));
        } catch (TimeoutException e) {
            System.out.println("Website have a problem to load password screen, user can have a bad connection");
        }
    }

    public void enterPasswordAndClickNext(String password) {
        try {
            driver.findElement(new By.ByCssSelector("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input")).sendKeys(password);
        } catch (NoSuchElementException e) {
            System.out.println("Cant find place to enter a password");
        }

        try {
            driver.findElement(new By.ByCssSelector("#passwordNext > div > button")).click();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            System.out.println("Problem with NEXT button");
        }

    }

}
