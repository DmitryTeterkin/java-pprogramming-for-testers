package addressbook.tests;


import addressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDetailInformationTests extends TestBase {

  @BeforeMethod   // проверка предусловий теста
  public void ensurePreconditions() {
    app.goTo().homePage();
// проверка на наличие контакта и если нет, то создаем его
    if (app.contact().all().size() == 0) {
      app.goTo().editorPage();
      app.contact().create(new ContactData().withFirstName("petro").withSecondName("petrov")
              .withAddress("testovii address").withEmail("test@test.com").withGroup("[none]"), true);
      app.goTo().homePage();
    }
  }

  @Test

  public void testContactDetailInformation() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next(); // выбор какого-то контакта
//   нужно найти его данные  и сравнить.
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact); // загрузка информации со страницы редактирования контакта
    ContactData contactInfoFromViewForm = app.contact().infoFromViewForm(contact); // загрузка инфы из страницы просмотра контакта
    String Information = contactInfoFromViewForm.getInformation();
    Pattern Fio = Pattern.compile("[а-яА-Я]| |\n");
    Pattern Address = Pattern.compile("\\n\\n+| |[а-я,А-Я]|[0-9]|[.,_@-]|\\n\\n");
    Pattern Phones = Pattern.compile("\\n\\n+|[HMW]|[0-9]| |\\n|[+,:.()-]|\\n\\n|");
    Pattern Emailes = Pattern.compile("\\n\\n+|[\\w]|[._@-]|\\s|");
    Matcher fio = Fio.matcher(Information);
    while (fio.find()){
      System.out.println(fio.group());
    }



// проверка
   // assertThat(contactInfoFromViewForm, equalTo((contactInfoFromEditForm)));
  }
// для выделения из Information частей информации о клиенте нужно использовать регулярные выражения:
//      [а-я_А-Я]|\n| - регулярное выражение для выбора ФИО отделяется \n
//              \n\n| |[а-я_А-Я_0-9]|\n|[.,_@-]|\n\n| регулярное выражение для адреса. отделяется от остальных спереди и сзади \n\n, есть пробел точки запятые тире
//    \n\n|[HMW]|[0-9]| |\n|[+,:.()-]|\n\n| регулярное выражение для телефона. отделяется от остальных спереди и сзади \n\n
//  [\w]|[._@-]|\s| регулярное выражение для email-ов (без пробелов). отделяется от остальных \n\n

// функция обратного склеивания телефонов.
  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));

  }

  // функция обратного склеивания Emails контакта
  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> ! s.equals("")).collect(Collectors.joining("\n"));
  }


}



