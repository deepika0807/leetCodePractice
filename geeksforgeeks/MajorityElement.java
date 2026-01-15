package geeksforgeeks;

/***
 *  Moore Voting Algorithm
 * Intuition:
 * The intuition behind the Moore's Voting Algorithm is based on the fact that if there is a majority element in an array, it will always remain in the lead, even after encountering other elements.
 *
 * Explanation:
 * Algorithm:
 *
 * Initialize two variables: count and candidate. Set count to 0 and candidate to an arbitrary value.
 * Iterate through the array nums:
 * a. If count is 0, assign the current element as the new candidate and increment count by 1.
 * b. If the current element is the same as the candidate, increment count by 1.
 * c. If the current element is different from the candidate, decrement count by 1.
 * After the iteration, the candidate variable will hold the majority element.
 */
public class MajorityElement
{
    public static void main (String args[])
    {
        int[] nums = new int[] {2,2,1,1,1,2,2};
        int result = majorityElement(nums);
        System.out.println(result);

    }

    public static int majorityElement(int[] nums)
    {
        int count = 1;
        int majorityEle = nums[0];
        int p1 = 1;
        while (p1 < nums.length)
        {
            if (count == 0)
            {
                majorityEle = nums[p1];
            }
            if (nums[p1] == majorityEle)
            {
                count++;
            }
            else
            {
                count--;
            }
            p1++;
        }
        return majorityEle;
    }

}
