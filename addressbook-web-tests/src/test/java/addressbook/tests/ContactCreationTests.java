package addressbook.tests;


import addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoContactEditorPage();
    app.getContactHelper().fillContactForm(new ContactData("petro", "petrov", null, null,"testovii address", "test@test.com"));
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().gotoHomePage();
  }

}
