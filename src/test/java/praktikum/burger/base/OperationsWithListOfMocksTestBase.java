package praktikum.burger.base;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Ingredient;

public class OperationsWithListOfMocksTestBase extends BurgerTestBase {
    @Mock
    Ingredient ingredientMock1;
    @Mock
    Ingredient ingredientMock2;
    @Mock
    Ingredient ingredientMock3;
    @Mock
    Ingredient ingredientMock4;
    @Mock
    Ingredient ingredientMock5;

    protected int index;

    @Before
    public void createListOfIngredients(){

        //Требуется для инициализации моков в параметризированных классах
        MockitoAnnotations.openMocks(this);

        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);
        burger.addIngredient(ingredientMock3);
        burger.addIngredient(ingredientMock4);
        burger.addIngredient(ingredientMock5);
    }
}
