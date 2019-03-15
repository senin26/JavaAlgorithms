public class HanoiTowerOld {

    private static final int RINGS_NUMBER = 8;
    static CustomStack<Integer> pin0 = new CustomStack<Integer>(RINGS_NUMBER, RINGS_NUMBER);
    static CustomStack<Integer> pin1 = new CustomStack<Integer>(RINGS_NUMBER, RINGS_NUMBER);
    static CustomStack<Integer> pin2 = new CustomStack<Integer>(RINGS_NUMBER, RINGS_NUMBER);
    static CustomStack<Integer> pinFrom;
    static CustomStack<Integer> pinTo;
    static {
        for (int i = (RINGS_NUMBER-1); i >= 0; i--) {
            pin0.push(i);
        }
    }

    public static void step() {
        if (!pin0.isEmpty()) {
            setPinFrom();
            if (pin1.isEmpty() || pin1.peek()>pin0.peek()) {

            }
        }
    }

    public static CustomStack<Integer> setPinFrom() {
        if (!pin0.isEmpty()) {

            CustomStack<Integer> pinTemp;

            if (pin1.isEmpty() && pin2.isEmpty()) {
                return pinFrom = pin0;
            }

            if (!pin1.isEmpty() && !pin2.isEmpty()) {
                if (pin0.peek() < pin1.peek() && pin0.peek() < pin2.peek()) {
                    return pinFrom = pin0;
                }
                else if (pin1.peek() < pin0.peek() && pin1.peek() < pin2.peek()) {
                    return pinFrom = pin1;
                }
                else return pinFrom = pin2;
            }

            if (pin1.isEmpty() || pin2.isEmpty()) {
                if (pin1.isEmpty()) pinTemp = pin2;
                else pinTemp = pin1;
                if (pin0.peek() < pinTemp.peek()) {
                    return pinFrom = pin0;
                }
                else return pinFrom = pinTemp;
            }
        }
        return null;
    }

    public static CustomStack<Integer> setPinTo() {
        if (!pin0.isEmpty()) {
            if (pin1.isEmpty()) {
               return pinTo = pin1;
            }
            else if (pin2.isEmpty()) {
               return pinTo = pin2;
            }
            if (pin1.peek() < pin2.peek()){
                return pinTo = pin2;
            }
            else return pinTo = pin1;
        }
        return null;
    }


}
