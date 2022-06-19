import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;
    Bun bun;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }
    @Before
    public void setUp() {
        bun = new Bun(name,price);
    }

    @Parameterized.Parameters(name = "Название и цена булки: {0}, {1}")
    public static Object[][] checkBunModel() {
        return new Object[][] {
                {"Кунжутная",85},
                {"Black", 99999},
                {"X", -15},
                {"half-bun", 0.33f},
                {"",0}
        };
    }

    @Test
    public void checkBunCreateName(){
    Assert.assertEquals(name,bun.getName());
}
    @Test
    public void checkBunCreatePrice() {
        Assert.assertTrue(bun.getPrice()== price);
    }
}