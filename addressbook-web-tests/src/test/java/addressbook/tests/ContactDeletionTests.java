package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;




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

    List<ContactData> before = app.contact().list(); // создаем список контактов до удаления
    app.contact().select(before.size() - 1);
    app.contact().deletion();
    app.goTo().homePage();
    List<ContactData> after = app.contact().list(); // создаем список контактов после удаления
    Assert.assertEquals(after.size(), before.size() - 1); // сравниваем количество контактов до и после удаления

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after); // сравнение двух списков как списков, а не по количеству контактов.

  }
}
