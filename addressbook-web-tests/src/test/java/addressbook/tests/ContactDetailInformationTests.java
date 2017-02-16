package addressbook.tests;


import addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
//   нужно найти его данные  и сравнить.
   ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact); // загрузка информации со страницы редактирования контакта
   ContactData contactInfoFromViewForm = app.contact().infoFromViewForm(contact); // загрузка инфы из страницы просмотра контакта

// проверка
   assertThat(contactInfoFromViewForm, equalTo((contactInfoFromEditForm)));


  }





  // открытие формы просмотра контакта
  private void initContactViewById(int id) {
    findElement(By.cssSelector(String.format("a[href='view.php?id=%s']", id))).click();
  }
}
