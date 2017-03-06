package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactPhoneTests extends TestBase {

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
// проверяем соответствие телефонов контакта на главной странице и на форме редактирования
  public void testContactPhones() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next(); // выбор какого-то контакта
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact); // загрузка инфы из страницы редактирования контакта

// проверка телефонов контакта
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
  }

  // функция обратного склеивания телефонов.
  private String mergePhones(ContactData contact) {

    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  // функция для замены определенных значений в номере телефона на пусто
  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");  // "\\s" - пробельный символ
  }
}
