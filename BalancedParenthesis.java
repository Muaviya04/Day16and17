
    import java.util.Scanner;

    //create class BalancedParenthesesExample2 for implementing Balanced Parentheses using simple for loop
    public class BalancedParenthesis {
        // main() method start
        public static void main(String[] args)
        {

            String inputStr;
            int i, length, j=0, count=0;
            char current, ch;

            // create an empty stack
            char[] stack = new char[20];

            // create an instance of Scanner class
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter an expression to check whether it is balanced or not: \n");
            inputStr = sc.nextLine();

            // close Scanner class object
            sc.close();

            // get length of inputStr
            length = inputStr.length();

            // use for loop for iterating input string
            for(i = 0; i < length; i++) {

                current = inputStr.charAt(i);

                // check whether current is '(', '{', or '['
                if(current =='(' || current =='{' || current =='[') {
                    stack[j] = current;
                    j++;    // increment counter j
                    count = 1;  // set count to 1
                } else if(current == ')') {     //if current char is ')'
                    if(count == 1) //if count is 1, decrement counter j
                        j--;
                    ch = stack[j];  //store stack[j] to ch
                    if(stack.length == 0 || ch != '(') {    //if stack is empty or ch is an opening bracket '(', parentheses is not balanced
                        System.out.println("\nUnbalanced Parentheses!");
                        return;
                    }
                } else if(current == '}') { //if current char is '}'
                    if(count == 1)  //if count is 1, decrement counter j
                        j--;
                    ch = stack[j];  //store stack[j] to ch
                    if(stack.length == 0 || ch != '{') {    //if stack is empty or ch is an opening bracket '{', parentheses is not balanced
                        System.out.println("\nUnbalanced Parentheses!");
                        return;
                    }
                } else if(current == ']') { //if current char is '}'
                    if(count == 1)  //if count is 1, decrement counter j
                        j--;
                    ch = stack[j];  //store stack[j] to ch
                    if(stack.length == 0 || ch != '[') {    //if stack is empty or ch is an opening bracket '[', parentheses is not balanced
                        System.out.println("\nUnbalanced Parentheses!");
                        return;
                    }
                }
            }

            System.out.println("\nBalanced Parenthesis.");
        }
    }

