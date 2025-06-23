package praktikum.burger;

import org.junit.Test;
import org.mockito.Mock;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddIngredientTest extends BurgerTestBase{
    @Mock
    Ingredient ingredientMock;

    @Test
    public void shouldAddIngredient(){
        burger.addIngredient(ingredientMock);

        assertTrue("Ингредиент должен быть в списке",burger.ingredients.contains(ingredientMock));
        assertEquals("В списке должен быть 1 элемент", 1, burger.ingredients.size());
    }
}
