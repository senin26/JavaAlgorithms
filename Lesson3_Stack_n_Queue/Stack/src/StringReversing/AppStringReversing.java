package StringReversing;

import customStack.CustomStack;

public class AppStringReversing {

    public static void main(String[] args) {
        String string = "A Nut for a Jar of Tuna";
        StringReversor stringReversor = new StringReversor(string);
        stringReversor.printReverseString();
    }

}
