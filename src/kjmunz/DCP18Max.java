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
    int[] answer = maxInKSubs(a, k);
  }

  public static int[] maxInKSubs(int[] a, int k){
    if(k == 1 || a.length <= 1){
      for (int value : a) {
        System.out.println(value);
      }
      return a;
    }
    int[] ans = new int[a.length - k + 1];
    int ansInd = 0;

    int currLargest = a[0];

    NextLargest nextLargest = new NextLargest(k);
    for(int n = 1; n < a.length; n++){
      if(a[n] > currLargest){
        currLargest = a[n];
        nextLargest.resetContent();
      } else {
        nextLargest.insert(a[n]);
      }
      if(n >= k && a[n-k] == currLargest){ // if the one we are losing from the subarray is the max
        currLargest = nextLargest.popLargest();
      }
      if(n >= k - 1) {
        System.out.println(currLargest);
        ans[ansInd] = currLargest;
        ansInd++;
      }
    }
    return ans;
  }
}
