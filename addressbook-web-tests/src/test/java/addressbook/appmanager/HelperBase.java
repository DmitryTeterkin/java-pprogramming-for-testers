package addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class HelperBase {
  protected WebDriver wd;


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
    if (text != null){
// реализация проверки на одинаковость заполнения полей.
      String existingText = wd.findElement(locator).getAttribute("value");
      if (! text.equals(existingText)){
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
    }
  }

  // метод проверки наличия элемента
  protected boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException ex){
      return false;
    }
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
  public void waitpresenceOf(String name) {

    WebDriverWait wait = new WebDriverWait(wd, 10);
    wait.until(presenceOfElementLocated(By.name(name)));
  }

}
