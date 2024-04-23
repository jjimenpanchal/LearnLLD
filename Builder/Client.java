package LearnLLD.Builder;

public class Client {
    public static void main(String[] args) {
        ProductBuilder productBuilder = new ProductBuilder();
        Product product = productBuilder.setName("Bottle")
                            .setPrice(120).build();

        product.display();
    }
}
