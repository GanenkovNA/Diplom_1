package praktikum.burger.igredient.remove;

import org.junit.Test;
import praktikum.burger.base.BurgerTestBase;

//Проверяем поведение при удалении элемента из
public class RemoveIngredientFromEmptyListTest extends BurgerTestBase {

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionTest() {
        burger.removeIngredient(0);
    }
}
