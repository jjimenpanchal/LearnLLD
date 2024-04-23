package LearnLLD.Builder;

public class Product {
    private String name;
    private double price;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void display() {
        System.out.println("Product Name is " + getName() + " and Price is " + getPrice());
    }

}
