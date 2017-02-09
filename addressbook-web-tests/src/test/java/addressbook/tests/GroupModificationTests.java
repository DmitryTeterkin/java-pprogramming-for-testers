package addressbook.tests;

import addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification () {

    app.getNavigationHelper().gotoGroupPage();
// проверка на наличие группы, и если ее нет, то создаем новую группу.
    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test1", "test1", "test2"));
    }
    int before = app.getGroupHelper().getGroupCount(); // количество групп до добавления
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
// оставляем дефолтные поля при изменении группы
    app.getGroupHelper().fillGroupForm(new GroupData("test5", null, null));
        app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    int after = app.getGroupHelper().getGroupCount(); // количество групп после добавления новой группы
    Assert.assertEquals(after, before); // сравнение количества групп до и после добавления новой группы
  }
}
