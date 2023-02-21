package design_pattern.strategy_design_pattern;

public class design_patterns {

    public static void main(String[] args) {
        CalculationContext context = new CalculationContext();

        context.setStrategy(new AdditionStrategy());
        int result = context.performCalculation(5, 3); // result will be 8

        context.setStrategy(new MultiplicationStrategy());
        result = context.performCalculation(5, 3); // result will be 15

    }
}

class CalculationContext {
    private CalculationStrategy strategy;

    public void setStrategy(CalculationStrategy strategy) {
        this.strategy = strategy;
    }

    public int performCalculation(int num1, int num2) {
        return strategy.calculate(num1, num2);
    }
}

class AdditionStrategy implements CalculationStrategy {
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }
}

class SubtractionStrategy implements CalculationStrategy {
    public int calculate(int num1, int num2) {
        return num1 - num2;
    }
}

class MultiplicationStrategy implements CalculationStrategy {
    public int calculate(int num1, int num2) {
        return num1 * num2;
    }
}

class DivisionStrategy implements CalculationStrategy {
    public int calculate(int num1, int num2) {
        return num1 / num2;
    }
}

interface CalculationStrategy {
    int calculate(int num1, int num2);
}

