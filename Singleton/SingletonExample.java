package LearnLLD.Singleton;

public class SingletonExample {

    public static void main(String[] args) {
        Singletone instance1 = Singletone.getInstance();
        Singletone instance2 = Singletone.getInstance();
        if (instance1 == instance2) {
            System.out.println("Both are same");
        } else {
            System.out.println("Both are different");
        }
    }
}

class Singletone {
    private static Singletone instance = null;
    private Singletone() {
        // private contructor
    }
    public static Singletone getInstance() {
        if (instance == null) {
            synchronized(Singletone.class) {
                if (instance == null) {
                    instance = new Singletone();
                }
            }
        }
        return instance;
    }
}