package com.iocs.stream;

import java.io.InputStream;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        //Filter
        Person p1 = new Person("Milind",40,"Male");
        Person p2 = new Person("Vihaan",10,"Male");
        Person p3 = new Person("Shyamal",35,"Female");
        Person p4 = new Person("Subhash",69,"Male");
        Person p5 = new Person("Minal",39,"Female");
        Person p6 = new Person("Raunav",12,"Male");
        Person p7 = new Person("Lisha",12,"Female");

        Stream<String> stream = Stream.of(new String[]{"One","Two","Three","Five"});

        List<String> list2 = stream.filter(str->str.startsWith("O") || str.startsWith("F")).collect(Collectors.toList());

        stream = Stream.of(new String[]{"One","Two","Three","Five"});

        // Combine Predicates Inline
        List<String> list3 = stream.filter(((Predicate<String>)str->str.startsWith("O")).or(str->str.startsWith("F"))).collect(Collectors.toList());

        stream = Stream.of(new String[]{"One","Two","Three","Five"});

        List<String> list = stream.filter(str->str.startsWith("O")).filter(str->str.startsWith("F")).collect(Collectors.toList());
        System.out.println(list2);
        System.out.println(list);
        System.out.println(list3);

        stream = Stream.of(new String[]{"One","Two","Three","Five"});
        stream.filter(str->str.startsWith("O")).peek(System.out::println).collect(Collectors.toList());

        // intermediate operation
        //distinct
        List<String> strNumbers = Arrays.asList("One","Two","Three","Five","One","Two");
        strNumbers.stream().distinct().forEach(System.out::println);

        // intermediate operation
        //distinct
        List<Integer> numbers = Arrays.asList(1, 1, 2, 3, 3, 4, 5, 5);

        System.out.println("The distinct elements are :");

        // Displaying the distinct elements in the list
        // using Stream.distinct() method
        numbers.stream().distinct().sorted().forEach(System.out::println);

        // spliterator
        numbers = Arrays.asList(1, 2, 3, 3, 4, 5, 6);
        Spliterator spliterator1 = numbers.spliterator();
        Spliterator spliterator2 = spliterator1.trySplit();

        System.out.println("spliterator1");
        spliterator1.forEachRemaining(System.out::println);

        System.out.println("spliterator2");
        spliterator2.forEachRemaining(System.out::println);
        characteristics(spliterator2);

        // Map
        numbers = Arrays.asList(1, 2, 3, 3, 4, 5, 6);
        List<String> numstrs = numbers.stream().map(x->x.toString()).map(x->x.toUpperCase()).collect(Collectors.toList());
        System.out.println(numstrs);

        // reduce
        // to find max number second argument is accumulator
        numbers = Arrays.asList(1, 2, 3, 3, 4, 5, 6);
        Optional<Integer> p = numbers.stream().reduce((x,y)->x>y? x:y);
        System.out.println("Max: "+p);

        // reduce
        // to find min number second argument is accumulator
        numbers = Arrays.asList(1, 2, 3, 3, 4, 5, 6);
        p = numbers.stream().reduce((x,y)->x<y? x:y);
        System.out.println("Min: "+p);

        // reduce
        // to find sum number second argument is accumulator
        numbers = Arrays.asList(1, 2, 3, 3, 4, 5, 6);
        p = numbers.stream().reduce((x,y)->x+y);
        System.out.println("Sum: "+p);

        // reduce
        // to find sum number second argument is accumulator
        numbers = Arrays.asList(1, 2, 3, 3, 4, 5, 6);
        p = numbers.stream().reduce((x,y)->x*y);
        System.out.println("Product: "+p);

        // concat string
        // to concat string
        List<String> strs = Arrays.asList("God","Is","Great");
        //in below we can use Optional<String> str = strs.stream().reduce(String::concat);
        Optional<String> str = strs.stream().reduce((x,y)->x+" "+y);
        System.out.println("Concat String: "+str);

        // to calculate average age of person
        List<Person> family3 = Arrays.asList(p1,p2,p3,p4,p5,p6,p7);
        //Optional<Integer> averageAge = family3.stream().map(pp->pp.getAge()).reduce((x,y)->((x+y)/2));
        Double averageAge = family3.stream().collect(Collectors.averagingInt(pp -> pp.getAge()));
        System.out.println("Average Age: "+averageAge);

        double avg = numbers.stream().collect(Collectors.averagingInt(i->i));
        System.out.println("Average: "+avg);
        avg = numbers.stream().collect(Collectors.averagingInt(Integer::intValue));
        System.out.println("Average: "+avg);

        // sorted
        strs = Arrays.asList("Milind","Minal","Vihaan","Subhash","Shyamal","Raunav");
        List<String> names = strs.stream().sorted().collect(Collectors.toList());
        System.out.println(names);

        // sorted
        numbers = Arrays.asList(1, 7, 3, 2, 6, 4, 5);
        numbers = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println("Product: "+numbers);

        // sorted
        List<Person> family4 = Arrays.asList(p1,p2,p3,p4,p5,p6,p7);
        family4.stream().sorted((pp1,pp2)->pp1.getName().compareTo(pp2.getName())).forEach(System.out::println);

        //Filter
        List<Person> family2 = Arrays.asList(p1,p2,p3,p4,p5,p6,p7);

        Predicate<Person> pred1= pp-> pp.getAge()<15;
        Predicate<Person> pred2= pp-> pp.getSex().equals("Female");

        List<String> filteredPeoples = family2.stream().filter(pp-> pp.getAge()<15 && pp.getSex().equals("Female")).map(pp->pp.getName()).collect(Collectors.toList());
        List<String> filteredPeoples2 = family2.stream().filter(pred1.and(pred2)).map(Person::getName).collect(Collectors.toList());
        System.out.println(filteredPeoples);
        System.out.println(filteredPeoples2);

        // collect return map
        Map<String,Person> map = family2.stream().filter(pred1.and(pred2)).collect(Collectors.toMap(Person::getName, Function.identity()));

        // ********** collect groupby **********
        Map<String,List<Person>> groupBySexList = family4.stream().collect(Collectors.groupingBy(Person::getSex));
        System.out.println(groupBySexList);
        Map<String,Set<Person>> groupBySexSet = family4.stream().collect(Collectors.groupingBy(Person::getSex,Collectors.toSet()));

        //For each method
        Consumer<Person> personConsumer = (person)-> {
            System.out.println(String.format("Name: %s",person.getName()));
            System.out.println(String.format("Sex: %s",person.getSex()));
            System.out.println(String.format("Age: %s",person.getAge()));
        };

        // BiConsumer for map
        Map<String,Person> personMap = family2.stream().collect(Collectors.toMap(Person::getName, Function.identity()));
        BiConsumer<String,Person> personBiConsumer = (k,v)->{
            System.out.println(String.format("Name: %s",k));
            System.out.println(String.format("Sex: %s",v.getSex()));
            System.out.println(String.format("Age: %s",v.getAge()));
        };

        List<Person> family5 = Arrays.asList(p1,p2,p3,p4,p5,p6,p7);
        System.out.println("################# For Each List 1 using Method Reference #################");
        family5.forEach(System.out::println);
        // OR
        System.out.println("################# For Each List 2 using consumer  #################");
        family5.forEach(personConsumer);
        // OR for iterating map
        System.out.println("################# For Each Map using BiConsumer#################");
        personMap.forEach(personBiConsumer);


        // forEachRemaining

        // Any Match
        System.out.println(numbers.stream().anyMatch(x->x==2));

        // Exercise 1
        exercise1();

        // Exercise 2
        exercise2();

        // Unary and Binary operator extends Function and BiFunction respectively
        UnaryOperator<Integer> uo = i->i;
        BinaryOperator<Integer> bo = (i,j)->i+j;
    }

    public static void characteristics(Spliterator spliterator){
        if (spliterator.hasCharacteristics(Spliterator.ORDERED)) {
            System.out.println("ORDERED");
        }

        if (spliterator.hasCharacteristics(Spliterator.DISTINCT)) {
            System.out.println("DISTINCT");
        }

        if (spliterator.hasCharacteristics(Spliterator.SORTED)) {
            System.out.println("SORTED");
        }

        if (spliterator.hasCharacteristics(Spliterator.SIZED)) {
            System.out.println("SIZED");
        }

        if (spliterator.hasCharacteristics(Spliterator.CONCURRENT)) {
            System.out.println("CONCURRENT");
        }

        if (spliterator.hasCharacteristics(Spliterator.IMMUTABLE)) {
            System.out.println("IMMUTABLE");
        }

        if (spliterator.hasCharacteristics(Spliterator.NONNULL)) {
            System.out.println("NONNULL");
        }

        if (spliterator.hasCharacteristics(Spliterator.SUBSIZED)) {
            System.out.println("SUBSIZED");
        }
    }


    public static void exercise1(){
        IntStream ns = IntStream.generate(new NumberGenerator());
        ns.limit(1000).forEach(System.out::println);

    }

    public static class NumberGenerator implements IntSupplier {

        private int i=0;

        @Override
        public int getAsInt() {
            return i++;
        }
    }


    public static void exercise2(){
        IntStream s = Arrays.asList(1,2,3,4,5,6,7,8,9,10).stream().mapToInt(n->n);
        List<Integer> nums =  s.filter(n->n%2==0).limit(2).boxed().collect(Collectors.toList());
        System.out.println(nums);
    }
}
