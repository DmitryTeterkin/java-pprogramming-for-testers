package addressbook;


import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() {
    gotoContactEditorPage();
    fillContactForm(new ContactData("petro", "petrov", "pop", "testovii address", "test@test.com"));
    submitContactCreation();
    returnToContactList();
  }


}
