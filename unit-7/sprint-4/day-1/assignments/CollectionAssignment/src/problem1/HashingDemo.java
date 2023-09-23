package problem1;

import java.util.*;
import java.util.function.BiConsumer;

public class HashingDemo {

    public static Map<Character, List<String>> addName(String[] names){

        Map<Character,List<String>> map = new HashMap<>();

//        for (int i=0;i<names.length;i++){
//            if(map.containsKey(names[i].charAt(0))){
//                List<String> list = map.get(names[i].charAt(0));
//                list.add(names[i]);
//                map.put(names[i].charAt(0),list);
//            }else{
//                map.put(names[i].charAt(0),new ArrayList<>());
//            }
//        }

        for (String name : names){
            char firstLetter = name.charAt(0);
            List<String> nameList = map.getOrDefault(firstLetter,new ArrayList<>());
            nameList.add(name);
            map.put(firstLetter,nameList);
        }
        return map;
    }

    public static void display(Map<Character, List<String>> map){

        for (char key ='A';key <= 'Z';key++){
            List<String> names = map.getOrDefault(key,new ArrayList<>());
            if(!names.isEmpty()){
                System.out.println(key+": "+String.join(", ",names));
            }
        }

    }

    public static boolean searchName(Map<Character, List<String>> map, String name){

        char firstLetter = name.charAt(0);
        List<String> names = map.getOrDefault(Character.toUpperCase(firstLetter),new ArrayList<>());

        return names.contains(name);
    }

    public static boolean removeName(Map<Character, List<String>> map, String name){
        char firstLetter = name.charAt(0);
        List<String> names = map.getOrDefault(Character.toUpperCase(firstLetter),new ArrayList<>());

       if(names.remove(name)){
           map.put(Character.toUpperCase(firstLetter),names);
           return true;
       }
        return false;

    }

    public static void main(String[] args) {
        String[] names = {"Naya", "Ishaan", "Jai", "Inaya", "Amar", "Navi",
                "Dhruv",
                "Kanan", "Diya", "Shyla", "Agastya", "Ananya", "Nila", "Tenzin",
                "Tamia",
                "Shaan", "Ajay", "Jaya", "Anjali", "Aditi", "Reva", "Sahil",
                "Darsh", "Aja",
                "Ambar", "Deven", "Ishani", "Kavi", "Marjane", "Jasleen",
                "Ashwin", "Aadhira",
                "Candy", "Kum", "Salina", "Artha", "Raghav", "Avan", "Sitara",
                "Shylah", "Divya",
                "Varun", "Sona", "Shaila", "Kimaya", "Farid", "Kashvi", "Devi",
                "Charu", "Mihir", "Tulsi",
                "Anila", "Anala", "Vivan", "Amitabh", "Mahika", "Sudhir",
                "Lata", "Anand", "Akshay"};
        Map<Character, List<String>> map = addName(names);
        System.out.println("The original map is ");
        display(map);
        System.out.println();

        if (searchName(map, "Farid")) {
            System.out.println("Name 'Farid' found in Map");
        } else {
            System.out.println("Name 'Farid' not found in Map");
        }
        System.out.println();
        if (searchName(map, "Harish")) {
            System.out.println("Name 'Harish' found in Map");
        } else {
            System.out.println("Name 'Harish' not found in Map");
        }
        System.out.println();
        if (removeName(map, "Lata")) {
            System.out.println("Name 'lata' removed from Map");
        } else {
            System.out.println("Name 'lata' not in map hence not deleted");
        }
        System.out.println();
        if (removeName(map, "Harish")) {
            System.out.println("Name 'Harish' removed from Map");
        } else {
            System.out.println("Name 'Harish' not in map hence not deleted");
        }
        System.out.println();
        display(map);
    }

//    The original map is
//    A: Amar, Agastya, Ananya, Ajay, Anjali, Aditi, Aja, Ambar, Ashwin,
//    Aadhira, Artha, Avan, Anila, Anala, Amitabh, Anand, Akshay
//    C: Candy, Charu
//    D: Dhruv, Diya, Darsh, Deven, Divya, Devi
//    F: Farid
//    I: Ishaan, Inaya, Ishani
//    J: Jai, Jaya, Jasleen
//    K: Kanan, Kavi, Kum, Kimaya, Kashvi
//    L: Lata
//    M: Marjane, Mihir, Mahika
//    N: Naya, Navi, Nila
//    R: Reva, Raghav
//    S: Shyla, Shaan, Sahil, Salina, Sitara, Shylah, Sona, Shaila, Sudhir
//    T: Tenzin, Tamia, Tulsi
//    V: Varun, Vivan
//
//    Name 'Farid' found in Map
//    Name 'Harish' not found in Map
//    Name 'lata' removed from Map
//    Name 'Harish' not in map hence not deleted
//    A: Amar, Agastya, Ananya, Ajay, Anjali, Aditi, Aja, Ambar, Ashwin,
//    Aadhira, Artha, Avan, Anila, Anala, Amitabh, Anand, Akshay
//    C: Candy, Charu
//    D: Dhruv, Diya, Darsh, Deven, Divya, Devi
//    F: Farid
//    I: Ishaan, Inaya, Ishani
//    J: Jai, Jaya, Jasleen
//    K: Kanan, Kavi, Kum, Kimaya, Kashvi
//    M: Marjane, Mihir, Mahika
//    N: Naya, Navi, Nila
//    R: Reva, Raghav
//    S: Shyla, Shaan, Sahil, Salina, Sitara, Shylah, Sona, Shaila, Sudhir
//    T: Tenzin, Tamia, Tulsi
//    V: Varun, Vivan

}
