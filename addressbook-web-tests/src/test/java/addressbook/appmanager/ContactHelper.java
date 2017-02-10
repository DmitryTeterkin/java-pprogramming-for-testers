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
  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
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

  //
  public int getContactsCount() {
   return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("td.center"));
    for (WebElement element : elements){
      String name = element.getText(); // здесь явно нужно искать не по гет текст.
      String secondName = element.getText(); // здесь явно нужно искать не по гет текст.
      ContactData contact = new ContactData(name, secondName, null, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}
