package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;


public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {

    app.getNavigationHelper().gotoHomePage();
// проверка на наличие контакта и если нет, то создаем его
    if (! app.getContactHelper().isThereAContact()){
      app.getNavigationHelper().gotoContactEditorPage();
      app.getContactHelper().createContact(new ContactData("petro", "petrov", "NiKnAmE", "testovii address", "test@test.com", "[none]"), true);
      app.getNavigationHelper().gotoHomePage();
    }
    List<ContactData> before = app.getContactHelper().getContactList(); // создаем список контактов до изменения
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().gotoEditContact();
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"petro1111", "petrov", null, "testovii address44444","test@test.com555555", "test3");
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().returnToContactList();
    List<ContactData> after = app.getContactHelper().getContactList(); // создаем список контактов после изменения
    Assert.assertEquals(after.size(), before.size()); // сравниваем размеры списков до и после изменения

    before.remove(before.size() - 1); // удаляем из списка before изменяемый контакт (последний)
    before.add(contact); // добавляем в список before контакт с измененными атрибутами
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after)); // сравнивание списков, преобразованных в неотсортированные множества
  }
}
