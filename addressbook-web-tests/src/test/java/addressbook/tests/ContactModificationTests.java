package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.annotations.Test;

/**
 * Created by Dmitry on 29.01.2017.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {

    app.getNavigationHelper().gotoContactsPage();
    app.getContactHelper().selectContact();
    app.getContactHelper().gotoEditContact();
    app.getContactHelper().fillContactForm(new ContactData("petro1111", "petrov22222", "pop33333", "testovii address44444", "test@test.com555555"));
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().returnToContactList();
  }

}
