package addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class NavigationHelper extends HelperBase {


  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  // возврат на страницу группы
  public void gotoGroupPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new"))){
      return;
    }
    click(By.linkText("groups"));
  }
  // возврат на страницу контактов
  public void returnToContactList() {

    if (isElementPresent(By.linkText("home page"))) {
      click(By.linkText("home page"));
    }
  }


    // переход на страницу создания контакта
  public void gotoContactEditorPage() {
    if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")){
      return;
    }
    click(By.linkText("add new"));
  }

  //переход на список контактов
  public void gotoHomePage(){
    if (isElementPresent(By.id("maintable"))){
      return;
    }
    click(By.linkText("home"));
  }
}
