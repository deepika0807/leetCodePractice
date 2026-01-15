package Interview;

import java.util.Stack;

public class Test9
{
    public static void main(String[] args)
    {
        String str = "[()]";
        System.out.println(validParanthesis(str));
    }

    static boolean validParanthesis(String str){
        Stack<Character> stackString = new Stack<>();
        for(int i=0; i< str.length(); i++){
            if(str.charAt(i) == '[' || str.charAt(i)=='('){
                stackString.push(str.charAt(i));
            }else if(str.charAt(i)==']' || str.charAt(i)==')'){
                stackString.pop();
            }
        }
        if(stackString.empty()){
            return true;
        }else{
            return false;
        }
    }
}
