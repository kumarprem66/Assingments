package problem2;

import java.util.Comparator;

public class SortToysByPrice implements Comparator<Toy> {


    @Override
    public int compare(Toy o1, Toy o2) {
        return (int) (o1.getPrice()- o2.getPrice());
    }
}
