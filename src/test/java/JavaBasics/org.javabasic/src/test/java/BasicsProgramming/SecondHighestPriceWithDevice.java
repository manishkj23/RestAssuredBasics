package BasicsProgramming;

import java.util.ArrayList;
import java.util.List;

public class SecondHighestPriceWithDevice {

	public static void main(String[] args) {

		String[] devices = {"Iphone 11", "iphone 10", "iphone 12", "iphone 15"};
        int[] prices = {100, 200, 300, 200};

        List<String> result = getDevicesWithSecondHighestPrice(devices, prices);
        System.out.println("Devices with the second highest price: " + result);
	}
	
	public static List<String> getDevicesWithSecondHighestPrice(String[] devices, int[] prices) {
        // Find the highest and second highest prices
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;

        for (int price : prices) {
            if (price > highest) {
                secondHighest = highest;
                highest = price;
            } else if (price > secondHighest && price != highest) {
                secondHighest = price;
            }  
        }
        System.out.println("second highest price: " + secondHighest);  
        
        // Collect all devices with the second highest price
        List<String> result = new ArrayList<>();
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] == secondHighest) {
                result.add(devices[i] + " = " + prices[i]);
            }
        }
        return result;        
    }

}
