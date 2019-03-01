package customArrayList;

import java.util.Iterator;

public class CustomALDemo {

    public static void main(String[] args) {

        CustomArrayList<Character> list = new CustomArrayList<Character>();

        list.add('a');
        list.add('b');
        list.add('h');
        list.add('n');

        System.out.println("Initial list ");
        System.out.println(list+"\n");

        list.set(2, 'i');
        System.out.println("After set of 'i' at index 2");
        System.out.println(list+"\n");

        System.out.println("list.get(3)");
        System.out.println(list.get(3)+"\n");

        System.out.println("Using foreach");
        for (Character c:
             list) {
            System.out.println(c);
        }

        System.out.println("\n" + "Using of iterator");
        Iterator<Character> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("\n" + "list.indexOf('h')");
        System.out.println(list.indexOf('h') + "\n");

        System.out.println("list.remove('n')");
        System.out.println(list.remove('n') + "\n");

        System.out.println("list.contains('a')");
        System.out.println(list.contains('a') + "\n");

        System.out.println("list.contains('z')");
        System.out.println(list.contains('z') + "\n");

        System.out.println("list.size()");
        System.out.println(list.size());


    }

}
