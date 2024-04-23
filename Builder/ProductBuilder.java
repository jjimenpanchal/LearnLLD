package LearnLLD.Builder;

public class ProductBuilder implements ProductBuilderInterface{
    String name;
    double price;
    @Override
    public ProductBuilder setName(String name) {
        this.name = name;
        return this;
    }
    @Override
    public ProductBuilder setPrice(double price) {
        this.price = price;
        return this;
    }
    @Override
    public Product build() {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        return product;
    }

}
