package addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by dteterkin on 26.01.2017.
 */
public class NavigationHelper {
 private FirefoxDriver wd;

  public NavigationHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  // возврат на страницу группы
  public void gotoGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  // возврат на страницу контактов
  public void returnToContactList() {
    wd.findElement(By.linkText("home page")).click();
  }

  // добавление контакта
  public void gotoContactEditorPage() {
    wd.findElement(By.linkText("add new")).click();
  }
}
