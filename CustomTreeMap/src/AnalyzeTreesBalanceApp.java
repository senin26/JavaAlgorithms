import java.util.Random;

public class AnalyzeTreesBalanceApp {
    public static void main(String[] args) {
        CustomLeveledTreeMap<Integer, Integer> tree = new CustomLeveledTreeMap<>();


        int treeMaxHeight = 6;
        int numberBalancedTrees = 0;
        Random random = new Random();

        for (int i = 0; i < 1_000000; i++) {
            while(tree.height()!=treeMaxHeight) {
                Integer element = -100 + random.nextInt(201);
                tree.put(element, 0);
            }
            if (tree.isBalanced()) {
                numberBalancedTrees++;
            }
           // System.out.println("Number of elements at "+i+"-th iteration is " + tree.size());
            tree = new CustomLeveledTreeMap<>();
        }
        System.out.println("Number of balanced trees is " + numberBalancedTrees);
    }
}
