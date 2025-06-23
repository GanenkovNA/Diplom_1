package praktikum.burger;

import org.junit.Test;
import org.mockito.Mock;
import praktikum.Ingredient;

import static org.junit.Assert.assertTrue;

public class AddIngredientTest extends BurgerTestBase{
    @Mock
    Ingredient ingredientMock;

    @Test
    public void shouldAddIngredient(){
        burger.addIngredient(ingredientMock);

        assertTrue(burger.ingredients.contains(ingredientMock));
    }
}
