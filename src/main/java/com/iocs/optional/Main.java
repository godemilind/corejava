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
    }
}
