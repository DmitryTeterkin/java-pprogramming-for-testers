package addressbook.tests;


import addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() {
    app.gotoContactEditorPage();
    app.fillContactForm(new ContactData("petro", "petrov", "pop", "testovii address", "test@test.com"));
    app.submitContactCreation();
    app.returnToContactList();
  }


}
