public class App {
    public static void main(String[] args) {
        CustomTrimmableQueue<Character> queue = new CustomTrimmableQueue<>(2, 10);
        queue.enqueue('S');
        queue.enqueue('e');
        queue.enqueue('r');
        queue.enqueue('g');
        queue.enqueue('e');
        queue.enqueue('y');
        queue.enqueue('I');
        queue.enqueue('o');
        for (int i = 0; i < 5; i++) {
            queue.dequeue();
        }
        queue.printQueue();
        System.exit(0);

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
