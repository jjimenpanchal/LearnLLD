package LearnLLD.Factory;

public class PizzaFactory {
    public Pizza createPizza(String type) {
        switch (type) {
            case "cheese":
                return new CheesePizza();
            case "pepperoni":
                return new PepperoniPizza();
            case "margherita":
                return new MargheritaPizza();
        }
        return null;
    }
}
