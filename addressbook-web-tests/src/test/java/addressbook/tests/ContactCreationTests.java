package addressbook.tests;


import addressbook.model.ContactData;
import addressbook.model.Contacts;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTests extends TestBase {


  @Test //(enabled = false)
  public void testContactCreation() {
    Contacts before = app.contact().all();
    app.goTo().editorPage(); // переход на страницу редактирования контакта
    File photo = new File("src/test/resources/photo.png");
    ContactData contact = new ContactData().withFirstName("иван")
            .withSecondName("иванов").withAddress("тестовый адрес").withEmail("test@test.com").withGroup("[none]").withPhoto(photo);
    app.contact().create(contact, true);
    app.goTo().homePage();         // возврат на список контактов


    assertThat(app.contact().count(), equalTo(before.size() + 1)); // сравниваем размеры списков до и после изменения
    Contacts after = app.contact().all();


    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));// сравнивание списков, преобразованных в неотсортированные множества
  }


/*
  @Test

  public void testCurrentDir () {

    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/photo.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }
*/


}
