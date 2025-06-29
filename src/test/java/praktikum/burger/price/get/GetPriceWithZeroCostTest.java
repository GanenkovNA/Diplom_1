package praktikum.burger.price.get;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.burger.base.OperationsWithBurgerIngredientsOfMocksTestBase;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class GetPriceWithZeroCostTest extends OperationsWithBurgerIngredientsOfMocksTestBase {
    private final float BUN_COST;
    private final float INGREDIENT_COST;

    public GetPriceWithZeroCostTest(float BUN_COST, float INGREDIENT1_COST) {
        this.BUN_COST = BUN_COST;
        this.INGREDIENT_COST = INGREDIENT1_COST;
    }

    @Parameterized.Parameters()
    public static Object[][] getSumData(){
        return new Object[][]{
                {0, 10},
                {10, 0},
                {0, 0}
        };
    }

    @Test
    public void shouldHandleZeroPricesTest(){
        when(bunMock.getPrice()).thenReturn(BUN_COST);
        when(ingredientMock1.getPrice()).thenReturn(INGREDIENT_COST);

        burger.addIngredient(ingredientMock1);

        assertEquals(BUN_COST * 2 + INGREDIENT_COST, burger.getPrice(), 0.001);
    }
}
