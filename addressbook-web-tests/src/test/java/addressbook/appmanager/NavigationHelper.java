package addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by dteterkin on 26.01.2017.
 */
public class NavigationHelper extends HelperBase {


  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  // возврат на страницу группы
  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }

  // возврат на страницу контактов
  public void returnToContactList() {
    click(By.linkText("home page"));
  }

  // переход на страницу создания контакта
  public void gotoContactEditorPage() {
    click(By.linkText("add new"));
  }

  //переход на список контактов
  public void gotoContactsPage(){
    click(By.linkText("home"));
  }
}
