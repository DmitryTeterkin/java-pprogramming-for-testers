package addressbook.tests;

import addressbook.model.GroupData;
import org.testng.annotations.Test;


public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification () {

    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
// оставляем дефолтные поля при изменении группы
    app.getGroupHelper().fillGroupForm(new GroupData("test5", null, null));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  }
}
