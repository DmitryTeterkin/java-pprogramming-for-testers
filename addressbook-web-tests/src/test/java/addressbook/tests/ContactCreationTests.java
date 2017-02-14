package addressbook.tests;


import addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() {
    List<ContactData> before = app.contact().list();
    app.goTo().editorPage(); // переход на страницу редактирования контакта
    ContactData contact = new ContactData("petro", "petrov", "NiKnAmE", "testovii address", "test@test.com", "[none]");
    app.contact().create(contact, true);
    app.goTo().homePage();         // возврат на список контактов
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1); // сравниваем количество контактов до и после


    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after); // сравнивание списков, преобразованных в неотсортированные множества
  }

}
