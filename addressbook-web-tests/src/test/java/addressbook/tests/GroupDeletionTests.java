package addressbook.tests;

import addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;


public class GroupDeletionTests extends TestBase {


  @Test
  public void testGroupDeletion() {
    app.getNavigationHelper().gotoGroupPage();
// проверка на наличие группы, и если ее нет, то создаем новую группу.
    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test1", "test1", "test2"));
    }

    List<GroupData> before = app.getGroupHelper().getGroupList(); // построение списка групп до добавления новой группы
    // int before = app.getGroupHelper().getGroupCount(); // считаем количество групп до добавления
    app.getGroupHelper().selectGroup(before.size() - 1); // выбираем для удаления последнюю группу
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList(); // построение списка групп после добавления новой группы
    //  int after = app.getGroupHelper().getGroupCount(); // считаем количество групп после удаления группы
    Assert.assertEquals(after.size(), before.size() - 1); // сравнение количества групп до и после удаления группы

    // сравнение списков групп целиком до удаления и после удаления по name
    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
   }

}
