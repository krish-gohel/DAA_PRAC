import java.util.Arrays;
import java.util.Comparator;

class Item {
    double value;
    double weight;

    public Item(double value, double weight) {
        this.value = value;
        this.weight = weight;
    }

    // Calculate value per weight
    public double getValuePerWeight() {
        return value / weight;
    }
}

public class Pract8 {
    
    public static double getMaxValue(Item[] items, double capacity) {
        // Sort items by value per weight in descending order
        Arrays.sort(items, new Comparator<Item>() {
            public int compare(Item a, Item b) {
                return Double.compare(b.getValuePerWeight(), a.getValuePerWeight());
            }
        });

        double totalValue = 0.0;

        for (Item item : items) {
            if (capacity <= 0) {
                break; // No more capacity in the knapsack
            }
            if (item.weight <= capacity) {
                // Take the whole item
                totalValue += item.value;
                capacity -= item.weight;
            } else {
                // Take the fraction of the item
                totalValue += item.getValuePerWeight() * capacity;
                capacity = 0; // The knapsack is full
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Item[] items = {
            new Item(60, 10),
            new Item(100, 20),
            new Item(120, 30)
        };

        double capacity = 50; // Maximum weight capacity of the knapsack

        double maxValue = getMaxValue(items, capacity);
        System.out.println("Maximum value in the knapsack = " + maxValue);
    }
}
