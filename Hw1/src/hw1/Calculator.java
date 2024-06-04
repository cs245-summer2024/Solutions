package hw1;
import java.util.*;
public class Calculator {

    /* 1. Evaluate a mathematical string that consists of addition and subtraction operators.
          Example: "12+5-3" ----> 14

       Extra Credit: Have your function also handle multiplication and division. Remember the
       order of operations matters!
     */

    public int evaluateString(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        ArrayList<String> tokens = tokenizeString(s);
        ArrayList<String> evaluatedMultDiv = handleMultDiv(tokens);
        ArrayList<String> evaluateAddSub = handleAddSub(evaluatedMultDiv);
        return Integer.parseInt(evaluateAddSub.get(0));
    }

    public ArrayList<String> tokenizeString(String s){
        int stringLength = s.length();
        ArrayList<String> tokens = new ArrayList<>();
        StringBuilder currentNumber = new StringBuilder();

        for(int idx = 0; idx < stringLength; idx ++){
            if(Character.isDigit(s.charAt(idx))){
                currentNumber.append(s.charAt(idx));
            } else {
                tokens.add(currentNumber.toString());
                tokens.add("" + s.charAt(idx));
                currentNumber = new StringBuilder();
            }
        }
        tokens.add(currentNumber.toString());
        return tokens;
    }

    public ArrayList<String> handleMultDiv(ArrayList<String> tokens){
        ArrayList<String> newTokens = new ArrayList<>();
        int tailPtr = -1;
        int numTokens = tokens.size();
        int tokenIdx = 0;
        while (tokenIdx < numTokens){
            if(tokens.get(tokenIdx).equals("*") || tokens.get(tokenIdx).equals("/")){
                String operator = tokens.get(tokenIdx);
                int prevOperand = Integer.parseInt(newTokens.get(tailPtr));
                int nextOperand = Integer.parseInt(tokens.get(tokenIdx + 1));
                if(operator.equals("*")){
                    int result = prevOperand * nextOperand;
                    newTokens.set(tailPtr, "" + result);
                } else if(operator.equals("/")){
                    int result = prevOperand / nextOperand;
                    newTokens.set(tailPtr, "" + result);
                }
                tokenIdx += 2;
            } else {
                newTokens.add(tokens.get(tokenIdx));
                tailPtr += 1;
                tokenIdx += 1;
            }
        }
        return newTokens;
    }

    public ArrayList<String> handleAddSub(ArrayList<String> tokens){
        ArrayList<String> newTokens = new ArrayList<>();
        int tailPtr = -1;
        int numTokens = tokens.size();
        int tokenIdx = 0;
        while (tokenIdx < numTokens){
            if(tokens.get(tokenIdx).equals("+") || tokens.get(tokenIdx).equals("-")){
                String operator = tokens.get(tokenIdx);
                int prevOperand = Integer.parseInt(newTokens.get(tailPtr));
                int nextOperand = Integer.parseInt(tokens.get(tokenIdx + 1));
                if(operator.equals("+")){
                    int result = prevOperand + nextOperand;
                    newTokens.set(tailPtr, "" + result);
                } else if(operator.equals("-")){
                    int result = prevOperand - nextOperand;
                    newTokens.set(tailPtr, "" + result);
                }
                tokenIdx += 2;
            } else {
                newTokens.add(tokens.get(tokenIdx));
                tailPtr += 1;
                tokenIdx += 1;
            }
        }
        return newTokens;
    }

    // 2. Return a polynomial that represents the derivative of the Polynomial
    public Polynomial getDerivative(Polynomial p){
        // Do not remove this condition
        if(p.getPolynomialDegree() == 0){
            return new Polynomial(0, new double[0]);
        }
        // 5 + 4x + 0x^2 + 2x^3 ---> [5, 4, 0, 2]
        // 4 + 0x + 6x^2 ---> deg 2 [4, 0, 6]
        int polyDegree = p.getPolynomialDegree();
        double[] derivativeCoefficients = new double[polyDegree]; // [4, 0, 0]
        for(int polyIdx = 0; polyIdx < polyDegree; polyIdx ++){
            derivativeCoefficients[polyIdx] = (polyIdx + 1) * p.getKthCoefficient(polyIdx + 1);
        }
        return new Polynomial(polyDegree - 1, derivativeCoefficients);
    }

    // 3. Evaluate the polynomial at the given point x
    public double evaluatePolynomial(Polynomial p, double x){
        double result = 0;
        int polyDegree = p.getPolynomialDegree();
        for(int polyIdx = 0; polyIdx <= polyDegree; polyIdx ++){
            result += p.getKthCoefficient(polyIdx) * power(x, polyIdx);
        }
        return result;
    }

    public double power(double x, int exponent){
        if(exponent == 0){
            return 1;
        }
        double result = power(x, exponent / 2);
        if(exponent % 2 == 0){
            return result * result;
        }
        return x * result * result;
    }

    /*
        4. Find the root of the Polynomial using the Newton-Raphson method starting at the point x.
        Note that we defined a variable called tolerance. Use this threshold when determining whether
        your algorithm has converged or not.
     */
    public double newtonRaphson(Polynomial p, double initialGuess){
        double tolerance = .001;
        Polynomial derivative = getDerivative(p);
        boolean hasConverged = false;

        while(!hasConverged){
            double fx = evaluatePolynomial(p, initialGuess);
            double fprime_x = evaluatePolynomial(derivative, initialGuess);
            double nextGuess = initialGuess - fx/fprime_x;
            hasConverged = Math.abs(initialGuess - nextGuess) <= tolerance;
            initialGuess = nextGuess;
        }
        return initialGuess;
    }
}
