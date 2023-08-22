package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BunTest {
    Bun bun;

    @Before
    public void before() {
        bun = new Bun("Краторная булка N-200i", 1255);
    }

    @Test
    public void getName() {
        String expectedName = "Краторная булка N-200i";
        String actualName = bun.getName();
        Assert.assertEquals("Некорректное название булочки",
                expectedName,
                actualName);
    }

    @Test
    public void getPrice() {
        float expectedPrice = 1255;
        float actualPrice = bun.getPrice();
        Assert.assertEquals("Некорректная цена булочки",
                expectedPrice, actualPrice, 0);
    }
}
