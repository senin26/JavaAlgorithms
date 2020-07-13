import customStack.CustomStack;

public class App {

    public static void main(String[] args) {
        CustomStack<Character> stack = new CustomStack<>(3, 10);
        stack.push('S');
        stack.push('e');
        stack.push('r');
        stack.push('g');
        stack.printStack();
        //System.out.println(stack.peek());
        stack.pop();
        stack.push('y');
        stack.push('S');
        stack.push('e');
        stack.push('r');
        stack.push('g');
        stack.pop();
        System.out.println("stack.size() = " + stack.size());
        stack.printStack();
        for (int i = 0; i < 7; i++) {
            stack.pop();
        }
        System.out.println("stack.size() = " + stack.size());
        stack.printStack();
        // stack.pop();
        //stack.printStack();
        System.out.println(stack.isFull());
    }

}
