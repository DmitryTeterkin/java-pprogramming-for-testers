package addressbook.tests;

import addressbook.model.ContactData;
import addressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactModificationTests extends TestBase {

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
  public void testContactModification() {

    Contacts before = app.db().contacts(); // создаем список контактов до изменения
    app.goTo().homePage();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("ivan")
            .withSecondName("ivanov").withAddress("testovii address44444")
            .withEmail("test@test.com555555");
    app.contact().modify(contact); // метод модификации контакта
    app.goTo().homePage();


    //  assertThat(app.contact().count(), equalTo(before.size())); // сравниваем размеры списков до и после изменения контакта
    Contacts after = app.db().contacts(); // создаем список контактов после изменения
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact))); // сравниваем списки контактов до и после

    VerifyContactListInUI();
  }



  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");  // "\\s" - пробельный символ
  }
}
