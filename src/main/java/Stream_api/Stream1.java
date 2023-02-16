package Stream_api;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by PRAKASH RANJAN on 17-02-2023
 */
public class Stream1 {

    public static void main(String[] args) {

        List<Integer> list = List.of(1,2,3,4,56,7,9);
        // filter
        Stream<Integer> stream = list.stream();
        List<Integer> collect = stream.filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println(collect);

        // map
        // square every number
        List<Integer> collect1 = list.stream().map(i -> i * i).collect(Collectors.toList());
        System.out.println(collect1);

        // sorted stream

        list.stream().sorted().forEach(i -> {
            System.out.println(i);
        });

        // min
        Integer minInteger = list.stream().min((x, y) -> x.compareTo(y)).get();
        System.out.println("min " + minInteger);

        // maz
        Integer maxInteger = list.stream().max((x, y) -> x.compareTo(y)).get();
        System.out.println("max " + maxInteger);


    }
}
