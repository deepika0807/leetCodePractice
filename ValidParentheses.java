import java.util.Stack;

public class ValidParentheses
{
    public static void main ( String args[] ){
        String s = "([}}])";
        Boolean result = isValid(s);
        System.out.println(result? "Valid": "Invalid");
    }

    static boolean isValid(String s){
//        if(s.length()%2 != 0) return false;
//
//        Stack<Character> stack = new Stack();
//        for( char c: s.toCharArray()){
//            if( c == '(' || c== '{' || c=='[' ){
//                stack.push(c);
//            } else if( c == ')' && ! stack.isEmpty() && stack.peek() == '(' ){
//                stack.pop();
//            } else if( c== '}' && ! stack.isEmpty() && stack.peek() == '{' ){
//                stack.pop();
//            } else if( c== ']' && ! stack.isEmpty() && stack.peek() == '[' ){
//                stack.pop();
//            }
//        }
//
//        return stack.isEmpty();
        if (s.length() % 2 != 0) return false; // Length must be even

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                default:
                    // Invalid character
                    return false;
            }
        }

        return stack.isEmpty(); // If stack is empty, all parentheses were matched
    }

}
