package com.iocs.optional;

import java.util.Optional;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Optional<String> o = Optional.of("");
        Optional<String> o2 = Optional.ofNullable(null);

        System.out.println(o2.orElse("Null"));
        //System.out.println(o2.orElseThrow());

        String s = null;
        Optional<String> os = Optional.ofNullable(s);
        if(os.isPresent()){

        }else{
            System.out.println("Optional Absent");
        }

        System.out.println(os.orElse("Test"));

        // optional.empty
        Optional<String> os2 = Optional.empty();
        if(os2.isPresent()){

        }else{
            System.out.println("Optional Absent");
        }

        // Optional flatMap ---- If a value is present, it applies the provided Optional-bearing mapping function to it, returns that result, otherwise returns an empty Optional.
        Optional<String> str2 = Optional.of("Hello");
        Optional<Integer> num = str2.flatMap(str-> Optional.of(str.length()));

        // Optional flatMap
        Optional<String> strMap = Optional.of("Hello");
        Optional<Integer> numMap = str2.map(str-> str.length());

        // Optional.orElse(T other)  &  Optional.orElseGet(Supplier<? extends T> other)
        Optional<String> str3 = Optional.ofNullable(null);
        String str = str3.orElse("How are you");
        System.out.println(str);

        str = str3.orElseGet(()->"Str return by supplier");
        System.out.println(str);

        try {
            str = str3.orElseThrow(Exception::new);
        }catch(Exception e){
            System.out.println("Exception");
        }

        //

        // Optional.of with null reference throw NullPointerException but Optional.ofNullable will return empty Optional
        Optional<String> str4 = Optional.ofNullable(null);
        System.out.println(str4.isPresent());

        // will throw NullPointerException
        try {
            str4 = Optional.of(null);
        }catch(Exception e){
            System.out.println("NullPointerException");
        }
    }
}
