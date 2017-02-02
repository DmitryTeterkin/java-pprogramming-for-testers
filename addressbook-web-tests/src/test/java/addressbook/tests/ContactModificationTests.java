package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.annotations.Test;


public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {

    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().gotoEditContact();
    app.getContactHelper().fillContactForm(new ContactData("petro1111", "petrov22222", "pop33333", null,"testovii address44444", "test@test.com555555"));
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().returnToContactList();
  }

}
