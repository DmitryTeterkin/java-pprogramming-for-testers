package addressbook.tests;


import addressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase {


  @BeforeMethod   // проверка предусловий теста
   public void ensurePreconditions () {
    app.goTo().homePage();
// проверка на наличие контакта и если нет, то создаем его
    if (app.contact().all().size() == 0) {
      app.goTo().editorPage();
      app.contact().create(new ContactData().withFirstName("petro").withSecondName("petrov")
              .withNickName("NiKnAmE").withAddress("testovii address")
              .withEmail("test@test.com").withGroup("[none]"), true);
      app.goTo().homePage();
    }
  }

  @Test // тест на проверку соответствия адреса на главной странице адресу на форме редактирования
  public void testContactsAddress(){
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next(); // выбор какого-то контакта
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact); // загрузка инфы из страницы редактирования контакта

    // проверка адреса контакта. При этом чистим данные от пробелов и символов перевода строки
    assertThat(cleaned(contact.getAddress()), equalTo(cleaned(contactInfoFromEditForm.getAddress())));
  }

  // убираем из адреса возможные пробелы (которых может быть больше одного) и переход строки
  public String cleaned (String phone){
    return phone.replaceAll("\n", "").replaceAll(" ", "");
  }
}
