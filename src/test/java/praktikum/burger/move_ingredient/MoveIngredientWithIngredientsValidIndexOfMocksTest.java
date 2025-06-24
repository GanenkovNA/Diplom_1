package praktikum.burger.move_ingredient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.burger.base.OperationsWithIngredientsListOfMocksTestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

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
    public void shouldMoveIngredientInList(){
        // Сохраняем элементы для сравнения
        Ingredient movedIngredient = burger.ingredients.get(index);
        int initialSize = burger.ingredients.size();

        burger.moveIngredient(index, newIndex);

        assertEquals("Количество элементов в списке должно остаться неизменным", initialSize, burger.ingredients.size());
        assertSame("Ингредиент должен быть в списке", movedIngredient, burger.ingredients.get(newIndex));
    }
}
