package praktikum.burger.igredient.move;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.burger.base.OperationsWithIngredientsListOfMocksTestBase;


/*
    Тест основан на КЭ и ГЗ.
    Тестируется перемещение элементов со значениями вне списка
        * `-1` - min-1;
        * `5` - max+1;
 */

@RunWith(Parameterized.class)
public class MoveIngredientWithIngredientsInvalidIndexOfMocksTest extends OperationsWithIngredientsListOfMocksTestBase {
    private final int newIndex;

    public MoveIngredientWithIngredientsInvalidIndexOfMocksTest(int index, int newIndex, String testName) {
        this.index = index;
        this.newIndex = newIndex;
    }

    @Parameterized.Parameters(name="Тест №{index}: {2}")
    public static Object[][] getSumData(){
        return new Object[][]{
                // Базовые перемещения
                {0, -1, "Существующий → в отрицательное значение"},
                {0, 5, "Существующий → в вне массива"},
                {-1, 0, "Отрицательное значение → в существующий"},
                {5, 0, "Вне массива → в существующий"}
        };
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionTest() {
        burger.moveIngredient(index, newIndex);
    }
}
