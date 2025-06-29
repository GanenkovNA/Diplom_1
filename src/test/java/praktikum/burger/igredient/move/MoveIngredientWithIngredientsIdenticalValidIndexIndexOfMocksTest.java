package praktikum.burger.igredient.move;

import org.junit.Test;
import praktikum.Ingredient;
import praktikum.burger.base.OperationsWithIngredientsListOfMocksTestBase;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class MoveIngredientWithIngredientsIdenticalValidIndexIndexOfMocksTest extends OperationsWithIngredientsListOfMocksTestBase {

    @Test
    public void shouldNotChangeListTest(){
        index = 2;

        //Сохраняем элементы для сравнения
        List<Ingredient> oldList = burger.ingredients;

        burger.moveIngredient(index, index);

        assertEquals("Список не должен изменяться", oldList, burger.ingredients);
    }
}
