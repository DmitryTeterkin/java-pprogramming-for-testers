package addressbook.tests;


import addressbook.model.ContactData;
import addressbook.model.Contacts;
import addressbook.model.GroupData;
import addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeleteFromGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() { // проверка предусловий теста
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.goTo().editorPage();
      app.contact().create(new ContactData().withFirstName("Иван").withSecondName("иванов")
              .withAddress("тестовый адрес").withEmail("test@test.com"), true);
      app.goTo().homePage();
    }
    if (app.db().groups().size() == 0) {         //
      app.goTo().groupPage();            // переход на страницу со списокм групп
      app.group().create(new GroupData().withName("test1")); // заполняем новую группу
    }
  }

  @Test
  public void testContactDeleteFromGroup(){

/*
    Groups groupsBefore = app.db().groups();
    for ()


    app.goTo().homePage();
/*    Groups groupsBefore =

      Contacts contactsBefore = app.db().contacts();
      contactToGroup = contactsBefore.iterator().next();
      ContactData contact = new ContactData().withId(contactToGroup.getId())
              .withFirstName(contactToGroup.getFirstName()).withSecondName(contactToGroup.getSecondName())
              .withAddress(contactToGroup.getAddress()).withEmail(contactToGroup.getEmail())
              .withEmail2(contactToGroup.getEmail2()).withEmail3(contactToGroup.getEmail3())
              .withHomePhone(contactToGroup.getHomePhone()).withMobilePhone(contactToGroup.getMobilePhone())
              .withWorkPhone(contactToGroup.getWorkPhone());
      groupId = app.db().groups().iterator().next().getId();
      groupValue = String.valueOf(groupId);
      app.contact().addContactToGroup(contactToGroup, groupValue);
      Contacts contactsAfter = app.db().contacts();
      assertThat(contactsAfter, equalTo(contactsBefore.without(contactToGroup).withAdded(contact)));

    } // выбираем любую группу, проверяем, есть ли у нее контакты. если есть, удаляем любой, если нет, сначала добавляем в нее контакт, потом удаляем его

*/




  }



}
