package se.lexicon;

import se.lexicon.data.DataStorage;
import se.lexicon.model.Gender;
import se.lexicon.model.Person;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Comparator;
import java.util.List;




public class Exercises {

    private final static DataStorage storage = DataStorage.INSTANCE;



    /*
       1.	Find everyone that has firstName: “Erik” using findMany().
    */

    public static void exercise1(String message){
        System.out.println(message);
        List<Person> res = storage.findMany(p->p.getFirstName().equals("Erik"));
        res.forEach(person -> System.out.println(person));
    }

    /*
        2.	Find all females in the collection using findMany().
     */
    public static void exercise2(String message){
        System.out.println(message);
        //Write your code here
        List<Person> res = storage.findMany(p->p.getGender().equals(Gender.FEMALE));
        System.out.println(res);
    }

    /*
        3.	Find all who are born after (and including) 2000-01-01 using findMany().
     */
    public static void exercise3(String message){
        System.out.println(message);
        //Write your code here
        ChronoLocalDate localD = LocalDate.parse("1999-12-31");
        List<Person> res = storage.findMany(p->p.getBirthDate().isAfter(localD));
        System.out.println(res);
        System.out.println("----------------------");
    }

    /*
        4.	Find the Person that has an id of 123 using findOne().
     */
    public static void exercise4(String message){
        System.out.println(message);
        //Write your code here
        Person res = storage.findOne(p->p.getId()== 123);
        System.out.println(res);
        System.out.println("----------------------");
        System.out.println("----------------------");

    }

    /*
        5.	Find the Person that has an id of 456 and convert to String with following content:
            “Name: Nisse Nilsson born 1999-09-09”. Use findOneAndMapToString().
     */
    public static void exercise5(String message){
        System.out.println(message);
        //Write your code here
        String res = storage.findOneAndMapToString(p->p.getId()== 456,(person -> "Name: " + person.getFirstName() + " " +
                person.getLastName() + " born " + person.getBirthDate()));
        System.out.println(res);

        System.out.println("----------------------");
    }

    /*
        6.	Find all male people whose names start with “E” and convert each to a String using findManyAndMapEachToString().
     */
    public static void exercise6(String message){
        System.out.println(message);
        //Write your code here
        List <String> res = storage.findManyAndMapEachToString(p->p.getFirstName().startsWith("E") && p.getGender().equals(Gender.MALE)  && p.getLastName().startsWith("E"),(person -> "Name: " + person.getFirstName() + " " +
                person.getLastName() + " born " + person.getBirthDate()));
        System.out.println(res);

        System.out.println("----------------------");
    }

    /*
        7.	Find all people who are below age of 10 and convert them to a String like this:
            “Olle Svensson 9 years”. Use findManyAndMapEachToString() method.
     */
    public static void exercise7(String message){
        System.out.println(message);
        //Write your code here
        List <String> res = storage.findManyAndMapEachToString(p->p.getBirthDate().isAfter(LocalDate.now().minusYears(10)),(person -> "Name: " + person.getFirstName() + " " +
                person.getLastName() + " " + (LocalDate.now().getYear() - person.getBirthDate().getYear()) + " years"));
        res.forEach(p-> System.out.println(p));
        System.out.println("----------------------");
    }

    /*
        8.	Using findAndDo() print out all people with firstName “Ulf”.
     */
    public static void exercise8(String message){
        System.out.println(message);
        //Write your code here
        storage.findAndDo(p->p.getFirstName().equals("Ulf"),(person -> System.out.println("Name: " + person.getFirstName() + " " +
                person.getLastName() + " born " + person.getBirthDate())));
        System.out.println("----------------------");
    }

    /*
        9.	Using findAndDo() print out everyone who have their lastName contain their firstName.
     */
    public static void exercise9(String message){
        System.out.println(message);
        //Write your code here
        storage.findAndDo(p->p.getLastName().contains(p.getFirstName()),(person -> System.out.println("Name: " + person.getFirstName() + " " +
                person.getLastName() + " born " + person.getBirthDate())));
        System.out.println("----------------------");
    }

    /*
        10.	Using findAndDo() print out the firstName and lastName of everyone whose firstName is a palindrome.
     */
    public static void exercise10(String message){
        System.out.println(message);
        storage.findAndDo(p->p.getFirstName().toUpperCase().equals
                        ((new Reverse(p.getFirstName()).getStringReverse())),
                (person -> System.out.println("Name: " + person.getFirstName() + " " +
                person.getLastName())));
        System.out.println("----------------------");
    }

    /*
        11.	Using findAndSort() find everyone whose firstName starts with A sorted by birthdate.
     */
    public static void exercise11(String message){
        System.out.println(message);
        //Write your code here

        List <Person> res = storage.findAndSort(p->p.getFirstName().startsWith("A"),
                Comparator.comparing(Person::getBirthDate));
        System.out.println(res);
    }

    /*
        12.	Using findAndSort() find everyone born before 1950 sorted reversed by lastest to earliest.
     */
    public static void exercise12(String message){
        System.out.println(message);
        //Write your code here
        ChronoLocalDate localD = LocalDate.parse("1950-01-01");
        List <Person> res = storage.findAndSort(p->p.getBirthDate().isBefore(localD),
                Comparator.comparing(Person::getBirthDate).reversed());
        System.out.println(res);

        System.out.println("----------------------");
    }

    /*
        13.	Using findAndSort() find everyone sorted in following order: lastName > firstName > birthDate.
     */
    public static void exercise13(String message){
        System.out.println(message);
        //Write your code here

        List <Person> res = storage.findAndSort(
                Comparator.comparing(Person::getLastName).
                        thenComparing(Person::getFirstName).
                        thenComparing(Person::getBirthDate));

        System.out.println(res);

        System.out.println("----------------------");
    }

}




