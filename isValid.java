import java.util.Stack;

public class isValid {
    public boolean isStackValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
        if (c == '(' || c == '{' || c == '[') {
            stack.push(c);
        } else {
            if (stack.isEmpty()) return false;
            char top = stack.pop();
            if ((c == ')' && top != '(') || 
                (c == '}' && top != '{') || 
                (c == ']' && top != '[')) {
                return false;
            }
        }
    }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        isValid obj = new isValid();
        System.out.println(obj.isStackValid("()"));
    }
}
