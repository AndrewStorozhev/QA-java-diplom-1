package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTypeTest {

    @Test
    public void ingredientTypeSauceTest() {
        assertEquals(SAUCE, IngredientType.valueOf("SAUCE"));

    }
    @Test
    public void ingredientTypeFillingTest() {
        assertEquals(FILLING, IngredientType.valueOf("FILLING"));

    }
}