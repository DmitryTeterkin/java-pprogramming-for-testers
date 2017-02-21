package addressbook.tests;

import addressbook.model.ContactData;
import addressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;



public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions () { // проверка предусловий теста
    app.goTo().homePage();
// проверка на наличие контакта и если нет, то создаем его
    if (app.contact().all().size() == 0) {
      app.goTo().editorPage();
      app.contact().create(new ContactData()
              .withFirstName("иван").withSecondName("иванов")
              .withAddress("тестовый адрес").withEmail("test@test.com")
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
    assertThat(app.contact().count(), equalTo(before.size() - 1)); // сравниваем размеры списков до и после удаления контакта
    Contacts after = app.contact().all(); // создаем список контактов после удаления
    assertThat(after, equalTo(before.without(deletedContact))); // сравниваем списки контактов до и после
  }
}
