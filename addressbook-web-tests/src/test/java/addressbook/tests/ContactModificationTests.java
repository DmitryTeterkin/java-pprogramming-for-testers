package addressbook.tests;

import addressbook.model.ContactData;
import addressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;



public class ContactModificationTests extends TestBase {

  @BeforeMethod
   public void ensurePreconditions () { // проверка предусловий теста
    app.goTo().homePage();
// проверка на наличие контакта и если нет, то создаем его
    if (app.contact().all().size() == 0) {
      app.goTo().editorPage();
      app.contact().create(new ContactData().withFirstName("Иван").withSecondName("иванов")
              .withAddress("тестовый адрес").withEmail("test@test.com")
              .withGroup("[none]"), true);
      app.goTo().homePage();
    }
  }

  @Test
  public void testContactModification() {

    Contacts before = app.contact().all(); // создаем список контактов до изменения
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("ivan")
            .withSecondName("ivanov").withAddress("testovii address44444")
            .withEmail("test@test.com555555").withGroup("[none]");
    app.contact().modify(contact); // метод модификации контакта
    app.goTo().homePage();


 //  assertThat(app.contact().count(), equalTo(before.size())); // сравниваем размеры списков до и после изменения контакта
    Contacts after = app.contact().all(); // создаем список контактов после изменения
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact))); // сравниваем списки контактов до и после
  }

  public static String cleaned (String phone){
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");  // "\\s" - пробельный символ
  }
}
