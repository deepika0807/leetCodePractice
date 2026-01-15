package geeksforgeeks.Arrays.LeetCode.SlidingWindowFixedSize;

//If you’re asked to compute something (like sum, average, max, etc.) over all subarrays of size k, it’s almost always a sliding window problem.
public class MaxAvgSubArrayI
{
    public static void main ( String[] args ){
        int[] nums = {1,12,-5,-6,50,3};
        int k=4;
        System.out.println(findMaxAverageBruteForce(nums, k));
//        System.out.println(findMaxAverage(nums, k));
//        System.out.println(findMaxAverageBruteForceII(nums,k));
        System.out.println(findMaxAverageII(nums, k));
    }

//    Brute Force Solution
    public static double findMaxAverageBruteForce(int[] nums, int k) {
        double maxAvg = Double.NEGATIVE_INFINITY;

        for (int i = 0; i <= nums.length - k; i++) {
            double sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += nums[j];
            }
            maxAvg = Math.max(maxAvg, sum / k);
        }
        return maxAvg;
    }

//     Optimised Solution
    public static double findMaxAverage(int[] nums, int k) {
        double maxAvg = Double.NEGATIVE_INFINITY;
        double sum = 0.0;
        double avg = 0.0;
        int p1 = 0, p2 = 0;
        while ( p2< nums.length && p2 < k ){
            sum = sum + nums[p2];
            p2++;
        }
        avg = sum / k;
        maxAvg = Math.max(maxAvg, avg);
        while ( p2 < nums.length ){
            sum = sum - nums[p1] + nums[p2];
            p1++;
            p2++;
            avg = sum / k;
            maxAvg = Math.max(maxAvg, avg);
        }

        return maxAvg;

    }

    public static double findMaxAverageBruteForceII(int[] nums, int k) {
        int i=0;
        Double maxAvg = 0.0;
        while (i <= nums.length - k){
            Double avg = 0.0;
            Double sum = 0.0;
            for( int j=i; j<= k+i-1; j++ ){
               sum = sum + nums[j];
            }
            avg = sum/k;
            maxAvg = Math.max(avg, maxAvg);
            i++;

        }
        return maxAvg;
    }

    public static double findMaxAverageII(int[] nums, int k) {
//         Edge case : nums=[-1] , k=1
        double maxAvg = Double.NEGATIVE_INFINITY;
        double sum = 0.0;
        for(int i=0; i< k; i++){
           sum = sum+nums[i];
        }

        maxAvg = Math.max(sum / k, maxAvg);
        double avg = 0.0;
        for(int i=k; i< nums.length; i++){
            sum = sum + nums[i];
            if(i >= k){
                sum = sum - nums[i-k];
            }
            maxAvg = Math.max(sum / k, maxAvg);
        }
return maxAvg;

    }


    }
