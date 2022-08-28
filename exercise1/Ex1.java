import java.util.Scanner;

public class Ex1 {

    public static void main(String[] args){
        int[] arr = new int[]{5,6,3,2,5,1,4,9,9,-5}; // change me
        run(arr);

    }
    public static String arrayToString(int[] arr){
        if(arr.length == 0) return "[]";
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[ ");
        for (int i = 0; i < arr.length - 1; i++) {
            stringBuilder.append(arr[i]).append(", ");
        }

        stringBuilder.append(arr[arr.length - 1]).append(" ]");
        return stringBuilder.toString();
    }

    public static void run(int[] arr){
        System.out.println(arrayToString(arr));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Select sorting algorithm:\n1 - BubbleSort\n2 - InsertionSort\n3 - QuickSort");
        String value;
        do{
            value = scanner.nextLine();
        }while (!checker(value, 1 ,3));

        switch (Integer.parseInt(value)) {
            case 1 -> Sorter.bubbleSort(arr);
            case 2 -> Sorter.insertionSort(arr);
            case 3 -> Sorter.quickSort(arr, 0, arr.length - 1);
        }

        System.out.println(arrayToString(arr));

    }

    static boolean checker(String s, int from, int to){ // This class checks if a string matches a span [from,to]
        try {
            int value = Integer.parseInt(s);
            if(value <= to && value >= from) {
                return true;
            } else {
                System.out.println("Value out of range of [" + from + ", " + to + "]");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Input String cannot be parsed to Integer.");
            return false;
        }
    }


    static class Sorter{
        public static void bubbleSort(int[] arr){

            boolean isSorted = false;

            while(!isSorted) {
                isSorted = true;

                for (int i = 1; i < arr.length; i++) {
                    if (arr[i] < arr[i - 1]) {

                        int current = arr[i - 1];
                        arr[i - 1] = arr[i];
                        arr[i] = current;
                        isSorted = false;

                    }
                }
            }
        }

        public static void insertionSort(int[] arr){
            for(int i = 1; i < arr.length; i++){

                int current = arr[i];
                int j = i;

                while (j > 0 && arr[j - 1] > current){
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[j] = current;
            }
        }

        public static void quickSort(int[] arr, int from, int to){
            if(from < to){
                int divideIndex = partition(arr, from, to);
                quickSort(arr, from, divideIndex - 1);
                quickSort(arr, divideIndex, to);
            }
        }
        private static int partition(int[] arr, int from, int to){
            int rightIndex = to;
            int leftIndex = from;
            int pivot = arr[from];

            while (leftIndex <= rightIndex){

                while (arr[leftIndex] < pivot){
                    leftIndex++;
                }

                while (arr[rightIndex] > pivot){
                    rightIndex--;
                }

                if(leftIndex <= rightIndex){
                    swap(arr, rightIndex, leftIndex);
                    leftIndex++;
                    rightIndex--;
                }
            }
            return leftIndex;
        }
        public static void swap(int[] arr, int index1, int index2){
            int current = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = current;
        }
    }
}
