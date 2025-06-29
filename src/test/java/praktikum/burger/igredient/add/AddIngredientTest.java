package praktikum.burger.igredient.add;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.burger.base.BurgerTestBase;

//Проверяем, добавляются ли ингредиенты
@RunWith(MockitoJUnitRunner.class)
public class AddIngredientTest extends BurgerTestBase {
    private final SoftAssertions soft = new SoftAssertions();

    @Mock
    Ingredient ingredientMock;

    @Test
    public void shouldAddIngredientTest(){
        burger.addIngredient(ingredientMock);

        soft.assertThat(burger.ingredients.get(0))
                .as("Ингредиент должен быть в списке")
                .isSameAs(ingredientMock);
        soft.assertThat(burger.ingredients.size())
                .as("В списке должен быть 1 элемент")
                .isEqualTo(1);
        soft.assertAll();
    }
}
