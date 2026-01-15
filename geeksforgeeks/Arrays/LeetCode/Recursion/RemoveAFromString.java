package geeksforgeeks.Arrays.LeetCode.Recursion;

public class RemoveAFromString
{
    /***
     * Let’s refine your thinking (you’re 90% there)
     * ✅ Why Solution 1 (StringBuilder) is more efficient
     *
     * You’re absolutely right:
     *
     * StringBuilder does not create a new object on every recursive call
     *
     * You reuse the same buffer → O(n) time
     *
     * Minimal garbage creation → GC stays calm 😌
     *
     * If this were production code handling large strings, this is the right call.
     *
     * 💬 Interview-ready phrasing:
     *
     * “Using StringBuilder avoids repeated string allocations and scales better for large inputs.”
     *
     * ✅ Why Solution 2 is more elegant
     *
     * Also correct:
     *
     * No index
     *
     * No mutable external object
     *
     * Pure recursive thinking
     *
     * Very readable and expressive
     *
     * But…
     *
     * ⚠️ Hidden cost:
     *
     * newString + ch → creates a new String every time
     *
     * substring(1) → creates new objects
     *
     * Overall O(n²) behavior in practice
     *
     * Elegant… but expensive.
     * @param args
     */
    public static void main(String[] args)
    {
        String str = "baccad";
//        StringBuilder res = new StringBuilder("");
//        System.out.println(removeAFromString(str, 0, res));
        skip("", str);
    }
    static String removeAFromString(String str, int start, StringBuilder res){
        if(start == str.length()){
            return res.toString();
        }
        if(str.charAt((start)) != 'a'){
            res.append(str.charAt((start)));
        }
        return removeAFromString(str, start+1, res);
    }

    static void skip(String newString, String oldString){
        if(oldString.isEmpty()){
            System.out.println(newString);
            return;
        }

        Character ch = oldString.charAt(0);
        if(ch == 'a'){
            skip(newString, oldString.substring(1));
        }else{
            skip(newString+ch, oldString.substring(1));
        }
    }


}
