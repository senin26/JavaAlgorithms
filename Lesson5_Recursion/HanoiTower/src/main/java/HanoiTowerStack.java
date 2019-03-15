public class HanoiTowerStack {

    private static int RINGS_NUMBER;
    static CustomStack<Integer> pinFrom;
    static CustomStack<Integer> pinTemp;
    static CustomStack<Integer> pinTo;

    public HanoiTowerStack(int numRingsInput) {
        RINGS_NUMBER = numRingsInput;
        pinFrom = new CustomStack<Integer>(RINGS_NUMBER, RINGS_NUMBER+1);
        for (int i = (RINGS_NUMBER - 1); i >= 0; i--) {
            pinFrom.push(i);
        }
        pinTemp = new CustomStack<Integer>(RINGS_NUMBER, RINGS_NUMBER+1);
        pinTo = new CustomStack<Integer>(RINGS_NUMBER, RINGS_NUMBER+1);
    }

    public static int getRingsNumber() {
        return RINGS_NUMBER;
    }

    public static void step(int top, CustomStack from, CustomStack temp, CustomStack to) {
        if (top == 1) {
            to.push(from.peek());
        } else {
            step(top - 1, from, to, temp);
            step(top - 1, temp, from, to);
        }
    }

}
