package bracketsAnalyzer;

import customStack.CustomStack;

public class BracketsAnalyser {

    private CustomStack<Character> stack = new CustomStack(5, 20);

    private boolean analyzeExpression(MathExpression mathExpression) {
        String expression = mathExpression.getExpression();
        for (int i = 0; i < expression.length(); i++) {
            char chr = expression.charAt(i);
            if (chr == '(' || chr == '[' || chr == '{') {
                stack.push(chr);
                continue;
            }
            if (chr == ')' || chr == ']' || chr == '}') {
                if (stack.isEmpty()) {
                    System.out.println("Error in " + i + " position");
                    return false;
                }
                char top = stack.pop();
                if ((chr == ')' && top != '(') ||
                        (chr == ']' && top != '[') ||
                        (chr == '}' && top != '{')) {
                    System.out.println("Error in " + i + " position");
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("Expression contains extra brackets");
            return false;
        }
        return true;

    }

    public void printAnalysisResult(MathExpression mathExpression) {
        if (analyzeExpression(mathExpression)) {
            System.out.println("The expression is OK");
        } else {
            System.out.println("The expression is FAILED");
        }
    }


}
