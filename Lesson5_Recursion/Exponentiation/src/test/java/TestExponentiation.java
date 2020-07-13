import org.junit.Assert;
import org.junit.Test;

public class TestExponentiation {

    @Test
    public void test0Rec() {
        Number number = 6;
        int power = 3;
        Double expected = Math.pow(number.doubleValue(), power);
        Assert.assertTrue(Math.abs(expected-Exponentiation.getRecursivePower(number,power))<0.0001);
    }

    @Test
    public void test1Rec() {
        Number number = 5.3;
        int power = 3;
        Double expected = Math.pow(number.doubleValue(), power);
        Assert.assertTrue(Math.abs(expected-Exponentiation.getRecursivePower(number,power))<0.0001);
    }

    @Test
    public void test2Rec() {
        Number number = Math.PI;
        int power = 2;
        Double expected = Math.pow(number.doubleValue(), power);
        Assert.assertTrue(Math.abs(expected-Exponentiation.getRecursivePower(number,power))<0.0001);
    }

    @Test
    public void test3Rec() {
        Number number = Math.PI;
        int power = 8;
        Double expected = Math.pow(number.doubleValue(), power);
        Assert.assertTrue(Math.abs(expected-Exponentiation.getRecursivePower(number,power))<0.0001);
    }

    @Test
    public void test4Rec() {
        Number number = Math.PI;
        int power = 4;
        Double expected = Math.pow(number.doubleValue(), power);
        Assert.assertTrue(Math.abs(expected-Exponentiation.getRecursivePower(number,power))<0.0001);
    }

    @Test
    public void test0Cycle() {
        Number number = Math.PI;
        int power = 4;
        Double expected = Math.pow(number.doubleValue(), power);
        Assert.assertTrue(Math.abs(expected-Exponentiation.getRecursivePower(number,power))<0.0001);
    }

    @Test
    public void test4Cycle() {
        Number number = Math.PI;
        int power = 4;
        Double expected = Math.pow(number.doubleValue(), power);
        Assert.assertTrue(Math.abs(expected-Exponentiation.getRecursivePower(number,power))<0.0001);
    }


}
