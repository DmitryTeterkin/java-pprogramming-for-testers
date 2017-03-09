package addressbook.tests;


import addressbook.model.ContactData;
import addressbook.model.Contacts;
import addressbook.model.GroupData;
import addressbook.model.Groups;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.acl.Group;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class ContactAddToGroupsTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() { // проверка предусловий теста
    if (app.db().groups().size() == 0) {         //
      app.goTo().groupPage();            // переход на страницу со списокм групп
      app.group().create(new GroupData().withName("test1")); // заполняем новую группу
    }
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.goTo().editorPage();
      app.contact().create(new ContactData().withFirstName("Иван").withSecondName("иванов")
              .withAddress("тестовый адрес").withEmail("test@test.com"), true);
      app.goTo().homePage();
    }
  }

  @Test // тест добавления контакта в произвольную группу
  public void testContactAddToGroup() {
    Contacts contactsList = app.db().contacts();
    Groups groupsList = app.db().groups();// создаем список контактов до изменения
    ContactData modifiedContact = contactsList.iterator().next();// выбираем любой контакт
    String groupName = groupsList.iterator().next().getName(); // берем name любой группы
    app.goTo().homePage(); // переходим на список контактов
    app.contact().addContactToGroup(modifiedContact, groupName); // добавляем контакт в группу
    app.goTo().homePage(); // возвращаемся на страницу с контактами
    // попробовать передать список имен групп контакта в массив и в нем найти группу с именем groupName.

    Assert.assertTrue(modifiedContact.getGroups().contains(groupsList.stream().filter((s) -> !s.equals(groupName)).collect(Collectors.toList())));
//    assertTrue(modifiedContact.getGroups(), equalTo());// здесь проверка на наличие в базе контакта с этим id у которого есть эта группа.
    // нужны проверки
  }




}
