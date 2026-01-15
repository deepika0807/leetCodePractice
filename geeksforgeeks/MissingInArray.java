package geeksforgeeks;

public class MissingInArray
{
    public static void main(String[] args){
        int[] arr = {8, 2, 4, 5, 3, 7, 1};
        System.out.println(missingNum(arr));
    }


//   static int missingNum(int arr[]) {
//        int counter = 0;
//       int match;
//       while ( counter <= arr.length ){
//            match =0;
//          int value =  arr.length + 1 - counter;
//          for ( int i=0; i < arr.length; i++ ) {
//              if( arr[i] == value ){
//                  break;
//              }
//              match ++;
//          }
//          if(match == arr.length){
//              return value;
//          }
//          counter ++;
//       }
//      return 0;
//    }


    //    https://www.youtube.com/watch?v=bYWLJb3vCWY  (Optimal Solution)
//    This method is efficient with O(n) time complexity and O(1) space complexity.
    static int missingNum(int arr[]) {
        int n = arr.length -1;
        int xorSum = 0;
        for (int num : arr) {
            xorSum ^= num;
        }
        for (int i = 1; i <= n; i++) {
            xorSum ^= i;
        }
        return xorSum;
    }


//Alternative -> Time complexity O(n) and O(1) space complexity.
    //    public int findMissingNumber(int[] arr, int n) {
//        int expectedSum = n * (n + 1) / 2;
//        int actualSum = 0;
//        for (int num : arr) {
//            actualSum += num;
//        }
//        return expectedSum - actualSum;
//    }
}
