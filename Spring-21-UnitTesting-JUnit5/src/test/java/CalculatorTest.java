import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeAll
    static void setupBeforeAll() {
        System.out.println("BeforeAll is executed");
    }

    @AfterAll
    static void setupAfterAll() {
        System.out.println("AfterAll is executed");
    }

    @BeforeEach
    void setUpEach() {
        System.out.println("BeforeEach is executed");
    }

    @AfterEach
    void tearDownEach() {
        System.out.println("AfterEach is executed");
    }

    @Test
    void test_case1() {
        fail("Not Implemented yet");
    }

    @Test
    void test_case2() {
        fail("Not Implemented yet");
    }

    @Test
    void test_case3() {
        assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3});
    }

    @Test
    void test_case4() {
        String nullString = null;
        String notNullString = "Example";
        assertNull(nullString);
        assertNotNull(notNullString);
    }

    @Test
    void test_case5() {
        Calculator c1 = new Calculator();
        Calculator c2 = c1;
        Calculator c3 = new Calculator();
        assertSame(c1, c2);
        assertNotSame(c1, c3);
    }

    @Test
    void add() {
        int actual = Calculator.add(2, 3);
        assertEquals(5, actual, "It is not matching with expected value.");
    }

    @Test
    void add2() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.add2(5, 2));
    }
}