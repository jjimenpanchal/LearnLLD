package LearnLLD.Strategy;

interface sortStrategy {
    void sort(int[] arr);
}

class QuickSort implements sortStrategy {
    @Override
    public void sort(int[] arr) {
        System.out.println("Quick Sort");
    }
}

class MergeSort implements sortStrategy {
    @Override
    public void sort(int[] arr) {
        System.out.println("Merge Sort");
    }
}

class BubbleSort implements sortStrategy {
    @Override
    public void sort(int[] arr) {
        System.out.println("Bubble Sort");
    }
}

class Sorter {
    private sortStrategy strategy;

    public Sorter(sortStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(sortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(int[] arr) {
        strategy.sort(arr);
    }
}

public class Main {

    public static void main(String[] args) {

        Sorter sorter = new Sorter(new QuickSort());
        sorter.sort(new int[]{5, 4, 1, 2});

        sorter.setStrategy(new MergeSort());
        sorter.sort(new int[]{5, 4, 1, 2});

        sorter.setStrategy(new BubbleSort());
        sorter.sort(new int[]{5, 4, 1, 2});
    }
}
