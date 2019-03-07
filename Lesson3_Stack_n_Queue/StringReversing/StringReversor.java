package StringReversing;

import customStack.CustomStack;

public class StringReversor {

    CustomStack<Character> stack;
    String string;

    public StringReversor(String string) {
        this.string = string;
        stack = new CustomStack<>(15, string.length());
    }

    private String getReverseString() {
        for (int i = 0; i < string.length(); i++) {
            stack.push(string.charAt(i));
        }

        StringBuilder stringBuilder = new StringBuilder();

        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }

    public void printReverseString() {
        System.out.println(getReverseString());
    }

}
