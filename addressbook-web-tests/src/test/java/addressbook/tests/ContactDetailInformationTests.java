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

  @Test (enabled = true)

  public void testContactDetailInformation() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next(); // выбор какого-то контакта
//   нужно найти его данные  и сравнить.
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact); // загрузка информации со страницы редактирования контакта
    ContactData contactInfoFromViewForm = app.contact().infoFromViewForm(contact); // загрузка инфы из страницы просмотра контакта
    String[] Inf = contactInfoFromViewForm.getInformation().split("\n\n"); // попилили из инфомации данные в массив.

    // дальше нужно определиться, что есть что. адрес + фио в одном объекте, телефоны в другом, емейлы в третьем.
    // Нужно проверить какой элемент, к какому относится. В телефонах не должно быть букв, в емейлах не должно быть русских букв и должен быть знак @
    // должно быть сделано 3 проверки - ФИО+адрес, емейлы и телефоны. Емейлы и телефоны уже реализованы.
    // Нужно сделать проверку для ФИО и адреса.
    // Видимо нужно делать через if т.к. ккая-то информация у контакта может вообще отсутствовать.
 //   Pattern fAndAdd = Pattern.compile("[а-яА-Я0-9., \\n-]+");

     for (int i = 0; i < Inf.length; i++) { // в цикле заменим все переводы строк на пробелы.
       if (Inf[i] != "") {
        Inf[i] = Inf[i].replaceAll("\n", " ");
       }
     }



 // assertThat(contactInfoFromViewForm, equalTo((contactInfoFromEditForm)));
  }
// для выделения из Information частей информации о клиенте нужно использовать регулярные выражения:
//      [а-я_А-Я]|\n| - регулярное выражение для выбора ФИО отделяется \n
//              \n\n| |[а-я_А-Я_0-9]|\n|[.,_@-]|\n\n| регулярное выражение для адреса. отделяется от остальных спереди и сзади \n\n, есть пробел точки запятые тире
//    \n\n|[HMW]|[0-9]| |\n|[+,:.()-]|\n\n| регулярное выражение для телефона. отделяется от остальных спереди и сзади \n\n
//  [\w]|[._@-]|\s| регулярное выражение для email-ов (без пробелов). отделяется от остальных \n\n

// функция обратного склеивания телефонов.
//  private String mergePhones(ContactData contact) {
//    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone()).stream().filter((s) -> ! s.equals("")).map(ContactPhoneTests::cleaned).collect(Collectors.joining("\n"));

//}

  // функция обратного склеивания Emails контакта
  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> ! s.equals("")).collect(Collectors.joining("\n"));
  }

}

/* - выделены жирным шрифтом, далее переход строки на адрес. Адрес
Иван Иванович Иванов                  - выделены жирным шрифтом, далее переход строки на адрес. Адрес
Республика Беларусь, Витебская обл. Браславский р-н. п.г.т. Видзы
Ул Советская дом 8 этаж 2 квартира 123

H: +375 29 571 41 80
M: +375-29-571-41-80
W: (+3758029)-571-41-80

test1@test.com
te_st1@test.com
te_st1@test.com





Вот примеры основных метасимволов:
  ^     - (крышка, цирркумфлекс) начало проверяемой строки
  $     - (доллар) конец проверяемой строки
  .     - (точка) представляет собой сокращенную форму записи для символьного класса, совпадающего с любым символом
  |     -  означает «или». Подвыражения, объединенные этим способом, называются альтернативами (alternatives)
  ?     - (знак вопроса) означает, что предшествующий ему символ является необязательным
  +     -  обозначает «один или несколько экземпляров непосредственно предшествующего элемента
  *     –  любое количество экземпляров элемента (в том числе и нулевое)
  \\d   –  цифровой символ
  \\D   –  не цифровой символ
  \\s   –  пробельный символ
  \\S   –  не пробельный символ
  \\w   –  буквенный или цифровой символ или знак подчёркивания
  \\W   –  любой символ, кроме буквенного или цифрового символа или знака подчёркивания
  */



