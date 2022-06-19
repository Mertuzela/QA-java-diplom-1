import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final String stringType;
    private final IngredientType type;

    public  IngredientTypeTest(String stringType, IngredientType type) {
        this.stringType = stringType;
        this.type = type;
    }

        @Parameterized.Parameters(name = "Название и тип: {0}, {1}")
        public static Object[][] setIngredientType() {
                        return new Object[][] {
                {"SAUCE",SAUCE},
                {"FILLING",FILLING}
            };
        }

        @Test
        public void setIngredientTypeTest() {
            Assert.assertEquals(IngredientType.valueOf(stringType),type);
        }
    }