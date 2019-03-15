public final class Exponentiation {

    private Exponentiation() {
    }

    public static Double getRecursivePower(Number number, int power) {
        Double res;
        int factor = 1;
        while (power%2 == 0 && power>2) {
            power/=2;
            factor++;
        }
        if (power == 1) {
            return number.doubleValue();
        }
        res = number.doubleValue()*getRecursivePower(number, power-1);

        while (factor!=1) {
            res*=res;
            factor--;
        }
        return res;
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
