package kjmunz;

import java.io.IOException;

/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k.

For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:

10 = max(10, 5, 2)
7 = max(5, 2, 7)
8 = max(2, 7, 8)
8 = max(7, 8, 7)
Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to store the results. You can simply print them out as you compute them.
 */
public class DCP18Max {
  public static void main(String[] args) {
    int[] a = {10, 5, 2, 7, 8, 7};
    int k = 3;
    maxInKSubs(a, k);
  }

  public static void maxInKSubs(int[] a, int k){
    if(k == 1 || a.length <= 1){
      for (int value : a) {
        System.out.println(value);
      }
    }
    int currLargest = a[0];
    int foundAt = 0;
    for(int n = 1; n < a.length; n++){
      // for the first sub array, need to set up curr largest
      if(n < k){
        if(a[n] > currLargest){
          currLargest = a[n];
          foundAt = n;
        }
        if(n == k-1){
          System.out.println(currLargest);
        }
      } else {
        // now we have a constant currLargest
        if(a[n] > currLargest){
          currLargest = a[n];
          foundAt = n;
        } else if(n-k == foundAt){ // if the one we are losing from the subarray is the max
          currLargest = a[n-k+1];
          foundAt = n-k+1;
          for(int i = n-k+2; i <= n; i++){ // find the new max (NEEDS WORK)
            if(a[i] > currLargest){
              currLargest = a[i];
              foundAt = i;
            }
          }
        }
        System.out.println(currLargest);
      }
    }
  }
}
