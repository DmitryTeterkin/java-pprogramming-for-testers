package addressbook.tests;

import addressbook.model.ContactData;
import addressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions () { // проверка предусловий теста
    app.goTo().homePage();
// проверка на наличие контакта и если нет, то создаем его
    if (app.contact().all().size() == 0) {
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

    Contacts before = app.contact().all(); // создаем список контактов до удаления
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().homePage();
    Contacts after = app.contact().all(); // создаем список контактов после удаления

    assertEquals(after.size(), before.size() - 1); // сравниваем количество контактов до и после удаления
    assertThat(after, equalTo(before.without(deletedContact)));
  }
}
