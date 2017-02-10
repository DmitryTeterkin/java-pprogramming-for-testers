package addressbook.tests;

import addressbook.model.ContactData;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {

    app.getNavigationHelper().gotoHomePage();
// проверка на наличие контакта и если нет, то создаем его
    if (! app.getContactHelper().isThereAContact()){
      app.getNavigationHelper().gotoContactEditorPage();
      app.getContactHelper().createContact(new ContactData("petro", "petrov", "NiKnAmE", "testovii address", "test@test.com", "[none]"), true);
      app.getNavigationHelper().gotoHomePage();
    }
    int before = app.getContactHelper().getContactsCount(); // считаем количество контактов на странице
    app.getContactHelper().selectContact(before - 1);
    app.getContactHelper().deletionContact();
    app.getNavigationHelper().returnToContactList();
    int after = app.getContactHelper().getContactsCount(); // считаем количество контактов после удаления контакта
    Assert.assertEquals(after, before - 1); // сравниваем количество контактов до и после удаления
  }
}
