package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;


public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions () { // проверка предусловий теста
    app.goTo().homePage();
// проверка на наличие контакта и если нет, то создаем его
    if (app.contact().list().size() == 0) {
      app.goTo().editorPage();
      app.contact().create(new ContactData()
              .withFirstName("petro").withSecondName("petrov").withNickName("NiKnAmE")
              .withAddress("testovii address").withEmail("test@test.com")
              .withGroup("[none]"), true);
      app.goTo().homePage();
    }
  }


  @Test
  public void testContactDeletion() {

    Set<ContactData> before = app.contact().all(); // создаем список контактов до удаления
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().homePage();
    Set<ContactData> after = app.contact().all(); // создаем список контактов после удаления
    Assert.assertEquals(after.size(), before.size() - 1); // сравниваем количество контактов до и после удаления

    before.remove(deletedContact);
    Assert.assertEquals(before, after); // сравнение двух списков как списков, а не по количеству контактов.
  }
}
