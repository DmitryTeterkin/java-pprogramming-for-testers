package addressbook.tests;


import addressbook.model.ContactData;
import addressbook.model.Contacts;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException { // итератор массивов объектов
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
    String xml = "";
    String line = reader.readLine();
    while (line != null){
      xml += line;
      line = reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
    return contacts.stream().map((c) -> new Object[] {c}).collect(Collectors.toList()).iterator();
  }

 /*       чтение данных из файла csv формата

 public Iterator<Object[]> validContacts() throws IOException { // итератор массивов объектов
    List<Object[]> list = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
    String line = reader.readLine();
    while (line != null){
      String[] split = line.split(";");
      list.add(new Object[] {new ContactData().withFirstName(split[0]).withSecondName(split[1]).withGroup(split[2]).withMobilePhone(split[3])});
      line = reader.readLine();
    }
    return list.iterator();
  }
*/

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
