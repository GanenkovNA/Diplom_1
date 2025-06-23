package praktikum.burger.remove_ingredient;

import org.junit.Test;
import praktikum.burger.base.BurgerTestBase;

//Проверяем поведение при удалении элемента из
public class RemoveIngredientFromEmptyListTest extends BurgerTestBase {

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowException() {
        burger.removeIngredient(0);
    }
}
