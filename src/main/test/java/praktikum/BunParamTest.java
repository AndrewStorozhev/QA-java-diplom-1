package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)

public class BunParamTest {

    private final String name;
    private final float price;
    private Bun bun;

    public BunParamTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getBunParam() {
        return new Object[][]{
                {"Дырка от булки", -1f},
                {"@$%&*()^%$", -5.5f},
                {"Булочка с ничем", 0f},
                {"123456", 10f},
                {"black bun", 100f},
                {"", 50.5f},
                {"white bun", 200.0f},
                {"red bun", 1000000f},
                {null, -0.01f}

        };
    }
    @Before
    public void setUP() {

       bun = new Bun(name, price);
    }
    @Test
    public void getNameBunTest() {
        assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceBunTest() {
        assertEquals(price, bun.getPrice(), 0.1);
    }
}