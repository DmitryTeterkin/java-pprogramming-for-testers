package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {

    app.getNavigationHelper().gotoHomePage();
// проверка на наличие контакта и если нет, то создаем его
    if (! app.getContactHelper().isThereAContact()){
      app.getNavigationHelper().gotoContactEditorPage();
      app.getContactHelper().createContact(new ContactData("petro", "petrov", "NiKnAmE", "testovii address", "test@test.com", "[none]"), true);
      app.getNavigationHelper().gotoHomePage();
    }
    int before = app.getContactHelper().getContactsCount(); // считаем количество контактов на странице
    app.getContactHelper().selectContact();
    app.getContactHelper().gotoEditContact();
    app.getContactHelper().fillContactForm(new ContactData("petro1111", "petrov", null, "testovii address44444","test@test.com555555", "test3"), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().returnToContactList();
    int after = app.getContactHelper().getContactsCount(); // считаем количество контактов после изменения контакта
    Assert.assertEquals(after, before); // сравниваем количество контактов до и после изменения
  }
}
