package addressbook.tests;

import addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification () {

    app.getNavigationHelper().gotoGroupPage();
// проверка на наличие группы, и если ее нет, то создаем новую группу.
    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test1", "test1", "test2"));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList(); // построение списка групп до добавления новой группы
    //int before = app.getGroupHelper().getGroupCount(); // считаем количество групп до добавления
    app.getGroupHelper().selectGroup(before.size() - 1);// выбираем для модификации последнюю группу
    app.getGroupHelper().initGroupModification();
// оставляем дефолтные поля при изменении группы
    app.getGroupHelper().fillGroupForm(new GroupData("test5", null, null));
        app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList(); // построение списка групп после добавления новой группы
   // int after = app.getGroupHelper().getGroupCount(); // считаем количество групп после изменения группы
    Assert.assertEquals(after.size(), before.size()); // сравнение количества групп до и после изменения группы
  }
}
