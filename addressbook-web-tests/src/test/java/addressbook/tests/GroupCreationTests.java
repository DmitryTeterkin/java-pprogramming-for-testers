package addressbook.tests;

import addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Set;

public class GroupCreationTests extends TestBase {
  // создание группы
  @Test
  public void testGroupCreation() {
    app.goTo().groupPage(); // преход на страницу групп
    Set<GroupData> before = app.group().all(); // построение списка групп до добавления новой группы
    GroupData group = new GroupData().withName("test1"); // перенос атрибутов новой группы в переменную
    app.group().create(group);
    Set<GroupData> after = app.group().all(); // построение списка групп после добавления новой группы
    Assert.assertEquals(after.size(), before.size() + 1); // сравнение количества групп до и после добавления новой группы

    group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(group); // добавление в коллекцию "до" новой созданной группы
    Assert.assertEquals(before, after);
  }
}
