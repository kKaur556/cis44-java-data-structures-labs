public class SyntaxChecker {

    /**
     * Uses a stack to check if a line of code has balanced symbols.
     * @param line The string of code to check.
     * @return true if symbols are balanced, false otherwise.
     */
    public static boolean isBalanced(String line) {
        // TODO: Implement this method using a Stack.
        Stack buffer = new ArrayStack<>(line.length());

        // Your implementation here...
        for(char character : line.toCharArray())
        {
            if(character == '(' || character == '{' || character == '[')
            {
                buffer.push(character);
            }else if(character == ')' || character == '}' || character == ']')
            {
                if(buffer.isEmpty()) return false;
                
                char last = (char) buffer.pop();
                
                //mismatch check
                if((character == ')' && last != '(')||
                    (character == '}' && last != '{')||
                    (character == ']' && last != '['))
                {
                    return false;
                }
            }
        }
        return buffer.isEmpty();
    }

    public static void main(String[] args) {
        String line1 = "public static void main(String[] args) { ... }"; // Should be true
        String line2 = "int x = (5 + [a * 2]);"; // Should be true
        String line3 = "System.out.println('Hello');)"; // Should be false (extra closing parenthesis)
        String line4 = "List list = new ArrayList<{String>();"; // Should be false (mismatched)
        String line5 = "if (x > 0) {"; // Should be false (unmatched opening brace)

        System.out.println("Line 1 is balanced: " + isBalanced(line1));
        System.out.println("Line 2 is balanced: " + isBalanced(line2));
        System.out.println("Line 3 is balanced: " + isBalanced(line3));
        System.out.println("Line 4 is balanced: " + isBalanced(line4));
        System.out.println("Line 5 is balanced: " + isBalanced(line5));
    }
}

