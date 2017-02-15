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
    super(wd);
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

  // клик на редактировании выбранного контакта. Ищем элемент Edit в строке контакта с определенным ID
  public void gotoEditContact(int index) {
    wd.findElement(By.xpath(".//*[@id='maintable']/tbody/tr[td//*[@id='" + index + "']]//*[@title='Edit']")).click();
  }

  // удаление контакта
  public void delete(ContactData сontact) {
    selectContactById(сontact.getId());
    wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
    wd.switchTo().alert().accept();
    contactCash = null;
  }

  // подтверждение создания контакта
  public void create(ContactData contact, boolean creation) {

    fillContactForm(contact, true);
    submitContactCreation();
    contactCash = null;
  }

  // метод проверки наличия контакта
  public boolean isThereAContact() {
    return isElementPresent((By.name("selected[]")));
  }

  // считаем количество контактов по элементу selected
  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  // реализуем кэширование списка контактов, определяем переменную для кэша
  private Contacts contactCash = null;
/*
  public Contacts all() {
    if (contactCash != null) { // проверяем, пустой ли кэш
      return new Contacts(contactCash); // возвращаем копию кэша если он не пустой
    }
    contactCash = new Contacts();
    List<WebElement> rows = wd.findElements(By.name("selected[]"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("/td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("id"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      contactCash.add(new ContactData().withId(id).withFirstName(firstname).withSecondName(lastname));
    }
    return new Contacts(contactCash);
  }
 */
  public Contacts all() {
    if (contactCash != null) { // проверяем, пустой ли кэш
      return new Contacts(contactCash); // возвращаем копию кэша если он не пустой
    }
    contactCash = new Contacts();
    for (int i = 1; i <= count() ; i++){
      String secondName = wd.findElement(By.xpath(".//tbody/tr[" + (i+1) + "]/td[2]")).getText(); // находим фамилию по хпасс
      String name = wd.findElement(By.xpath(".//tbody/tr[" + (i+1) + "]/td[3]")).getText(); // находим имя по хпасс
      int id = Integer.parseInt(wd.findElement(By.xpath(".//tbody/tr[" + (i+1) + "]/td[1]/input")).getAttribute("id")); // находим id по хпасс
      String[] phones = wd.findElement(By.xpath(".//tbody/tr[" + (i+1) + "]/td[6]")).getText().split("\n");
      contactCash.add(new ContactData().withId(id).withFirstName(name).withSecondName(secondName).withHomePhone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2]));
    }
    return new Contacts(contactCash);
  }

// получение информации со страницы редактирования контакта
  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home =  wd.findElement(By.name("home")).getAttribute("value");
    String mobile =  wd.findElement(By.name("mobile")).getAttribute("value");
    String work =  wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstName(firstname).withSecondName(lastname).withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
  }

// метод изменения контакта по Id контакта. Ищем кнопку Edit по Id рандомного контакта
  private void initContactModificationById(int id) {
   wd.findElement(By.cssSelector(String.format("a[edit.php?id=%s]", id))).click();
  }

}