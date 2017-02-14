package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class ContactModificationTests extends TestBase {

  @BeforeMethod
   public void ensurePreconditions () { // проверка предусловий теста
    app.getNavigationHelper().gotoHomePage();
// проверка на наличие контакта и если нет, то создаем его
    if (!app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoContactEditorPage();
      app.getContactHelper().createContact(new ContactData("petro", "petrov", "NiKnAmE", "testovii address", "test@test.com", "[none]"), true);
      app.getNavigationHelper().gotoHomePage();
    }
  }

  @Test
  public void testContactModification() {

    List<ContactData> before = app.getContactHelper().getContactList(); // создаем список контактов до изменения
    int index = before.size() - 1; // локальная переменная, показывает количество контактов
    // переменная, содержащая данные для изменяемого контакта
    ContactData contact = new ContactData(before.get(index).getId(),"ivan", "ivanov", null, "testovii address44444","test@test.com555555", "test3");
    app.getContactHelper().modifyContact(index, contact); // метод модификации контакта
    app.getNavigationHelper().returnToContactList();
    List<ContactData> after = app.getContactHelper().getContactList(); // создаем список контактов после изменения
    Assert.assertEquals(after.size(), before.size()); // сравниваем размеры списков до и после изменения

    before.remove(index); // удаляем из списка before изменяемый контакт (последний)
    before.add(contact); // добавляем в список before контакт с измененными атрибутами
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after); // сравнивание списков, преобразованных в неотсортированные множества
  }


}
