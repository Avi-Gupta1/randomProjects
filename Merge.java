import java.util.*;

class Merge{
    
    
    public static void main(String args[]) {
        
        int[] arr = {5,7,9,2,3,6,5,4,8,9,10};
        int[] ans = mergeSort(arr,0,arr.length-1);
        
        System.out.println("size : " +ans.length);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
        
    }
    
    public static int[] mergeSort(int[] arr,int low,int high){
        if(low == high) {
            int[] p = new int[1];
            p[0] = arr[low];
            return p;
        }
        int mid = (low+high)/2;
        int[] fsh = mergeSort(arr,low,mid);
        int[] ssh = mergeSort(arr,mid+1,high);
        int[] ans = merge2sorted(fsh,ssh);
        return ans;
    }
    
    public static int[] merge2sorted(int[] a,int[] b) {
        
        
        int[] arr = new int[a.length+b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < a.length && j < b.length) {
            if(a[i] < b[j]) {
                arr[k] = a[i];
                i++;
            }else{
                arr[k] = b[j];
                j++;
            }
            
            k++;
        }
        
        while( i < a.length) {
            arr[k] = a[i];
            i++;
            k++;
        }
        
        while( j < b.length) {
            arr[k] = b[j];
            j++;
            k++;
        }
        
        
        return arr;
    }
    
}