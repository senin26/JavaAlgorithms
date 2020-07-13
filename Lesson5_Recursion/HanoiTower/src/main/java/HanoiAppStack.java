public class HanoiAppStack {

    public static void main(String[] args) {
        HanoiTowerStack hanoiTowerStack = new HanoiTowerStack(3);
        HanoiTowerStack.pinFrom.printStack();
        HanoiTowerStack.step(HanoiTowerStack.getRingsNumber(), HanoiTowerStack.pinFrom, HanoiTowerStack.pinTemp, HanoiTowerStack.pinTo);
        HanoiTowerStack.pinFrom.printStack();
        HanoiTowerStack.pinTo.printStack();
        HanoiTowerStack.pinTemp.printStack();
    }

}
