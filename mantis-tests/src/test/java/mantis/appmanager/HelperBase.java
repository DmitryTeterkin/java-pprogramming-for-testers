package mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class HelperBase {
  protected WebDriver wd;
  protected ApplicationManager app;

    public HelperBase (ApplicationManager app) {
    this.app = app;
    this.wd = app.getDriver();
  }

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }


  // метод click
  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  // метод type
  protected void type(By locator, String text) {
    click(locator);
    if (text != null) {
// реализация проверки на одинаковость заполнения полей.
      String existingText = wd.findElement(locator).getAttribute("value");
      if (!text.equals(existingText)) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
    }
  }

}
