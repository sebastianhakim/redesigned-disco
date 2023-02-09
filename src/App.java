import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {
    


    // Given arrayLength as argument, create an array of random integers between 0 and 100; return the created array.
public static int[] createRandomArray(int arrayLength) {
int[] array = new int[arrayLength];
Random random = new Random();
for (int i = 0; i < arrayLength; i++) {
array[i] = random.nextInt(100);
}

return array;
}


// Given an integer array and filename, write the array to the file, with each line containing one integer in the array.
public static void writeArrayToFile(int[] array, String filename) {
    try (FileWriter fileWriter = new FileWriter(filename)) {
        for (int i = 0; i < array.length; i ++) {
                fileWriter.write(array[i] + "\n");
        }

    } catch (IOException e) {

    }

    
}



// This is the reverse of writeArrayToFile; Given the filename, read the integers (one line per integer) to an array, and return the array
public static int[] readFileToArray(String filename) {
    ArrayList<Integer> arrayList = new ArrayList<>();
    try {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            arrayList.add(Integer.parseInt(s));
        }
        scanner.close();
    } catch (IOException e) {

    }

int[] array = new int[arrayList.size()];
for (int i = 0; i < array.length;i++) {
        array[i] = arrayList.get(i);
}
  return array;
}

// Given an integer array, sort it in-place, i.e., the order of the elements will be changed so that the final array is in sorted order.
public static void bubbleSort(int[] array) {
    int n = array.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (array[j] > array[j+1])
                {
                    // swap temp and arr[i]
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
       



// The main function will handle a user's keyboard input specified in the next session
public static void main(String[] args) throws Exception {
System.out.println("Enter 1 to sort a random array, 2 to sort an existing file, or \n 3 to generate and store random array in a file ");
Scanner scan = new Scanner(System.in);
    int result = scan.nextInt();
    int[] array = createRandomArray(10);
    int [] arr = readFileToArray("temp.txt");

    if (result == 1) {
        bubbleSort(array);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(array));

}   else if (result == 2) {
    System.out.println("temp.txt before bubbleSort:");
    System.out.println(Arrays.toString(arr));
    bubbleSort(arr);
    System.out.println("temp.txt after bubbleSort:");
    System.out.println(Arrays.toString(arr));

}   else if (result == 3) {
    writeArrayToFile(array, "one.txt");
    System.out.println(Arrays.toString(array));
    System.out.println("Created random array and stored in a file called one.txt");
} else {
System.out.println("Please enter a 1, 2, or 3");
}



scan.close();
}

}

