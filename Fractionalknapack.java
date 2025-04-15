import java.util.Arrays;



public class GreedyFractionalKnapsack {
    public static double getMaxprofit(Item[] items, int m) {
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));
        double maxprofit = 0.0;

        System.out.println("Items placed in the bag:");

        for (Item item : items) {
            if (item.weight <= m) {
                maxprofit += item.profit;
                System.out.println("Item: (Weight: " + item.weight + ", Profit: " + item.profit + ") - Taken Fully");
                m -= item.weight;
            } else {
                double fraction = (double) m / item.weight;
                maxprofit += item.profit * fraction;
                System.out.printf("Item: (Weight: %.2f, Profit: %.2f) - Taken %.2f%%%n",
                        item.weight * fraction, item.profit * fraction, fraction * 100);
                break;
            }
        }

        return maxprofit;
    }

    public static void main(String[] args) {
        Item[] items = { new Item(10, 60), new Item(20, 100), new Item(30, 120) };
        int m = 50;

        double maxprofit = getMaxprofit(items, m);
        System.out.printf("Maximum profit in Knapsack: %.2f%n", maxprofit);
    }
}
class Item {
    int weight, profit;
    double ratio;

    Item(int weight, int profit) {
        this.weight = weight;
        this.profit = profit;
        this.ratio = (double) profit / weight;
    }
}

// Output
// Items placed in the bag:
// Item: (Weight: 10, Profit: 60) - Taken Fully
// Item: (Weight: 20, Profit: 100) - Taken Fully
// Item: (Weight: 20.00, Profit: 80.00) - Taken 66.67%
// Maximum profit in Knapsack: 240.00
