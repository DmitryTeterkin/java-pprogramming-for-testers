package addressbook.tests;

import addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Set;


public class GroupDeletionTests extends TestBase {

  @BeforeMethod

  public void ensurePreconditions () {                    // проверка предусловий теста
    //  Наличие группы перед ее модификацией
    app.goTo().groupPage();            // переход на страницу со списокм групп
    if (app.group().all().size() == 0){          // проверка на наличие группы, и если ее нет, то создаем новую группу.
      app.group().create(new GroupData().withName("test1")); // заполняем новую группу
    }
  }

  @Test
  public void testGroupDeletion() {
    Set<GroupData> before = app.group().all(); // построение списка групп до добавления новой группы
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Set<GroupData> after = app.group().all(); // построение списка групп после добавления новой группы
    Assert.assertEquals(after.size(), before.size() - 1); // сравнение количества групп до и после удаления группы

    // сравнение списков групп целиком до удаления и после удаления по name
    before.remove(deletedGroup);
    Assert.assertEquals(before, after);
  }

}
