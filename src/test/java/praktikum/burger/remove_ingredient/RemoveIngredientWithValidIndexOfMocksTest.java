package praktikum.burger.remove_ingredient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.burger.base.OperationsWithListOfMocksTestBase;

import static org.junit.Assert.*;

/*
    Тест основан на КЭ и ГЗ.
    Тестируется удаление  элементов со значением внутри списка
        * `0` - min;
        * `1` - min+1;
        * `2` - значение внутри КЭ
        * `3` - max-1;
        * `4` - max;
 */

@RunWith(Parameterized.class)
public class RemoveIngredientWithValidIndexOfMocksTest extends OperationsWithListOfMocksTestBase {

    public RemoveIngredientWithValidIndexOfMocksTest(int index) {
        this.index = index;
    }

    @Parameterized.Parameters()
    public static Object[] getSumData(){
        return new Object[]{0, 1, 2, 3, 4};
    }

    @Test
    public void shouldRemoveIngredient(){
        // Сохраняем элементы для сравнения
        Ingredient ingredientForAssertion = burger.ingredients.get(index);
        int initialSize = burger.ingredients.size();

        burger.removeIngredient(index);

        assertEquals("Количество элементов в списке должно было уменьшиться на 1", initialSize - 1, burger.ingredients.size());
        assertTrue("Ингредиент должен был быть удалён из списка",
                burger.ingredients.stream().noneMatch(element -> element == ingredientForAssertion));
    }
}
