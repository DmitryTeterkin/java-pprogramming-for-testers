package addressbook.tests;


import addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactDetailInformationTests extends TestBase {

  @BeforeMethod   // проверка предусловий теста
  public void ensurePreconditions () {
    app.goTo().homePage();
// проверка на наличие контакта и если нет, то создаем его
    if (app.contact().all().size() == 0) {
      app.goTo().editorPage();
      app.contact().create(new ContactData().withFirstName("petro").withSecondName("petrov")
              .withAddress("testovii address").withEmail("test@test.com").withGroup("[none]"), true);
      app.goTo().homePage();
    }
  }

 @Test

  public void testContactDetailInformation(){
   app.goTo().homePage();
   ContactData contact = app.contact().all().iterator().next(); // выбор какого-то контакта
   ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
   ContactData contactInfoFromViewForm = app.contact().infoFromViewForm(contact); // загрузка инфы из страницы редактирования контакта
 }


  // метод получения данных со страницы просмотра контакта
  public ContactData infoFromViewForm(ContactData contact) {
    initContactViewById(contact.getId());
    String information = findElement(By.id("content")).getText();

    return new ;
  }

  // открытие формы просмотра контакта
  private void initContactViewById(int id) {
    findElement(By.cssSelector(String.format("a[href='view.php?id=%s']", id))).click();
  }
}
