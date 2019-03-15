import org.junit.Assert;
import org.junit.Test;

public class TestExponentiation {

    @Test
    public void test0Rec() {
        Number number = 6;
        int power = 3;
        Double expected = Math.pow(number.doubleValue(), power);
        Assert.assertEquals(expected, Exponentiation.getRecursivePower(number,power));
    }

    @Test
    public void test1Rec() {
        Number number = 5.3;
        int power = 3;
        Double expected = Math.pow(number.doubleValue(), power);
        Assert.assertEquals(expected, Exponentiation.getRecursivePower(number,power));
    }

    @Test
    public void test2Rec() {
        Number number = Math.PI;
        int power = 2;
        Double expected = Math.pow(number.doubleValue(), power);
        Assert.assertEquals(expected, Exponentiation.getRecursivePower(number,power));
    }

    @Test
    public void test3Rec() {
        Number number = Math.PI;
        int power = 9;
        Double expected = Math.pow(number.doubleValue(), power);
        Assert.assertEquals(expected, Exponentiation.getRecursivePower(number,power));
    }

    @Test
    public void test4Rec() {
        Number number = Math.PI;
        int power = 4;
        Double expected = Math.pow(number.doubleValue(), power);
        Assert.assertEquals(expected, Exponentiation.getRecursivePower(number,power));
    }

    @Test
    public void test0Cycle() {
        Number number = Math.PI;
        int power = 4;
        Double expected = Math.pow(number.doubleValue(), power);
        Assert.assertEquals(expected, Exponentiation.getCyclePower(number,power));
    }

    @Test
    public void test4Cycle() {
        Number number = Math.PI;
        int power = 4;
        Double expected = Math.pow(number.doubleValue(), power);
        Assert.assertEquals(expected, Exponentiation.getCyclePower(number,power));
    }


}
