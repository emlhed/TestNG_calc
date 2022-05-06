import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalcClassTest {
    CalcClass calc = new CalcClass();

    @BeforeMethod
    public void writeBeforeEachTest(){
        System.out.println("Print this before each test");
    }

    @AfterMethod
    public void writeAfterEachTest(){
        System.out.println("Print this after each test");
    }

    @Test (priority = 3)
    public void testAdditionTestEquals() {
        Assert.assertEquals(3, calc.additionTest(-2,5));
        Assert.assertEquals(5, calc.additionTest(2,3));
        Assert.assertEquals(0, calc.additionTest(0,0));
        Assert.assertEquals(-5, calc.additionTest(-2,-3));
    }

    @Test  (priority = 3, dependsOnMethods = {"testAdditionTestEquals"})
    public void testAdditionTestNotEquals() {
        Assert.assertNotEquals(5, calc.additionTest(-2,-3));
        Assert.assertNotEquals(6, calc.additionTest(2,3));
    }

    @Test
    public void testSubtractionTestEquals() {
        Assert.assertEquals(1, calc.subtractionTest(3,2));
        Assert.assertEquals(-1, calc.subtractionTest(2,3));
        Assert.assertEquals(-5, calc.subtractionTest(0,5));
        Assert.assertEquals(-4, calc.subtractionTest(-6,-2));
    }

    @Test (dependsOnMethods = {"testSubtractionTestEquals"})
    public void testSubtractionTestNotEquals() {
        Assert.assertNotEquals(1, calc.subtractionTest(2,3));
        Assert.assertNotEquals(-4, calc.subtractionTest(-2,2));
    }

    @Test
    public void testMultiplyTestEquals() {
        Assert.assertEquals(4, calc.multiplyTest(2,2));
        Assert.assertEquals(6, calc.multiplyTest(3,2));
        Assert.assertEquals(25, calc.multiplyTest(5,5));
        Assert.assertEquals(6, calc.multiplyTest(-2,-3));
        Assert.assertEquals(-12, calc.multiplyTest(-4,3));
        Assert.assertEquals(0.25, calc.multiplyTest(0.5,0.5));
    }


    @Test (dependsOnMethods = {"testMultiplyTestEquals"})
    public void testMultiplyTestNotEquals() {
        Assert.assertNotEquals(12, calc.multiplyTest(-4,3));
        Assert.assertNotEquals(-12, calc.multiplyTest(-4,-3));
    }

    @Test (priority = 2)
    public void testDivisionTestEquals() {
        Assert.assertEquals(1, calc.divisionTest(0.5,0.5));
        Assert.assertEquals(2, calc.divisionTest(4,2));
        Assert.assertEquals(5, calc.divisionTest(10,2));
        Assert.assertEquals(9, calc.divisionTest(81,9));
        Assert.assertEquals(-2, calc.divisionTest(-10,5));
        // remove comment To try fail and run dependsOnMode on method testDivisionTestNotEquals
        //  Assert.assertEquals(-2, calc.divisionTest(30,5));

    }

    @Test (priority = 2, dependsOnMethods = {"testDivisionTestEquals"})
    public void testDivisionTestNotEquals() {
        Assert.assertNotEquals(1, calc.divisionTest(1,0));
        Assert.assertNotEquals(3, calc.divisionTest(4,2));
        Assert.assertNotEquals(0.25, calc.divisionTest(0.5,0.5));
        Assert.assertNotEquals(2, calc.divisionTest(-10,5));
    }
}