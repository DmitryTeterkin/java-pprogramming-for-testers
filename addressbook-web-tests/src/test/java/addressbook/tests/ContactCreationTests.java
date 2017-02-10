package addressbook.tests;


import addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() {

    int before = app.getContactHelper().getContactsCount(); // считаем количество контактов на странице
    app.getNavigationHelper().gotoContactEditorPage(); // переход на страницу редактирования контакта
    app.getContactHelper().createContact(new ContactData("petro", "petrov", "NiKnAmE", "testovii address", "test@test.com", "[none]"), true);
    app.getNavigationHelper().gotoHomePage();         // возврат на список контактов
    int after = app.getContactHelper().getContactsCount(); // считаем количество контактов после создания нового контакта
    Assert.assertEquals(after, before + 1); // сравниваем количество контактов до и после
  }

}
