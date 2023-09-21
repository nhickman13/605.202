package StackStuff;

public class Conversions {
    private static Boolean isOperator(char c) {
        return (c=='+' || c=='-' || c=='*' || c=='/' || c =='^');
    }

    private static Boolean isOperand(char c) {
        return (Character.isLetter(c) || Character.isDigit(c));
    }
    private static Integer getPriority(char c)
    {
        if (c == '-' || c == '+')
            return 1;
        else if (c == '*' || c == '/')
            return 2;
        else if (c == '^')
            return 3;
        return 0;
    }

    public static String postfixToInfix(String s) {
        Stack mainStack = new Stack();
        String inputString = s;
        String operand1 = "";
        String operand2 = "";
        String operator = "";
        String infix = "";

        for (int i=0; i < inputString.length(); i++) {
            if (isOperand(inputString.charAt(i))) {
                mainStack.push(String.valueOf(inputString.charAt(i)));
            }
            else if (isOperator(inputString.charAt(i))) {
                operand2 = mainStack.pop();
                operand1 = mainStack.pop();
                operator = inputString.substring(i,i+1);
                infix = "(" + operand1 + operator + operand2 + ")";
                mainStack.push(infix);
            }
        }
        infix = mainStack.pop();
        return infix;
    }

    public static String infixToPrefix(String s) {
        Stack operandStack = new Stack();
        Stack operatorStack = new Stack();
        String inputString = s;
        char[] inputChars = inputString.toCharArray();
        String operand1 = "";
        String operand2 = "";
        String operator = "";
        String prefix = "";
        String temp = "";

        for (int i=0; i < inputString.length(); i++) {
            if (inputChars[i] == '(') {
                operatorStack.push(String.valueOf(inputChars[i]));

            }else if (inputChars[i] == ')') {
                while (!operatorStack.isEmpty() &&
                        (operatorStack.peek().charAt(0) != '(')) {
                    operand1 = operandStack.pop();
                    operand2 = operandStack.pop();
                    operator = operatorStack.pop();
                    prefix = operator + operand2 + operand1;
                    operandStack.push(prefix);
                }
                operatorStack.pop();

            }else if (isOperand(inputString.charAt(i))) {
                operandStack.push(inputString.substring(i, i+1));

            } else{
                while (!operatorStack.isEmpty() &&
                       getPriority(inputString.charAt(i) ) <=
                       getPriority(operatorStack.peek().charAt(0))) {
                    operand1 = operandStack.pop();
                    operand2 = operandStack.pop();
                    operator = operatorStack.pop();
                    prefix = operator + operand2 + operand1;
                    operandStack.push(prefix);
                }
                operatorStack.push(inputString.substring(i, i+1));
            }
        }

        while (!operatorStack.isEmpty()) {
            operand1 = operandStack.pop();
            operand2 = operandStack.pop();
            operator = operatorStack.pop();
            prefix = operator + operand2 + operand1;
            operandStack.push(prefix);
        }
        return operandStack.peek();
    }
    public static String postfixToPrefix(String s) {
        return infixToPrefix(postfixToInfix(s));
    }
}
