package praktikum.burger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.burger.base.BurgerTestBase;

import static org.junit.Assert.assertSame;

// Проверяем, устанавливается ли `Bun`
@RunWith(MockitoJUnitRunner.class)
public class SetBunsTest extends BurgerTestBase {
    @Mock
    Bun bunMock;

    @Test
    public void shouldSetBunCorrectly(){
        burger.setBuns(bunMock);
        assertSame(bunMock, burger.bun);
    }
}
