package addressbook.tests;


import addressbook.model.ContactData;
import addressbook.model.Contacts;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTests extends TestBase {

  // чтение тестовых данных из json файла
  @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException { // итератор массивов объектов
    try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {
      }.getType());
      return contacts.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();
    }
  }

  // чтение тестовых данных из xml файла
  @DataProvider
  public Iterator<Object[]> validContactsFromXml() throws IOException { // итератор массивов объектов
    try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))) {
      String xml = "";
      String line = reader.readLine();
      while (line != null) {
        xml += line;
        line = reader.readLine();
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(ContactData.class);
      List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
      return contacts.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();
    }
  }

 // чтение данных из файла csv формата
 public Iterator<Object[]> validContactsFromCsv() throws IOException { // итератор массивов объектов
    List<Object[]> list = new ArrayList<>();
    try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")))) {
      String line = reader.readLine();
      while (line != null) {
        String[] split = line.split(";");
        list.add(new Object[]{new ContactData().withFirstName(split[0]).withSecondName(split[1]).withGroup(split[2]).withMobilePhone(split[3])});
        line = reader.readLine();
      }
      return list.iterator();
    }
 }

  @Test (dataProvider = "validContactsFromJson")
  public void testContactCreation(ContactData contact) {
    app.goTo().homePage(); // переход на список контактов (если тест выполняется не первым)
    Contacts before = app.db().contacts();
    app.goTo().editorPage(); // переход на страницу редактирования контакта
    app.contact().create(contact, true);
    app.goTo().homePage();         // возврат на список контактов

    assertThat(app.contact().count(), equalTo(before.size() + 1)); // сравниваем размеры списков до и после изменения
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));// сравнивание списков, преобразованных в неотсортированные множества
  }

}
