package addressbook.tests;

import addressbook.model.ContactData;
import addressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() { // проверка предусловий теста
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.goTo().editorPage();
      app.contact().create(new ContactData().withFirstName("Иван").withSecondName("иванов")
              .withAddress("тестовый адрес").withEmail("test@test.com"), true);
      app.goTo().homePage();
    }
  }


  @Test
  public void testContactDeletion() {
    app.goTo().homePage();
    Contacts before = app.db().contacts();; // создаем список контактов до удаления
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size() - 1)); // сравниваем размеры списков до и после удаления контакта
    Contacts after = app.db().contacts();; // создаем список контактов после удаления
    assertThat(after, equalTo(before.without(deletedContact))); // сравниваем списки контактов до и после

    VerifyContactListInUI();
  }

}
