package org.algo;

public class MonotonicArray {
    /* An array is monotonic if it is either monotone increasing or monotone decreasing.An Array A is monotone increasing
    if for all i<=j A[i]<=A[j]. An array is monotone decreasing if for All i<=j A[i] >= A[j]
    return true if and only if the given array A is monotonic
    Input: [1,2,2,3]
    Output: true
    */
    public static void main(String[] args) {

        int[] arr = {1,2,2,3,1,3,3,3,3,3,2};
        System.out.println(checkMonotonicArr(arr));
    }
    public static boolean checkMonotonicArr(int[] array){
        boolean decFlag=true;
        boolean incFlag=true;
        for (int i = 0; i < array.length-1; i++) {
            if(array[i]< array[i+1]) decFlag=false;
            if(array[i]> array[i+1]) incFlag=false;

        }
        return decFlag||incFlag;
    }
}
