package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IngredientTest {
    Ingredient ingredient;

    @Before
    public void before() {
        ingredient = new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90);
    }

    @Test
    public void getPrice() {
        float expectedPrice = 90;
        Assert.assertEquals("Некорректная цена соуса",
                expectedPrice, ingredient.getPrice(), 0);
    }

    @Test
    public void getName() {
        String expectedName = "Соус Spicy-X";
        Assert.assertEquals("Некорректное название соуса",
                expectedName, ingredient.getName());
    }

    @Test
    public void getType() {
        IngredientType expectedType = IngredientType.SAUCE;
        Assert.assertEquals("Некорректный тип соуса",
                expectedType, ingredient.getType());
    }
}
