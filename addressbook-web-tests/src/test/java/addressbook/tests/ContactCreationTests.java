package addressbook.tests;


import addressbook.model.ContactData;
import addressbook.model.Contacts;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() { // итератор массивов объектов
    List<Object[]> list = new ArrayList<>();
    File photo = new File("src/test/resources/photo.png");;
    list.add(new Object[] {new ContactData().withFirstName("Ivan1").withSecondName("Ivanov1").withGroup("[none]").withMobilePhone("+(375) 29 555-33-10").withPhoto(photo)});
    list.add(new Object[] {new ContactData().withFirstName("Ivan2").withSecondName("Ivanov2").withGroup("[none]").withMobilePhone("+(375) 29 555-33-11").withPhoto(photo)});
    list.add(new Object[] {new ContactData().withFirstName("Ivan3").withSecondName("Ivanov3").withGroup("[none]").withMobilePhone("+(375) 29 555-33-12").withPhoto(photo)});
    return list.iterator();
  }

  @Test (dataProvider = "validContacts") //(enabled = false)
  public void testContactCreation(ContactData contact) {
    Contacts before = app.contact().all();
    app.goTo().editorPage(); // переход на страницу редактирования контакта
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
