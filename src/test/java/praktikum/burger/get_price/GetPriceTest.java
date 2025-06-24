package praktikum.burger.get_price;

import org.junit.Before;
import org.junit.Test;
import praktikum.burger.base.OperationsWithBurgerIngredientsOfMocksTestBase;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class GetPriceTest extends OperationsWithBurgerIngredientsOfMocksTestBase {
    private static final float BUN_COST = 100;
    private static final float INGREDIENT1_COST = 10;
    private static final float INGREDIENT2_COST = 20;

    @Before
    public void setUpPrices() {
        when(bunMock.getPrice()).thenReturn(BUN_COST);
        when(ingredientMock1.getPrice()).thenReturn(INGREDIENT1_COST);
        when(ingredientMock2.getPrice()).thenReturn(INGREDIENT2_COST);
    }

    //Бургер только с булочкой
    @Test
    public void shouldReturnBunPriceMultipliedByTwo() {
        assertEquals(BUN_COST * 2, burger.getPrice(), 0.001);
    }

    //Бургер с булочкой и одним ингредиентом
    @Test
    public void shouldIncludeIngredientPrice() {
        burger.addIngredient(ingredientMock1);

        assertEquals(BUN_COST * 2 + INGREDIENT1_COST, burger.getPrice(), 0.001);
    }

    //Бургер с несколькими ингредиентами
    @Test
    public void shouldSumAllIngredients(){
        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);

        assertEquals(BUN_COST * 2 + INGREDIENT1_COST + INGREDIENT2_COST, burger.getPrice(), 0.001);
    }
}