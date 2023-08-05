package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(MockitoJUnitRunner.class)
    public class BurgerTest {
        private  Burger burger;
        @Mock
        Bun bun;
        @Mock
        Ingredient ingredientFilling;
        @Mock
        Ingredient ingredientSauce;

        @Before
        public void setUp(){
             burger = new Burger();
        }

        @Test
        public void addIngredientTest() {
            burger.addIngredient(ingredientFilling);
            assertTrue( burger.ingredients.contains(ingredientFilling));
        }

        @Test
        public void removeIngredientTest() {
        burger.addIngredient(ingredientSauce);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
        }

        @Test
        public void moveIngredientTest() {
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        List<Ingredient> ingredient = new ArrayList<>();
        ingredient.add(ingredientFilling);
        ingredient.add(ingredientSauce);
        burger.moveIngredient(0, 1);
        assertEquals(burger.ingredients, ingredient);
        }

        @Test
        public void getPriceTest() {
            burger.setBuns(bun);
            burger.addIngredient(ingredientFilling);
            burger.addIngredient(ingredientSauce);
            Mockito.when(bun.getPrice()).thenReturn(200f);
            Mockito.when(ingredientFilling.getPrice()).thenReturn(200f);
            Mockito.when(ingredientSauce.getPrice()).thenReturn(200f);
            assertEquals(burger.getPrice(), 800, 1);
        }

        @Test
        public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(ingredientSauce.getName()).thenReturn("hot sauce");
        Mockito.when(ingredientFilling.getName()).thenReturn("cutlet");
        Mockito.when(bun.getPrice()).thenReturn(200f);
        Mockito.when(ingredientFilling.getPrice()).thenReturn(200f);
        Mockito.when(ingredientSauce.getPrice()).thenReturn(200f);
        Mockito.when(ingredientSauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientFilling.getType()).thenReturn(IngredientType.FILLING);
        String newReceipt =
            String.format("(==== %s ====)%n", bun.getName()) +
                    String.format("= %s %s =%n", ingredientSauce.getType().toString().toLowerCase(), ingredientSauce.getName()) +
                    String.format("= %s %s =%n", ingredientFilling.getType().toString().toLowerCase(), ingredientFilling.getName()) +
                    String.format("(==== %s ====)%n", bun.getName()) +
                    String.format("%nPrice: %f%n", (bun.getPrice() * 2 + ingredientFilling.getPrice() + ingredientSauce.getPrice()));
        assertEquals(newReceipt, burger.getReceipt());
        }



}

