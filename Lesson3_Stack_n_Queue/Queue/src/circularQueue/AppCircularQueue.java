package circularQueue;

public class AppCircularQueue {
    public static void main(String[] args) {
        /*System.out.println(4%5);
        System.exit(0);*/
        CustomCircularQueue<Character> queue = new CustomCircularQueue<>(2, 10);
        queue.enqueue('S');
        queue.enqueue('e');
        queue.enqueue('r');
        queue.enqueue('g');
        queue.enqueue('e');
        queue.enqueue('y');
        queue.enqueue('I');
        queue.enqueue('o');
        queue.printQueue();
        System.out.println();
        for (int i = 0; i < 3; i++) {
            queue.dequeue();
        }
        queue.enqueue('n');
        queue.enqueue('i');
        queue.enqueue('n');
        queue.printQueue();

        System.out.println(queue.size() + "\n");
        //System.out.println(queue.peek());

        queue.enqueue('y');
        queue.enqueue('S');
       /* queue.enqueue('e');
        queue.enqueue('r');
        queue.enqueue('g');*/
        queue.printQueue();
        System.out.println(queue.size() + "\n");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue() + "\n");
        queue.printQueue();
/*        queue.dequeue();
        System.out.println("queue.size() = " + queue.size());
        queue.printQueue();
        for (int i = 0; i < 7; i++) {
            queue.dequeue();
        }
        System.out.println("queue.size() = " + queue.size());
        queue.printQueue();
        // queue.dequeue();
        //queue.printQueue();*/
        System.out.println(queue.isFull());    
    }
    
}
