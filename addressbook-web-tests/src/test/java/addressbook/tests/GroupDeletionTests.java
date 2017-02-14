package addressbook.tests;

import addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;


public class GroupDeletionTests extends TestBase {

  @BeforeMethod

  public void ensurePreconditions () {                    // проверка предусловий теста
    //  Наличие группы перед ее модификацией
    app.getNavigationHelper().gotoGroupPage();            // переход на страницу со списокм групп
    if (! app.getGroupHelper().isThereAGroup()){          // проверка на наличие группы, и если ее нет, то создаем новую группу.
      app.getGroupHelper().createGroup(new GroupData("test1", "test1", "test2")); // заполняем новую группу
    }
  }

  @Test
  public void testGroupDeletion() {
    List<GroupData> before = app.getGroupHelper().getGroupList(); // построение списка групп до добавления новой группы
    app.getGroupHelper().selectGroup(before.size() - 1); // выбираем для удаления последнюю группу
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList(); // построение списка групп после добавления новой группы
    Assert.assertEquals(after.size(), before.size() - 1); // сравнение количества групп до и после удаления группы

    // сравнение списков групп целиком до удаления и после удаления по name
    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
   }

}
