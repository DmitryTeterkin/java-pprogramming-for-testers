package addressbook.tests;


import addressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
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
      app.contact().create(new ContactData().withFirstName("Иван").withSecondName("Иванов")
              .withAddress("Тестовый адрес").withEmail("test@test.com").withGroup("[none]"), true);
      app.goTo().homePage();
    }
  }

  @Test
  /*
  проверка соответствия информации, отображаемой на странице просмотра контакта,
  с информацией, которая заносилась на странице редактирования контакта.
  */
  public void testContactDetailInformation() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next(); // выбор какого-то контакта
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact); // загрузка информации со страницы редактирования контакта
    ContactData contactInfoFromViewForm = app.contact().infoFromViewForm(contact); // загрузка информации со страницы просмотра контакта
/*
данные из страницы инфомации переносим в массив.
Разделитель - двойной переход строки.
*/
    String[] Inf = contactInfoFromViewForm.getInformation().split("\n\n");
/*
в цикле заменяем все переходы строк в элементах массива на пробелы,
из телефонов удаляем символы принадлежности (домашний, мобильный, рабочий).
*/
    for (int i = 0; i < Inf.length; i++) {
      if (Inf[i] != "") {
        Inf[i] = Inf[i].replaceAll("\n", " ").replaceAll("W: ", "").replaceAll("M: ", "").replaceAll("H: ", "");
      }
    }

// создаем правила для регулярных выражений.
    Pattern fioAndAddress = Pattern.compile("^[a-zA-Zа-яА-Я0_9., -]+$"); // регулярное выражение для адреса и ФИО
    Pattern emales = Pattern.compile("^(\\w*@\\w*.\\w*| |)+$");       // регулярное выражение для Email.
    Pattern phones = Pattern.compile("^[0-9)( +-]+$");                // регулярное выражение для телефонов

/*
создаем цикл, в котором будем проверять информацию
со страницы просмотра информации на соответствие регулярным выражениям
проверка в цикле нужна потому, что мы не знаем какую информацию
пользователеь указал для контакта, а какую - нет, поэтому проверяем каждый элемент массива
*/
    for (int i = 0; i < Inf.length; i++) {
      Matcher fioandAddress = fioAndAddress.matcher(Inf[i]);
      Matcher emale = emales.matcher(Inf[i]);
      Matcher phone = phones.matcher(Inf[i]);
/*
проверяем, совпадает ли значение элемента массива с регулярным выражением для ФИО и адреса,
и если да, то выполняем сравнение для адреса + ФИО.
*/
      if (fioandAddress.matches()) {
        assertThat(Inf[i], equalTo(cleaned(mergeFioAddress(contactInfoFromEditForm))));
      }
/*
проверяем, совпадает ли значение элемента массива с регулярным выражением для Email,
и если да, выполняем сравнение для емейлов
*/
      if (emale.matches()) {
        assertThat(Inf[i], equalTo(cleaned(mergeEmails(contactInfoFromEditForm))));
      }
/*
проверяем, совпадает ли значение элемента массива с регулярным выражением для Email,
и если да, выполняем сравнение для емейлов
*/
      if (phone.matches()) {
        assertThat(Inf[i], equalTo(cleaned(mergePhones(contactInfoFromEditForm))));
      }
    }
  }

  // замена переходов строки на пробел
  private String cleaned(String clean) {
    return clean.replaceAll("\n", " ");
  }

  // функция обратного склеивания ФИО и адреса контакта
  private String mergeFioAddress(ContactData contact) {
    return Arrays.asList(contact.getFirstName(), contact.getSecondName(), contact.getAddress())
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining(" "));
  }

  // функция обратного склеивания Emails контакта
  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n"));
  }

  // функция обратного склеивания телефонов контакта
  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n"));
  }

}