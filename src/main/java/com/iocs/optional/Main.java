package com.iocs.optional;

import java.util.Optional;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Optional<String> o = Optional.of("");
        Optional<String> o2 = Optional.ofNullable(null);

        System.out.println(o2.orElse("Null"));
        System.out.println(o2.orElseThrow());



    }
}
