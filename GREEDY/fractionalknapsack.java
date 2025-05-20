package GREEDY;
import java.util.Arrays;
// Fractional Knapsack Problem
class Item{
    int value,weight;
    Item(int value,int weight){
        this.value=value;
        this.weight=weight;
    }
}
public class fractionalknapsack {

    public static double getMaxValue(int W, Item[] items) {
        // Sort items by value-to-weight ratio in descending order
        Arrays.sort(items, (a, b) -> Double.compare((double)b.value/b.weight, (double)a.value/a.weight));

        double totalValue = 0.0;

        for (Item item : items) {
            if (W == 0) {
                break;
            }
            if (item.weight <= W) {
                W -= item.weight;
                totalValue += item.value;
            } else {
                totalValue += item.value * ((double)W / item.weight);
                W = 0;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        int W=50;
        int[] weight={10,20,30};
        int[] value={60,100,120};
        Item[] items=new Item[value.length];
        for(int i=0;i<value.length;i++){
            items[i]=new Item(value[i],weight[i]);
        }
        double maxValue=getMaxValue(W,items);
        System.out.println("Maximum value in knapsack = " + maxValue);
    }
}
