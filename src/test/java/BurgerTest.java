import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Ingredient ingredient;
    @Mock
    Bun bun;
    @Mock
    Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test //done
    public void burgerSetBuns(){
        burger.setBuns(bun);
        Assert.assertEquals(burger.bun, bun);
    }

    @Test //done
    public void burgerAddIngredient() {
        burger.addIngredient(ingredient);
        Assert.assertNotNull(burger.ingredients);
    }

    @Test //done
    public void burgerRemoveIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test // done
    public void burgerMoveIngredient() {
        Ingredient cheese = new Ingredient(FILLING,"cheese",0.2f);
        burger.addIngredient(ingredient);
        burger.addIngredient(cheese);
        burger.moveIngredient(1,0);
        Assert.assertEquals(burger.ingredients.get(0),cheese);
    }

    @Test //done
    public void burgerGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(2f);
        Mockito.when(ingredient.getPrice()).thenReturn(4f);
        float expectedPrice = bun.getPrice() *2 + ingredient.getPrice();
        Assert.assertTrue(expectedPrice == burger.getPrice());
    }

    @Test
    public void burgerGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("Булка");
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("Кетчуп");
        String expectedReceipt = String.format("(==== %s ====)%n" + "= %s %s =%n" + "(==== %s ====)%n" + "%nPrice: %f%n",
                                   bun.getName(), ingredient.getType().toString().toLowerCase(),
                                   ingredient.getName(), bun.getName(),burger.getPrice());
        Assert.assertEquals(expectedReceipt,burger.getReceipt());
    }
}