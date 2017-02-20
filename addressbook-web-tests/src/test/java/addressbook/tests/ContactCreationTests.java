package addressbook.tests;


import addressbook.model.ContactData;
import addressbook.model.Contacts;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() {
    Contacts before = app.contact().all();
    app.goTo().editorPage(); // переход на страницу редактирования контакта
    ContactData contact = new ContactData().withFirstName("иван")
            .withSecondName("иванов").withAddress("тестовый адрес").withEmail("test@test.com").withGroup("[none]");
    app.contact().create(contact, true);
    app.goTo().homePage();         // возврат на список контактов



    assertThat(app.contact().count(), equalTo(before.size() + 1)); // сравниваем размеры списков до и после изменения
    Contacts after = app.contact().all();


    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));// сравнивание списков, преобразованных в неотсортированные множества
  }

}
