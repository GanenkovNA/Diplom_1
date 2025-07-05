package praktikum.burger.igredient.remove;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.burger.base.OperationsWithIngredientsListOfMocksTestBase;

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
public class RemoveIngredientWithIngredientsValidIndexOfMocksTest extends OperationsWithIngredientsListOfMocksTestBase {
    private final SoftAssertions soft = new SoftAssertions();

    public RemoveIngredientWithIngredientsValidIndexOfMocksTest(int index) {
        this.index = index;
    }

    @Parameterized.Parameters()
    public static Object[] getSumData(){
        return new Object[]{0, 1, 2, 3, 4};
    }

    @Test
    public void shouldRemoveIngredientTest(){
        // Сохраняем элементы для сравнения
        Ingredient ingredientForAssertion = burger.ingredients.get(index);
        int initialSize = burger.ingredients.size();

        burger.removeIngredient(index);

        soft.assertThat(burger.ingredients.size())
                .as("Количество элементов в списке должно было уменьшиться на 1")
                .isEqualTo(initialSize - 1);
        soft.assertThat(burger.ingredients.stream().noneMatch(element -> element == ingredientForAssertion))
                .as("Ингредиент должен был быть удалён из списка")
                .isTrue();
        soft.assertAll();
    }
}
