package addressbook.tests;

import addressbook.model.GroupData;
import addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;



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
    Groups before = app.group().all(); // построение списка групп до добавления новой группы
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    assertThat(app.group().count(), equalTo(before.size() - 1)); // сравнение количества групп до и после удаления группы хэшированием
    Groups after = app.group().all(); // построение списка групп после добавления новой группы
    assertThat(after, equalTo(before.without(deletedGroup)));
  }

}
