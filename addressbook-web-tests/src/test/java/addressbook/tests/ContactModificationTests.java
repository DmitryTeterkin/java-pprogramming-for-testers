package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Set;


public class ContactModificationTests extends TestBase {

  @BeforeMethod
   public void ensurePreconditions () { // проверка предусловий теста
    app.goTo().homePage();
// проверка на наличие контакта и если нет, то создаем его
    if (app.contact().all().size() == 0) {
      app.goTo().editorPage();
      app.contact().create(new ContactData().withFirstName("petro").withSecondName("petrov")
              .withNickName("NiKnAmE").withAddress("testovii address")
              .withEmail("test@test.com").withGroup("[none]"), true);
      app.goTo().homePage();
    }
  }

  @Test
  public void testContactModification() {

    Set<ContactData> before = app.contact().all(); // создаем список контактов до изменения
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("ivan")
            .withSecondName("ivanov").withAddress("testovii address44444")
            .withEmail("test@test.com555555").withGroup("test3");
    app.contact().modify(contact); // метод модификации контакта
    app.goTo().homePage();
    Set<ContactData> after = app.contact().all(); // создаем список контактов после изменения
    Assert.assertEquals(after.size(), before.size()); // сравниваем размеры списков до и после изменения

    before.remove(modifiedContact); // удаляем из списка before изменяемый контакт (последний)
    before.add(contact); // добавляем в список before контакт с измененными атрибутами
    Assert.assertEquals(before, after); // сравнивание списков, преобразованных в неотсортированные множества
  }


}
