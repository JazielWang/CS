package com.ithiema_05;

import java.util.*;
import java.util.stream.Stream;

/*
    Stream流的常见生成方式
        1:Collection体系的集合可以使用默认方法stream​()生成流
            default Stream<E> stream​()
        2:Map体系的集合间接的生成流
        3:数组可以通过Stream接口的静态方法of​(T... values)生成流
 */
public class StreamDemo02 {
    public static void main(String[] args) {
        List<String> l = new ArrayList<String>();
        Stream<String> liststream = l.stream();

        Set<String> s = new HashSet<String>();
        Stream<String> setstream = s.stream();

        Map<String, String> m = new HashMap<String, String>();
        Stream<String> keystream = m.keySet().stream();
        Stream<String> valuestream = m.values().stream();
        Stream<Map.Entry<String, String>> stream = m.entrySet().stream();

        String[] srt = {"时间", "空间", "时空"};
        Stream<String> stringStream = Stream.of(srt);
        Stream<String> stringStream1 = Stream.of("时间", "空间", "时空");
        Stream<Integer> IntegerStream = Stream.of(12, 23, 56);


    }
}
