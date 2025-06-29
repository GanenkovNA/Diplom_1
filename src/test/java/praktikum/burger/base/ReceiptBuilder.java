package praktikum.burger.base;

import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

/*
* Класс создан, чтобы не генерировать эталонный чек вручную для каждого теста
* */

public class ReceiptBuilder  {
    private String bunName;
    private float bunPrice;
    private final List<Ingredient> ingredients = new ArrayList<>();

    public ReceiptBuilder withBun(String name, float price) {
        this.bunName = name;
        this.bunPrice = price;
        return this;
    }

    public ReceiptBuilder withIngredient(IngredientType type, String name, float price) {
        ingredients.add(new Ingredient(type, name, price));
        return this;
    }

    public String build() {
        if (bunName == null) {
            throw new IllegalStateException("Bun must be specified");
        }

        StringBuilder receipt = new StringBuilder();
        // Верхняя булочка
        receipt.append(String.format("(==== %s ====)%n", bunName));

        // Ингредиенты
        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n",
                    ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        // Нижняя булочка
        receipt.append(String.format("(==== %s ====)%n", bunName));

        // Общая цена
        float totalPrice = bunPrice * 2 + ingredients.stream()
                .map(Ingredient::getPrice)
                .reduce(0f, Float::sum);

        receipt.append(String.format("%nPrice: %f%n", totalPrice));

        return receipt.toString();
    }
}
