package BasicsProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ShiftArrayByOne {

	public static void main(String[] args) {

		int[] array = {1, 4, 7, 3, 2, 5};

		System.out.println("Original array:");
		printArray(array);
		shiftArrayByOne(array);

		System.out.println("Array after shifting by one:");
		printArray(array);

		System.out.println("******************Using ArrayList*******************************");

		//Using ArrayList:
		List<Integer> arrayList = new ArrayList<>();
		arrayList.add(1);
		arrayList.add(4);
		arrayList.add(7);
		arrayList.add(3);
		arrayList.add(2);
		arrayList.add(5);

		System.out.println("Original ArrayList:");
		printArrayList(arrayList);

		shiftArrayListByOne(arrayList);

		System.out.println("ArrayList after shifting by one:");
		printArrayList(arrayList);

		System.out.println("******************Using HashMap*******************************");

		HashMap<Integer, Integer> hashMap = new HashMap<>();
		int[] arr = {1, 4, 7, 3, 2, 5};

		// Populate the HashMap with array elements
		for (int i = 0; i < arr.length; i++) {
			hashMap.put(i, arr[i]);
		}

		System.out.println("Original HashMap:");
		printHashMap(hashMap);

		shiftHashMapByOne(hashMap, arr.length);

		System.out.println("HashMap after shifting by one:");
		printHashMap(hashMap);
		
		System.out.println("******************Using Iterator*******************************");
		List<Integer> arrayList1 = new ArrayList<>();
		arrayList1.add(1);
		arrayList1.add(4);
		arrayList1.add(7);
		arrayList1.add(3);
		arrayList1.add(2);
		arrayList1.add(5);

        System.out.println("Original ArrayList:");
        printArrayList(arrayList1);

        shiftArrayListByOnee(arrayList1);

        System.out.println("ArrayList after shifting by one:");
        printArrayList(arrayList1);

	}


	//Using For Loop:

	public static void shiftArrayByOne(int[] array) {
		if (array == null || array.length <= 1) {
			return; // No need to shift if array is null or has only one element
		}

		int lastElement = array[array.length - 1];

		// Shift elements to the right by one position
		for (int i = array.length - 1; i > 0; i--) {
			array[i] = array[i - 1];
		}

		// Place the last element at the first position
		array[0] = lastElement;
	}

	public static void printArray(int[] array) {
		for (int element : array) {
			System.out.print(element + " ");
		}
		System.out.println();
	}

	//Using ArrayList:

	public static void shiftArrayListByOne(List<Integer> arrayList) 
	{
		if (arrayList == null || arrayList.size() <= 1) 
		{
			return; // No need to shift if ArrayList is null or has only one element
		}

		// Remove the last element and insert it at the beginning
		Integer lastElement = arrayList.remove(arrayList.size() - 1);
		arrayList.add(0, lastElement);
	}

	public static void printArrayList(List<Integer> arrayList) 
	{
		for (Integer element : arrayList) {
			System.out.print(element + " ");
		}
		System.out.println();
	}

	//Using Hashmap:
	public static void shiftHashMapByOne(HashMap<Integer, Integer> hashMap, int size) {
		if (hashMap == null || size <= 1) {
			return; // No need to shift if HashMap is null or has only one element
		}

		// Get the last element
		int lastElement = hashMap.get(size - 1);

		// Shift elements to the right by one position
		for (int i = size - 1; i > 0; i--) {
			hashMap.put(i, hashMap.get(i - 1));
		}

		// Place the last element at the first position
		hashMap.put(0, lastElement);
	}

	public static void printHashMap(HashMap<Integer, Integer> hashMap) {
		for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
			System.out.print(entry.getValue() + " ");
		}
		System.out.println();
	}
	
	
	//Using Iterator:
	public static void shiftArrayListByOnee(List<Integer> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            return; // No need to shift if ArrayList is null or has only one element
        }

        // Store the last element
        Integer lastElement = arrayList.get(arrayList.size() - 1);

        // Use an iterator to shift elements to the right by one position
        for (int i = arrayList.size() - 1; i > 0; i--) {
            arrayList.set(i, arrayList.get(i - 1));
        }

        // Place the last element at the first position
        arrayList.set(0, lastElement);
	}

    public static void printArrayList1(List<Integer> arrayList) 
    {
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

}