package addressbook.tests;


import addressbook.model.ContactData;
import addressbook.model.Contacts;
import addressbook.model.GroupData;
import addressbook.model.Groups;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;


public class ContactAddToGroupsTests extends TestBase {
  Integer groupId = null;
  private String groupValue = "";
  ContactData contactToGroup = null;
  Integer contactId = null;

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

  @Test // тест добавления контакта в группу
  public void testContactAddToGroup() {
    app.goTo().homePage();
    Contacts contactsBefore = app.db().contacts();
    contactToGroup = contactsBefore.iterator().next();
    contactId = contactToGroup.getId();
    groupId = app.db().groups().iterator().next().getId();
    groupValue = String.valueOf(groupId);
    app.contact().addContactToGroup(contactToGroup, groupValue);
    assertTrue(checkContactAddToGroup(contactId, groupId));
  }
  private boolean checkContactAddToGroup(Integer contactId, Integer groupId) {
    Groups groupsList = app.db().groups();
    boolean contactInGroup = false;
    for (GroupData group : groupsList) {
      GroupData g1 = new GroupData().withId(group.getId()).withContacts(group.getContacts());
      if (g1.getId() == groupId) {
        if (g1.getContacts().stream().mapToInt((c) -> c.getId()).equals(contactId)) {
          contactInGroup = true;
        }
      }
    }
    return contactInGroup;
  }
}