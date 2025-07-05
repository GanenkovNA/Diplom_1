package praktikum.burger;

import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;
import praktikum.burger.base.OperationsWithBurgerIngredientsOfMocksTestBase;
import praktikum.burger.base.ReceiptBuilder;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GetReceiptTest extends OperationsWithBurgerIngredientsOfMocksTestBase {
    // Параметры булки
    private static final String BUN_NAME = "black bun";
    private static final float BUN_COST = 100;
    // Параметры ингредиентов
    private static final IngredientType INGREDIENT1_TYPE = IngredientType.FILLING;
    private static final String INGREDIENT1_NAME = "sausage";
    private static final float INGREDIENT1_COST = 300;
    private static final IngredientType INGREDIENT2_TYPE = IngredientType.SAUCE;
    private static final String INGREDIENT2_NAME = "sour cream";
    private static final float INGREDIENT2_COST = 200;

    private String expectedReceipt;

    @Test
    public void shouldReturnReceiptForBurgerWithBunOnlyTest(){
        expectedReceipt = new ReceiptBuilder()
                .withBun(BUN_NAME, BUN_COST)
                .build();

        when(bunMock.getName()).thenReturn(BUN_NAME);
        when(bunMock.getPrice()).thenReturn(BUN_COST);

        assertEquals(expectedReceipt, burger.getReceipt());
    }

    @Test
    public void shouldReturnReceiptForBurgerWithOnlyIngredientTest(){
        expectedReceipt = new ReceiptBuilder()
                .withBun(BUN_NAME, BUN_COST)
                .withIngredient(INGREDIENT1_TYPE, INGREDIENT1_NAME, INGREDIENT1_COST)
                .build();

        when(bunMock.getName()).thenReturn(BUN_NAME);
        when(bunMock.getPrice()).thenReturn(BUN_COST);

        Ingredient ingredientMock1 = mock(Ingredient.class);
        when(ingredientMock1.getType()).thenReturn(INGREDIENT1_TYPE);
        when(ingredientMock1.getName()).thenReturn(INGREDIENT1_NAME);
        when(ingredientMock1.getPrice()).thenReturn(INGREDIENT1_COST);
        burger.addIngredient(ingredientMock1);

        assertEquals(expectedReceipt, burger.getReceipt());
    }

    @Test
    public void shouldReturnReceiptForBurgerWithIngredientsTest(){
        expectedReceipt = new ReceiptBuilder()
                .withBun(BUN_NAME, BUN_COST)
                .withIngredient(INGREDIENT1_TYPE, INGREDIENT1_NAME, INGREDIENT1_COST)
                .withIngredient(INGREDIENT2_TYPE, INGREDIENT2_NAME, INGREDIENT2_COST)
                .build();

        when(bunMock.getName()).thenReturn(BUN_NAME);
        when(bunMock.getPrice()).thenReturn(BUN_COST);

        Ingredient ingredientMock1 = mock(Ingredient.class);
        when(ingredientMock1.getType()).thenReturn(INGREDIENT1_TYPE);
        when(ingredientMock1.getName()).thenReturn(INGREDIENT1_NAME);
        when(ingredientMock1.getPrice()).thenReturn(INGREDIENT1_COST);
        burger.addIngredient(ingredientMock1);

        Ingredient ingredientMock2 = mock(Ingredient.class);
        when(ingredientMock2.getType()).thenReturn(INGREDIENT2_TYPE);
        when(ingredientMock2.getName()).thenReturn(INGREDIENT2_NAME);
        when(ingredientMock2.getPrice()).thenReturn(INGREDIENT2_COST);
        burger.addIngredient(ingredientMock2);

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
