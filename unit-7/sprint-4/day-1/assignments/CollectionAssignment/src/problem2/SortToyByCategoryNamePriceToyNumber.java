package problem2;

import java.util.Comparator;

public class SortToyByCategoryNamePriceToyNumber implements Comparator<Toy> {
    @Override
    public int compare(Toy o1, Toy o2) {
         if(o1.getCategory().compareTo(o2.getCategory())==0){
            if (o1.getToyName().compareTo(o2.getToyName())==0){
                if(o1.getPrice()- o2.getPrice()==0){
                    return o1.getToyNumber().compareTo(o2.getToyNumber());
                }else {
                    return (int) (o1.getPrice()- o2.getPrice());
                }
            }else{
                return o1.getToyName().compareTo(o2.getToyName());
            }
        }else{
             return o1.getCategory().compareTo(o2.getCategory());
         }
    }
}
