package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTypeTest {
    @Test
    public void ingredientTypeSauce() {
        Assert.assertEquals("SAUCE", IngredientType.SAUCE.name());
    }

    @Test
    public void ingredientTypeFilling() {
        Assert.assertEquals("FILLING", IngredientType.FILLING.name());
    }
}
