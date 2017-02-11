package addressbook.tests;

import addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


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
    List<ContactData> before = app.getContactHelper().getContactList(); // создаем список контактов до удаления
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().deletionContact();
    app.getNavigationHelper().returnToContactList();
        List<ContactData> after = app.getContactHelper().getContactList(); // создаем список контактов после удаления
    Assert.assertEquals(after.size(), before.size() - 1); // сравниваем количество контактов до и после удаления
  }
}
