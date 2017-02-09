package addressbook.tests;

import addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {
  // создание группы
  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage(); // преход на страницу групп
    List<GroupData> before = app.getGroupHelper().getGroupList(); // построение списка групп до добавления новой группы
    GroupData group = new GroupData("test7", "test1", "test2"); // перенос атрибутов новой группы в переменную
    app.getGroupHelper().createGroup(group);
    List<GroupData> after = app.getGroupHelper().getGroupList(); // построение списка групп после добавления новой группы
    Assert.assertEquals(after.size(), before.size() + 1); // сравнение количества групп до и после добавления новой группы

// поиск группы с максимальным идентификатором с помощью потоков
    group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(group); // добавление в коллекцию "до" новой созданной группы
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after)); // сравнение двух коллекций групп

  }
}
