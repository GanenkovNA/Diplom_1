package praktikum.burger.igredient.move;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.burger.base.OperationsWithIngredientsListOfMocksTestBase;

/*
    Тест основан на КЭ и ГЗ.
    Тестируется перемещение элементов со значениями внутри списка
        * `0` - min;
        * `1` - min+1;
        * `2` - значение внутри КЭ
        * `3` - max-1;
        * `4` - max;
 */

@RunWith(Parameterized.class)
public class MoveIngredientWithIngredientsValidIndexOfMocksTest extends OperationsWithIngredientsListOfMocksTestBase {
    private final int newIndex;
    private final SoftAssertions soft = new SoftAssertions();

    public MoveIngredientWithIngredientsValidIndexOfMocksTest(int index, int newIndex, String testName) {
        this.index = index;
        this.newIndex = newIndex;
    }

    @Parameterized.Parameters(name="Тест №{index}: {2}")
    public static Object[][] getSumData(){
        return new Object[][]{
                // Базовые перемещения
                {0, 2, "Первый → в середину"},
                {0, 4, "Первый → в конец"},
                {2, 0, "Середина → в начало"},
                {2, 4, "Середина → в конец"},
                {4, 0, "Последний → в начало"},
                {4, 2, "Последний → в середину"},
                // Специальные случаи
                {0, 1, "Соседнее перемещение (начало)"},
                {4, 3, "Соседнее перемещение (конец)"}
        };
    }

    @Test
    public void shouldMoveIngredientInListTest(){
        // Сохраняем элементы для сравнения
        Ingredient movedIngredient = burger.ingredients.get(index);
        int initialSize = burger.ingredients.size();

        burger.moveIngredient(index, newIndex);

        soft.assertThat(burger.ingredients.size())
                .as("Количество элементов в списке должно остаться неизменным")
                .isEqualTo(initialSize);
        soft.assertThat(burger.ingredients.get(newIndex))
                .as("Ингредиент должен быть в списке")
                .isSameAs(movedIngredient);
        soft.assertAll();
    }
}
