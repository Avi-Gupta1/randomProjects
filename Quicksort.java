import java.util.*;
class Quicksort {
    public static void main(String args[]) {

        int[] arr = {
            7,
            9,
            2,
            3,
            6,
            4,
            8,
            9,
            5
        };
      
        quicksort(arr,0,arr.length-1);

        // System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
       }
    }
    
    public static void quicksort(int[] arr,int low,int high) {
        if(low > high) {
            return;
        }
        
        int partnidx = partition_index(arr,low,high);
        quicksort(arr,low,partnidx-1);
        quicksort(arr,partnidx+1,high);   
    }

    public static int partition_index(int[] arr,int low,int high) {

        int i = low;
        int j = low;
        int pivot = arr[high];

        while (i <= high) {

            if (arr[i] > pivot) {
                i++;
            } else {

                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;

                i++;
                j++;
            }
        }
        return j-1;
    }
}