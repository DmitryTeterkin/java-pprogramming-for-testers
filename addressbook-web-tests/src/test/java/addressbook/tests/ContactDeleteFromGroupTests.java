package addressbook.tests;


import addressbook.model.ContactData;
import addressbook.model.Contacts;
import addressbook.model.GroupData;
import addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ContactDeleteFromGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() { // проверка предусловий теста
    // предусловие - создание контакта, если контактов нет.
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.goTo().editorPage();
      app.contact().create(new ContactData().withFirstName("Иван").withSecondName("иванов")
              .withAddress("тестовый адрес").withEmail("test@test.com"), true);
      app.goTo().homePage();
    }
    // предусловие - создание группы, если групп нет.
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
    // предусловие - наличие хотябы одного контакта в любой группе.
    app.goTo().homePage();
    app.contact().addContactToGroup(app.db().contacts().iterator().next(), String.valueOf(app.db().groups().iterator().next().getId()));
  }

  @Test
  public void testContactDeleteFromGroup() {
    Integer groupId = 0;
    Groups groupsList = app.db().groups();
    ContactData deletedContact = null;
    for (GroupData group : groupsList) {
      if (group.getContacts() != null) {
        Contacts contactsListInGroup = group.getContacts();
        groupId = group.getId();
        String groupValue = String.valueOf(groupId);
        app.goTo().homePage();
        deletedContact = app.contact().deleteContactFromGroup(contactsListInGroup, groupValue);
        System.out.println(group);
        System.out.println(deletedContact);
        break;
      }
    }
    Groups newGroupsList = app.db().groups();

    assertTrue(checkContactDeletedFromGroup(newGroupsList, deletedContact, groupId));
  }

  private boolean checkContactDeletedFromGroup(Groups newGroupsList, ContactData deletedContact, Integer groupId) {
    for (GroupData group : newGroupsList){
      if (group.getId() == groupId){
        Contacts contactsListInGroup = group.getContacts();
        for (ContactData contact : contactsListInGroup){
          if (contact == deletedContact){
            return false;
          }
        }
       break;
      }
    }
    return true;
  }
}