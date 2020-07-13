public class AppCustomDequeue {
    public static void main(String[] args) {
        CustomDequeue<Character> dequeue = new CustomDequeue<>(4, 20);
        dequeue.insertLeft('S');
        dequeue.insertLeft('e');
        dequeue.insertRight('r');
        dequeue.insertRight('g');
        dequeue.printDequeue();
        System.out.println();
        System.out.println("dequeue.getLeft()" + dequeue.getLeft());
        dequeue.insertRight('y');
        dequeue.insertLeft('S');
        dequeue.insertRight('e');
        dequeue.insertLeft('r');
        System.out.println("dequeue.pullLeft()" + dequeue.pullLeft());
        System.out.println("dequeue.pullRight()" + dequeue.pullRight());
        dequeue.printDequeue();
        System.out.println();
        // dequeue.pop();
        //dequeue.printStack();
        System.out.println(dequeue.isFull());
    }

}
