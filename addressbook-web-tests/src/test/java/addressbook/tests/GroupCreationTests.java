package addressbook.tests;

import addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
  // создание группы
  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage(); // преход на страницу групп
    int before = app.getGroupHelper().getGroupCount(); // количество групп до добавления
    app.getGroupHelper().createGroup(new GroupData("test1", "test1", "test2"));
    int after = app.getGroupHelper().getGroupCount(); // количество групп после добавления новой группы
    Assert.assertEquals(after, before + 1); // сравнение количества групп до и после добавления новой группы
  }

}
