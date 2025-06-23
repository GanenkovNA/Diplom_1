package praktikum.burger.move_ingredient;

import org.junit.Test;
import praktikum.Ingredient;
import praktikum.burger.base.OperationsWithListOfMocksTestBase;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class MoveIngredientWithIdenticalValidIndexIndexOfMocksTest extends OperationsWithListOfMocksTestBase {

    @Test
    public void shouldNotChangeList(){
        index = 2;

        //Сохраняем элементы для сравнения
        List<Ingredient> oldList = burger.ingredients;

        burger.moveIngredient(index, index);

        assertEquals("Список не должен изменяться", oldList, burger.ingredients);
    }
}
