package addressbook.appmanager;

import addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class ContactHelper extends HelperBase {


  private By locator;

  public ContactHelper(WebDriver wd) {
    super (wd);
  }

  // подтверждение создания контакта
  public void submitContactCreation() {
    click(By.name("submit"));
  }

  // заполнение контакта
  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getSecondName());
    type(By.name("nickname"), contactData.getNickName());
    type(By.name("address"), contactData.getAddress());
    type(By.name("email"), contactData.getEmail());
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  // выбор контакта для изменения или удаления
  public void selectContact() {
    wd.findElement(By.name("selected[]")).click();

  }

  // подтверждение изменения контакта
  public void submitContactModification() {
    click(By.name("update"));
  }

  // клик на редактировании контакта
  public void gotoEditContact() {
    wd.findElement(By.xpath("(//img[@alt='Edit'])[1]")).click();
  }

  // удаление контакта
  public void deletionContact() {
    wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
    wd.switchTo().alert().accept();
  }

  public void createContact(ContactData contact, boolean creation) {

    fillContactForm(contact, true);
    submitContactCreation();

  }

  public boolean isThereAContact() {
    return isElementPresent((By.name("selected[]")));
  }
}
