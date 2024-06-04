package hw1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void singleTerm() {
        Calculator c = new Calculator();
        String s = "123";
        assertTrue(c.evaluateString(s) == 123);
    }

    @Test
    void testAddition() {
        Calculator c = new Calculator();
        String s = "1110+5";
        assertTrue(c.evaluateString(s) == 1115);
    }

    @Test
    void testSubtraction() {
        Calculator c = new Calculator();
        String s = "10-5";
        assertTrue(c.evaluateString(s) == 5);
    }

    @Test
    void testAddSubtract() {
        Calculator c = new Calculator();
        String s = "15+8-3+4-2";
        assertTrue(c.evaluateString(s) == 22);
    }

    @Test// Extra credit
    void testChained() {
        Calculator c = new Calculator();
        String s = "15/5*3*0-5+2";
        int x = c.evaluateString(s);
        assertTrue(c.evaluateString(s) == -3);
    }

    @Test// Extra credit
    void testAll() {
        Calculator c = new Calculator();
        String s = "15+5/2*3-5+2";
        assertTrue(c.evaluateString(s) == 18);
    }

    @Test
    void testZeroEvaluation() {
        // 5 + 2x + 3x^2 + 2x^3
        double[] coefficients = {5, 2, 3, 2};
        Polynomial p = new Polynomial(3, coefficients);

        Calculator c = new Calculator();
        double result = c.evaluatePolynomial(p, 0);
        assertTrue(c.evaluatePolynomial(p, 0) == 5);
    }

    @Test
    void testPositiveEvaluation() {
        // 5 + 2x + 3x^2 + 2x^3
        double[] coefficients = {5, 2, 3, 2};
        Polynomial p = new Polynomial(3, coefficients);
        Calculator c = new Calculator();
        assertTrue(c.evaluatePolynomial(p, 3) == 92);
    }

    @Test
    void testNegativeEvaluation(){
        // 5 + 2x + 3x^2 + 2x^3
        double[] coefficients = {5, 2, 3, 2};
        Polynomial p = new Polynomial(3, coefficients);
        Calculator c = new Calculator();
        c.evaluatePolynomial(p, -4);
        assertTrue(c.evaluatePolynomial(p, -4) == -83);
    }

    @Test
    void testSparseEvaluation() {
        // 5 + 0x + 0x^2 + 2x^3
        double[] coefficients = {5, 0, 0, 2};
        Polynomial p = new Polynomial(3, coefficients);

        Calculator c = new Calculator();
        assertTrue(c.evaluatePolynomial(p, 3) == 59);
    }

    @Test
    void testDerivativeSparse() {
        // 10 + 0x + x^2 + 2x^3 + 0x^4 + 0x^5 + 3x^6
        double[] coefficients = {10, 0, 1, 2, 0, 0, 3};
        Polynomial p = new Polynomial(6, coefficients);
        Calculator c = new Calculator();

        double[] derivs = {0, 2, 6, 0, 0, 18};
        Polynomial expectedDerivative = new Polynomial(5, derivs);
        Polynomial calcDerivative = c.getDerivative(p);
        assertTrue(calcDerivative.equals(expectedDerivative));
    }

    @Test
    void testDerivativeGeneral() {
        // 5 + 2x + 2x^2 + 2x^3
        double[] coefficients = {5, 2, 2, 2};
        Polynomial p = new Polynomial(3, coefficients);
        Calculator c = new Calculator();

        double[] derivs = {2, 4, 6};
        Polynomial expectedDerivative = new Polynomial(2, derivs);
        Polynomial calcDerivative = c.getDerivative(p);
        assertTrue(expectedDerivative.equals(calcDerivative));
    }

    @Test
    void testNewtonRaphson () {
        // -4 + 0x + x^2
        double[] coefficients = {-4, 0, 1};
        Polynomial p = new Polynomial(2, coefficients);
        Calculator c = new Calculator();
        double root = c.newtonRaphson(p, 4);
        assertTrue(Math.abs(root - 2) < .00001);
    }
}