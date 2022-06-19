import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static praktikum.IngredientType.SAUCE;
import static praktikum.IngredientType.FILLING;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;
    Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Before
    public void setUp() {
        ingredient = new Ingredient(type,name,price);
    }

    @Parameterized.Parameters(name = "Тип начинки, название, цена: {0}, {1}, {2}")
    public static Object[][] checkIngredients(){
            return new Object[][] {
                    {SAUCE,"Кетчуп",10},
                    {SAUCE,"Soy",-90000},
                    {SAUCE,null,0.71f},
                    {FILLING,"",0f},
                    {FILLING,"Ginger",-10},
                    {FILLING,null,5.45f}
            };
    }

    @Test
    public void checkIngredientName(){
        Assert.assertEquals(name, ingredient.getName());
    }
    @Test
    public void checkIngredientType() {
        Assert.assertEquals(type, ingredient.getType());
    }
    @Test
    public void checkIngredientPrice() {
        Assert.assertTrue(price == ingredient.getPrice());
    }
}