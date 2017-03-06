package addressbook.appmanager;

import addressbook.model.ContactData;
import addressbook.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Objects;


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
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("email2"), contactData.getEmail2());
    type(By.name("email3"), contactData.getEmail3());

    //attach(By.name("photo"), contactData.getPhoto());

    if (creation) {
      if (contactData.getGroups().size() > 0) {
        Assert.assertTrue(contactData.getGroups().size() == 1);
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroups().iterator().next().getName());
      }
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

  }

  public void addContactToGroup(ContactData modifiedContact) {

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
//    contactCash = null;
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

  // создаем список контактов по главной странице адресной книги
  public Contacts all() {
    if (contactCash != null) { // проверяем, пустой ли кэш
      return new Contacts(contactCash); // возвращаем копию кэша если он не пустой
    }
    contactCash = new Contacts();

    for (int i = 1; i <= count(); i++) {
      String secondName = wd.findElement(By.xpath(".//tbody/tr[" + (i + 1) + "]/td[2]")).getText(); // находим фамилию по хпасс
      String name = wd.findElement(By.xpath(".//tbody/tr[" + (i + 1) + "]/td[3]")).getText(); // находим имя по хпасс
      int id = Integer.parseInt(wd.findElement(By.xpath(".//tbody/tr[" + (i + 1) + "]/td[1]/input")).getAttribute("id")); // находим id по хпасс
      String allphones = wd.findElement(By.xpath(".//tbody/tr[" + (i + 1) + "]/td[6]")).getText(); // все телефоны
      String allemales = wd.findElement(By.xpath(".//tbody/tr[" + (i + 1) + "]/td[5]")).getText(); // все емейлы
      String address = wd.findElement(By.xpath(".//tbody/tr[" + (i + 1) + "]/td[4]")).getText(); // находим адрес по хпасс
      contactCash.add(new ContactData().withId(id).withFirstName(name).withSecondName(secondName).withAddress(address).withAllPhones(allphones).withAllEmales(allemales));
    }
    return new Contacts(contactCash);
  }

  // получение информации со страницы редактирования контакта
  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getText();
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String homePhone = wd.findElement(By.name("home")).getAttribute("value");
    String mobilePhone = wd.findElement(By.name("mobile")).getAttribute("value");
    String workPhone = wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();

    return new ContactData().withId(contact.getId())
            .withFirstName(firstname).withSecondName(lastname).withAddress(address).withEmail(email).withEmail2(email2).withEmail3(email3).withHomePhone(homePhone).withMobilePhone(mobilePhone).withWorkPhone(workPhone);
  }

  // получение информации со страницы редактирования контакта для сравнения информации
  public ContactData infoFromEditFormToCompare(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getText();
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String homePhone = wd.findElement(By.name("home")).getAttribute("value");
    String mobilePhone = wd.findElement(By.name("mobile")).getAttribute("value");
    String workPhone = wd.findElement(By.name("work")).getAttribute("value");
    if (!Objects.equals(homePhone, "")) { homePhone = "H:" + homePhone; }
    if (!Objects.equals(mobilePhone, "")) { mobilePhone = "M:" + mobilePhone; }
    if (!Objects.equals(workPhone, "")) { workPhone = "W:" + workPhone; }
    wd.navigate().back();
    return new ContactData().withId(contact.getId())
            .withFirstName(firstname).withSecondName(lastname).withAddress(address)
            .withEmail(email).withEmail2(email2).withEmail3(email3)
            .withHomePhone(homePhone).withMobilePhone(mobilePhone).withWorkPhone(workPhone);
  }


  // метод изменения контакта по Id контакта. Ищем кнопку Edit по Id рандомного контакта
  private void initContactModificationById(int id) {
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }

  // метод получения данных со страницы просмотра контакта
  public ContactData infoFromViewForm(ContactData contact) {
    initContactViewById(contact.getId());
    String information = wd.findElement(By.id("content")).getText();
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withInformation(information);
  }

  // открытие формы просмотра контакта
  private void initContactViewById(int id) {
    wd.findElement(By.cssSelector(String.format("a[href='view.php?id=%s']", id))).click();
  }
}