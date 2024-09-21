package org.example.Tasks.Task3;

public class Calculator {
    private Double a;
    private Double b;

    public Calculator() {
    }

    public Double getA() {
        return a;
    }

    public Double getB() {
        return b;
    }

    public void setA(Double a) {
        this.a = a;
    }

    public void setB(Double b) {
        this.b = b;
    }

    public Double add(Double a, Double b) {
        return a + b;
    }

    public Double subtract(Double a, Double b) {
        return a - b;
    }

    public Double multiply(Double a, Double b) {
        return a * b;
    }


    public Double divide(Double a, Double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль запрещено!");
        }
        return a / b;
    }

}
