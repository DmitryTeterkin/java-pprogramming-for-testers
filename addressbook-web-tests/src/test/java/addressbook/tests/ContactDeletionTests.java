package addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Dmitry on 29.01.2017.
 */
public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {

    app.getNavigationHelper().gotoContactsPage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deletionContact();
    app.getNavigationHelper().gotoContactsPage();
  }
}