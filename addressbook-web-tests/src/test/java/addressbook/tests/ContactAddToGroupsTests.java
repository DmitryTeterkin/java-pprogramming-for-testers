package addressbook.tests;


import addressbook.model.ContactData;
import addressbook.model.Contacts;
import addressbook.model.GroupData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

    Contacts before = app.db().contacts(); // создаем список контактов до изменения
    app.goTo().homePage(); // переходим на список контактов
    ContactData modifiedContact = before.iterator().next(); // выбираем любой контакт
    app.contact().addContactToGroup(modifiedContact); // добавляем контакт в группу
    app.goTo().homePage(); // возвращаемся на страницу с контактами


    // нужны проверки
  }
}
