package praktikum.burger.base;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Ingredient;

public class OperationsWithBurgerIngredientsOfMocksTestBase extends BurgerTestBase{
    @Mock
    protected Bun bunMock;
    @Mock
    protected Ingredient ingredientMock1;
    @Mock
    protected Ingredient ingredientMock2;

    @Before
    public void setUp(){
        //Требуется для инициализации моков в параметризированных классах
        MockitoAnnotations.openMocks(this);

        burger.setBuns(bunMock);
    }
}
