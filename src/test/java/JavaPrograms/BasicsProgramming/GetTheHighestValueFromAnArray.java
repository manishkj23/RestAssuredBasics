package BasicsProgramming;

public class GetTheHighestValueFromAnArray {

	public static void main(String[] args) {

		int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int highest = 0;
        int smallest = 0;
        for ( int i =0;i<arr.length;i++)
        {
            if(arr[i] > highest) // 1 > 0
            {
                int temp = highest;
                highest = arr[i];
                smallest = temp;
            }
        }
        
        System.out.println(highest);
	}

}
