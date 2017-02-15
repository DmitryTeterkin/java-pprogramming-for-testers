package addressbook.appmanager;

import addressbook.model.ContactData;
import addressbook.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

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
  public void modify(ContactData contact) {
    selectContactById(contact.getId()); // выбор последнего контакта в списке дл редактирования
    gotoEditContact(contact.getId()); // нажатие на Edit для последнего контакта в списке
    fillContactForm(contact, false);
    submitContactModification();
    contactCash = null;
  }

  // выбор определенного контакта по Id
  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[id ='" + id + "']")).click();
  }

  // подтверждение изменения контакта
  public void submitContactModification() {
    click(By.name("update"));
  }

  // клик на редактировании выбранного контакта ищем элемент Edit в строке контакта с определенным ID
  public void gotoEditContact(int index) {
    wd.findElement(By.xpath(".//*[@id='maintable']/tbody/tr[td//*[@id='" + index + "']]//*[@title='Edit']")).click();
  }

  // удаление контакта новый
  public void delete(ContactData сontact) {
    selectContactById(сontact.getId());
    wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
    wd.switchTo().alert().accept();
    contactCash = null;
  }
  public void create(ContactData contact, boolean creation) {

    fillContactForm(contact, true);
    submitContactCreation();
    contactCash = null;
  }

  public boolean isThereAContact() {
    return isElementPresent((By.name("selected[]")));
  }

  // считаем количество контактов по элементу selected
  public int count() {
   return wd.findElements(By.name("selected[]")).size();
  }


  // реализуем кэширование списка контактов, определяем переменную для кэша
  private Contacts contactCash  = null;

  // создаем список контактов множеством
  public Contacts all() {
    if (contactCash != null) { // проверяем, пустой ли кэш
      return new Contacts(contactCash); // возвращаем копию кэша если он не пустой
    }
    contactCash = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("selected[]"));
    for (int i = 1; i <= count() ; i++){
      String secondName = wd.findElement(By.xpath(".//tbody/tr[" + (i+1) + "]/td[2]")).getText(); // находим фамилию по хпасс
      String name = wd.findElement(By.xpath(".//tbody/tr[" + (i+1) + "]/td[3]")).getText(); // находим имя по хпасс
      int id = Integer.parseInt(wd.findElement(By.xpath(".//tbody/tr[" + (i+1) + "]/td[1]/input")).getAttribute("id")); // находим id по хпасс
      contactCash.add(new ContactData().withId(id).withFirstName(name).withSecondName(secondName));
    }
    return new Contacts(contactCash);
  }

}
