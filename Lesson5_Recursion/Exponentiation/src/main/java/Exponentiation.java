public final class Exponentiation {

    private Exponentiation() {
    }

    public static Double getRecursivePower(Number number, int power) {
        if (power == 1) {
            return number.doubleValue();
        }
        return number.doubleValue()*getRecursivePower(number, power-1);
    }

    public static Double getCyclePower(Number number, int power) {
        Double res = 1.0;
        while (power > 0) {
            res*=number.doubleValue();
            power--;
        }
        return res;
    }
}
