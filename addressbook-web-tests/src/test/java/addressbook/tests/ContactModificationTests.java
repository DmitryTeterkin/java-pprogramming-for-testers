package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Comparator;
import java.util.List;


public class ContactModificationTests extends TestBase {

  @BeforeMethod
   public void ensurePreconditions () { // проверка предусловий теста
    app.goTo().homePage();
// проверка на наличие контакта и если нет, то создаем его
    if (app.contact().list().size() == 0) {
      app.goTo().editorPage();
      app.contact().create(new ContactData().withFirstName("petro").withSecondName("petrov")
              .withNickName("NiKnAmE").withAddress("testovii address")
              .withEmail("test@test.com").withGroup("[none]"), true);
      app.goTo().homePage();
    }
  }

  @Test
  public void testContactModification() {

    List<ContactData> before = app.contact().list(); // создаем список контактов до изменения
    int index = before.size() - 1; // локальная переменная, показывает количество контактов
    // переменная, содержащая данные для изменяемого контакта
    ContactData contact = new ContactData().withId(before.get(index).getId()).withFirstName("ivan")
            .withSecondName("ivanov").withAddress("testovii address44444")
            .withEmail("test@test.com555555").withGroup("test3");
    app.contact().modify(index, contact); // метод модификации контакта
    app.goTo().homePage();
    List<ContactData> after = app.contact().list(); // создаем список контактов после изменения
    Assert.assertEquals(after.size(), before.size()); // сравниваем размеры списков до и после изменения

    before.remove(index); // удаляем из списка before изменяемый контакт (последний)
    before.add(contact); // добавляем в список before контакт с измененными атрибутами
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after); // сравнивание списков, преобразованных в неотсортированные множества
  }


}
