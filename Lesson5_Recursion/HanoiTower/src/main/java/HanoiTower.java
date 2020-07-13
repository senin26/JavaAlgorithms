public class HanoiTower {

    static int numRings;

    public HanoiTower(int numRingsInput) {
        numRings = numRingsInput;
    }

    public static void step(int top, char from, char temp, char to) {
        if (top == 1) {
            System.out.printf("Moving Ring #1 from %c to %c \n", from, to);
        }
        else {
            step(top-1, from, to, temp);
            System.out.printf("Moving Ring #" + top + " from %c to %c \n", from, to);
            step(top-1, temp, from, to);
        }
    }
}
