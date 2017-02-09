package addressbook.tests;

import addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class GroupCreationTests extends TestBase {
  // создание группы
  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage(); // преход на страницу групп
    List<GroupData> before = app.getGroupHelper().getGroupList(); // построение списка групп до добавления новой группы
    // int before = app.getGroupHelper().getGroupCount(); // количество групп до добавления
    app.getGroupHelper().createGroup(new GroupData("test1", "test1", "test2"));
    List<GroupData> after = app.getGroupHelper().getGroupList(); // построение списка групп после добавления новой группы
    // int after = app.getGroupHelper().getGroupCount(); // количество групп после добавления новой группы
    Assert.assertEquals(after.size(), before.size() + 1); // сравнение количества групп до и после добавления новой группы
  }
}
