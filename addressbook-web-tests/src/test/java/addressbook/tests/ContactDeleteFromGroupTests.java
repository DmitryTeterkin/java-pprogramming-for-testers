package addressbook.tests;


import addressbook.model.ContactData;
import addressbook.model.GroupData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    // выбираем любую группу, проверяем, есть ли у нее контакты. если есть, удаляем любой, если нет, сначала добавляем в нее контакт, потом удаляем его






  }



}
