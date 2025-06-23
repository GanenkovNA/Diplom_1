package praktikum.burger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;

import static org.junit.Assert.*;

//Проверяем, добавляются ли ингредиенты
@RunWith(MockitoJUnitRunner.class)
public class AddIngredientTest extends BurgerTestBase{
    @Mock
    Ingredient ingredientMock;

    @Test
    public void shouldAddIngredient(){
        burger.addIngredient(ingredientMock);

        assertSame("Ингредиент должен быть в списке", ingredientMock, burger.ingredients.get(0));
        assertEquals("В списке должен быть 1 элемент", 1, burger.ingredients.size());
    }
}
