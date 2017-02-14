package addressbook.tests;


import addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() {
    Set<ContactData> before = app.contact().all();
    app.goTo().editorPage(); // переход на страницу редактирования контакта
    ContactData contact = new ContactData().withFirstName("petro").withSecondName("petrov").withNickName("NiKnAmE").withAddress("testovii address").withEmail("test@test.com").withGroup("[none]");
    app.contact().create(contact, true);
    app.goTo().homePage();         // возврат на список контактов
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1); // сравниваем количество контактов до и после

    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after); // сравнивание списков, преобразованных в неотсортированные множества
  }

}
