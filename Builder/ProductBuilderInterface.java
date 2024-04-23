package LearnLLD.Builder;

public interface ProductBuilderInterface {
    Product build();
    ProductBuilder setName(String name);
    ProductBuilder setPrice(double price);

}
