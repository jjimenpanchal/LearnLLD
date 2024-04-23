package LearnLLD.Factory;

public class Main {


    public static void main(String[] args) {
        PizzaStore pizzaStore = new PizzaStore(new PizzaFactory());
        System.out.println("Ordering Margherita Pizza");
        pizzaStore.orderPizza("margherita");

        System.out.println("Ordering Cheese Pizza");
        pizzaStore.orderPizza("cheese");

        System.out.println("Ordering Pepperoni Pizza");
        pizzaStore.orderPizza("pepperoni");
    }
}
