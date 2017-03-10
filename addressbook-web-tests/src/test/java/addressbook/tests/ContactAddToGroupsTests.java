package addressbook.tests;


import addressbook.model.ContactData;
import addressbook.model.Contacts;
import addressbook.model.GroupData;
import addressbook.model.Groups;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    app.goTo().homePage(); // переходим на список контактов
    Contacts contactsList = app.db().contacts();
    ContactData modifiedContact = contactsList.iterator().next();
    Integer groupId = app.db().groups().iterator().next().getId();
    String groupValue = String.valueOf(groupId);
    app.contact().addContactToGroup(modifiedContact, groupValue); // добавляем контакт в группу
    app.goTo().homePage(); // возвращаемся на страницу с контактами

   assertTrue(checkContactAddToGroup(modifiedContact, groupId));
  }


  private boolean checkContactAddToGroup(ContactData modifiedContact, Integer groupId) {
    Groups contactGroups = modifiedContact.getGroups();
    for (GroupData contactGroup : contactGroups){
      if (contactGroup.getId() == groupId){
        return true;
      }
    }return false;
  }
}
