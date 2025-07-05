package praktikum.burger.igredient.remove;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.burger.base.OperationsWithIngredientsListOfMocksTestBase;

/*
    Тест основан на КЭ и ГЗ.
    Тестируется удаление элементов со значением вне списка
        * `-1` - min-1;
        * `5` - max+1;
 */

@RunWith(Parameterized.class)
public class RemoveIngredientWithIngredientsInvalidIndexOfMocksTest extends OperationsWithIngredientsListOfMocksTestBase {

    public RemoveIngredientWithIngredientsInvalidIndexOfMocksTest(int index) {
        this.index = index;
    }

    @Parameterized.Parameters()
    public static Object[] getSumData(){
        return new Object[]{-1, 5};
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionTest() {
        burger.removeIngredient(index);
    }
}
