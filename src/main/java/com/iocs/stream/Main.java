package com.iocs.stream;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
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
    }
}
