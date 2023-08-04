package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    private IngredientType ingredientType;

    @Test
    public void ingredientTypeSauceTest() {
        assertEquals(ingredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        System.out.println(ingredientType.SAUCE);
        System.out.println(IngredientType.valueOf("SAUCE"));
    }
    @Test
    public void ingredientTypeFillingTest() {
        assertEquals(ingredientType.FILLING, IngredientType.valueOf("FILLING"));

    }
}