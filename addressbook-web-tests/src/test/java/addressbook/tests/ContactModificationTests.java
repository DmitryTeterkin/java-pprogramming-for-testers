package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.annotations.Test;


public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {

    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().gotoEditContact();
    // группа в функции заполения контакта заполнена данными но не передается, т.к. реализована проверка на наличие поля группы
    app.getContactHelper().fillContactForm(new ContactData("petro1111", "petrov22222", "pop33333", "testovii address44444","test@test.com555555", "test3"), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().returnToContactList();
  }

}
