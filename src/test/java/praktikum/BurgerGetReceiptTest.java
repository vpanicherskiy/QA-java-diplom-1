package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public class BurgerGetReceiptTest {
    private final Bun bun;
    private final List<Ingredient> ingredients;
    private final String expectedReceipt;

    public BurgerGetReceiptTest(Bun bun, List<Ingredient> ingredients, String expectedReceipt) {
        this.bun = bun;
        this.ingredients = ingredients;
        this.expectedReceipt = expectedReceipt;
    }

    @Parameterized.Parameters
    public static Object[][] getBurger() {
        return new Object[][]{
                {
                        new Bun("Краторная булка N-200i", 1255),
                        new ArrayList<>(List.of(new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90),
                                new Ingredient(IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1337))),
                        "(==== Краторная булка N-200i ====)\r\n" +
                                "= sauce Соус Spicy-X =\r\n" +
                                "= filling Мясо бессмертных моллюсков Protostomia =\r\n" +
                                "(==== Краторная булка N-200i ====)\r\n\r\n" +
                                "Price: 3937,000000\r\n"
                },
                {
                        new Bun("Флюоресцентная булка R2-D3", 988),
                        new ArrayList<>(),
                        "(==== Флюоресцентная булка R2-D3 ====)\r\n" +
                                "(==== Флюоресцентная булка R2-D3 ====)\r\n\r\n" +
                                "Price: 1976,000000\r\n"
                },
                {
                        new Bun("", 0),
                        new ArrayList<>(List.of(new Ingredient(IngredientType.SAUCE, "", 0))),
                        "(====  ====)\r\n" +
                                "= sauce  =\r\n" +
                                "(====  ====)\r\n\r\n" +
                                "Price: 0,000000\r\n"
                },
                {
                        new Bun(null, 100),
                        new ArrayList<>(List.of(new Ingredient(IngredientType.SAUCE, null, 200))),
                        "(==== null ====)\r\n" +
                                "= sauce null =\r\n" +
                                "(==== null ====)\r\n\r\n" +
                                "Price: 400,000000\r\n"
                }
        };
    }

    @Test
    public void getReceipt() {
        Burger burger = new Burger();
        burger.bun = bun;
        burger.ingredients = ingredients;
        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}
