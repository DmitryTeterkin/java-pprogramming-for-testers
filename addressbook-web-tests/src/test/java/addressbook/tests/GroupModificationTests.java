package addressbook.tests;

import addressbook.model.GroupData;
import org.testng.annotations.Test;

/**
 * Created by Dmitry on 29.01.2017.
 */
public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification () {

    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("test3", "test4", "test5"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  }
}
