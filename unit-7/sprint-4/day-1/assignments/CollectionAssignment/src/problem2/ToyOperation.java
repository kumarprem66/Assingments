package problem2;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToyOperation {

    private Map<String,Toy> map;

    ToyOperation(){
        map = new TreeMap<>();
    }

    private void isToyNumberValid(String toyNumber) throws InvalidToyNumberException,ToyCompanyNotFoundException{


        String comCode = toyNumber.substring(0,3);


        Pattern pattern = Pattern.compile("[A-Z]{3}[0-9]{3}");
        Matcher matcher = pattern.matcher(toyNumber);
        if (!matcher.matches()){
            throw new InvalidToyNumberException("problem2.Toy Number is not in the correct format");
        }
        if(!CompanyCodeName.companyCode.containsKey(comCode)){
            throw new ToyCompanyNotFoundException("Company with this id "+comCode+" is not available");
        }

    }

    public boolean addToy(String toyNumber,String toyName,Double price,String category) throws InvalidToyNumberException,ToyCompanyNotFoundException{

            isToyNumberValid(toyNumber);
            for (Map.Entry<String,Toy> kv : map.entrySet()){
                if(kv.getValue().getToyName().equalsIgnoreCase(toyName)){
                    return false;
                }
            }
            map.put(toyNumber,new Toy(toyNumber,toyName,price,category));
            return true;

    }

    public List<String> getToysListToDisplay() throws NoToyException{

        if (map.isEmpty()){
            throw new NoToyException("No toy is available");
        }else {
            List<String> list = new ArrayList<>();
            for (Toy t: map.values()) {
                list.add(t.toString());
            }
            return list;
        }
    }

    public Toy getToyByToyNumber(String toyNumber) throws
            InvalidToyNumberException, ToyCompanyNotFoundException,NoToyException{


        isToyNumberValid(toyNumber);
        if(map.containsKey(toyNumber)){
            return map.get(toyNumber);
        }else{
            throw  new NoToyException("no toy is found with this id");
        }

    }


    public List<String> getToyListSortedByPrice(){

        List<String> list = new ArrayList<>();
        map.values().stream().sorted(new SortToysByPrice()).forEach((t)->list.add(t.toString()));
        return list;
    }

    public List<String> getToyListForGivenPriceRange(Double start,Double end) throws NoToyException{

         List<Toy> toys = map.values().stream().toList();

        List<String> list = new ArrayList<>();
       toys.stream().filter(new Predicate<Toy>() {
             @Override
             public boolean test(Toy toy) {
                 if(toy.getPrice()>=start && toy.getPrice()<=end){
                     return true;
                 }
                 return false;
             }
         }).forEach(new Consumer<Toy>() {
             @Override
             public void accept(Toy toy) {
                 list.add(toy.toString());
             }
         });

         return list;


    }



}
