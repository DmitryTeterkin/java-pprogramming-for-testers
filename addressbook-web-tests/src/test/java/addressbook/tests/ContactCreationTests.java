package addressbook.tests;


import addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().gotoContactEditorPage(); // переход на страницу редактирования контакта
    ContactData contact = new ContactData("petro", "petrov", "NiKnAmE", "testovii address", "test@test.com", "[none]");
    app.getContactHelper().createContact(contact, true);
    app.getNavigationHelper().gotoHomePage();         // возврат на список контактов
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1); // сравниваем количество контактов до и после


    int max = 0;
    for (ContactData c : after){
      if (c.getId() > max){
        max = c.getId();
      }
    }
    contact.setId(max);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after)); // сравнивание списков, преобразованных в неотсортированные множества
  }

}
