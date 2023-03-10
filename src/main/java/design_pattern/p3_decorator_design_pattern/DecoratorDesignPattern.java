package design_pattern.p3_decorator_design_pattern;

interface Pizza{
    int cost();
}

class PlainPizza implements Pizza {

    @Override
    public int cost() {
        return 5;
    }
}

class FarmHousePizza implements Pizza{

    @Override
    public int cost() {
        return 10;
    }
}

abstract class PizzaDecorator implements Pizza {
    Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    PizzaDecorator() {
    }

    @Override
    public int cost() {
        return pizza.cost();
    }
}

class ExtraCheese extends PizzaDecorator {
    Pizza pizza;

    public ExtraCheese(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int cost() {
        return pizza.cost() + 10;
    }
}

class ExtraJalepeno extends PizzaDecorator {
    private Pizza pizza;

    public ExtraJalepeno(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int cost() {
        return pizza.cost() + 20;
    }
}

public class DecoratorDesignPattern {
    public static void main(String[] args) {
        Pizza plainPizza = new PlainPizza();
        Pizza pizza1 = new ExtraCheese(plainPizza);

        System.out.println(pizza1.cost());

        Pizza farmHouse = new FarmHousePizza();
        Pizza pizza2 =new ExtraJalepeno(farmHouse);
        Pizza pizza3 = new ExtraCheese(pizza2);

        System.out.println(pizza3.cost());


    }
}
