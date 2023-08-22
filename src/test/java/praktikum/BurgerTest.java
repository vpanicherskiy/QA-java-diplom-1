package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredientSauce;
    @Mock
    Ingredient ingredientFilling;

    @Before
    public void before() {
        burger = new Burger();
    }

    @Test
    public void setBuns() {
        bun = new Bun("Краторная булка N-200i", 1255);
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(ingredientFilling);
        Assert.assertEquals(ingredientFilling, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(ingredientSauce);
        Assert.assertTrue("Ингридиент не добавлен", !burger.ingredients.isEmpty());

        burger.removeIngredient(0);
        Assert.assertTrue("Ингридиент не удален", burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(ingredientFilling);
        burger.addIngredient(ingredientSauce);

        burger.moveIngredient(0, 1);

        Assert.assertEquals(ingredientSauce, burger.ingredients.get(0));
        Assert.assertEquals(ingredientFilling, burger.ingredients.get(1));
    }

    @Test
    public void getPrice() {
        float bunPrice = 38;
        float saucePrice = 20;
        float fillingPrice = 40;

        float expectedPrice = bunPrice * 2 + saucePrice + fillingPrice;

        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredientSauce.getPrice()).thenReturn(saucePrice);
        Mockito.when(ingredientFilling.getPrice()).thenReturn(fillingPrice);

        burger.bun = bun;
        burger.ingredients.add(ingredientSauce);
        burger.ingredients.add(ingredientFilling);

        Assert.assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceipt() {
        bun = new Bun("Краторная булка N-200i", 1255);
        ingredientSauce = new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90);
        ingredientFilling = new Ingredient(IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1337);

        burger.bun = bun;
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);

        String expectedReceipt = "(==== Краторная булка N-200i ====)\r\n" +
                "= sauce Соус Spicy-X =\r\n" +
                "= filling Мясо бессмертных моллюсков Protostomia =\r\n" +
                "(==== Краторная булка N-200i ====)\r\n\r\n" +
                "Price: 3937,000000\r\n";

        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}
