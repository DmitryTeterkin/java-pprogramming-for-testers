package addressbook.appmanager;

import addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;


public class ContactHelper extends HelperBase {


  private By locator;

  public ContactHelper(WebDriver wd) {
    super (wd);
  }

  // подтверждение создания контакта
  public void submitContactCreation() {
    click(By.name("submit"));
  }

  // метод заполнения контакта
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

  // метод изменения контакта
  public void modify(int index, ContactData contact) {
    select(index); // выбор последнего контакта в списке дл редактирования
    gotoEditContact(index + 1); // нажатие на Edit для последнего контакта в списке
    fillContactForm(contact, false);
    submitContactModification();
  }
  // выбор определенного контакта для изменения или удаления
  public void select(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  // подтверждение изменения контакта
  public void submitContactModification() {
    click(By.name("update"));
  }

  // клик на редактировании определенного контакта
  public void gotoEditContact(int index) {
    wd.findElement(By.xpath("(//img[@alt='Edit'])["+index+"]")).click();
  }

  // удаление контакта
  public void deletion() {
    wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
    wd.switchTo().alert().accept();
  }

  public void create(ContactData contact, boolean creation) {

    fillContactForm(contact, true);
    submitContactCreation();

  }

  public boolean isThereAContact() {
    return isElementPresent((By.name("selected[]")));
  }

  // считаем количество контактов по элементу selected
  public int getContactsCount() {
   return wd.findElements(By.name("selected[]")).size();
  }

  // создаем список контактов в цикле
  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("selected[]"));
    for (int i = 1; i <= getContactsCount() ; i++){
      String secondName = wd.findElement(By.xpath(".//tbody/tr[" + (i+1) + "]/td[2]")).getText(); // находим фамилию по хпасс
      String name = wd.findElement(By.xpath(".//tbody/tr[" + (i+1) + "]/td[3]")).getText(); // находим имя по хпасс
     // String id = wd.findElement(By.tagName("input")).getAttribute("value"); // находим id по имени input и атрибуту имени value
      int id = Integer.parseInt(wd.findElement(By.xpath(".//tbody/tr[" + (i+1) + "]/td[1]/input")).getAttribute("id")); // находим id по хпасс
      ContactData contact = new ContactData(id, name, secondName, null, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}
