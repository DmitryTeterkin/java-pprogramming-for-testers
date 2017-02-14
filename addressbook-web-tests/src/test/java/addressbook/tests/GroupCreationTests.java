package addressbook.tests;

import addressbook.model.GroupData;
import addressbook.model.Groups;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBase {
  // создание группы
  @Test
  public void testGroupCreation() {
    app.goTo().groupPage(); // преход на страницу групп
    Groups before = app.group().all(); // построение списка групп до добавления новой группы
    GroupData group = new GroupData().withName("test1"); // перенос атрибутов новой группы в переменную
    app.group().create(group);
    Groups after = app.group().all(); // построение списка групп после добавления новой группы
    assertThat(after.size(), equalTo(before.size() + 1)); // сравнение количества групп до и после добавления новой группы

    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
}
