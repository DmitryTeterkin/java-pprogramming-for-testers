package addressbook.appmanager;

import addressbook.model.ContactData;
import addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by dteterkin on 26.01.2017.
 */
public class ApplicationManager {
  FirefoxDriver wd;

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public void init() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost:7080/addressbook/group.php");
    login("admin", "secret"); // логин
  }

  // заполнение окна логина
  private void login(String username, String password) {
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }

  // возврат на список групп
  public void returnToGroupPage() {
    wd.findElement(By.linkText("group page")).click();
  }

  // подтверждение создания группы
  public void submitGroupCreation() {
    wd.findElement(By.name("submit")).click();
  }

  // заполнение группы
  public void fillGroupForm(GroupData groupData) {
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
    wd.findElement(By.name("group_header")).click();
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    wd.findElement(By.name("group_footer")).click();
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }

  // создание новой группы
  public void initGroupCreation() {
    wd.findElement(By.name("new")).click();
  }

  // возврат на страницу группы
  public void gotoGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  public void stop() {
    wd.quit();
  }

  // удаление выбранных групп
  public void deleteSelectedGroups() {
    wd.findElement(By.name("delete")).click();
  }

  // выбор группы
  public void selectGroup() {
    wd.findElement(By.name("selected[]")).click();
  }

  // возврат на страницу контактов
  public void returnToContactList() {
    wd.findElement(By.linkText("home page")).click();
  }

  // подтверждение создания контакта
  public void submitContactCreation() {
    wd.findElement(By.name("submit")).click();
  }

  // заполнение контакта
  public void fillContactForm(ContactData contactData) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(contactData.getSecondName());
    wd.findElement(By.name("middlename")).click();
    wd.findElement(By.name("nickname")).click();
    wd.findElement(By.name("nickname")).clear();
    wd.findElement(By.name("nickname")).sendKeys(contactData.getNickName());
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
  }

  // добавление контакта
  public void gotoContactEditorPage() {
    wd.findElement(By.linkText("add new")).click();
  }
}
