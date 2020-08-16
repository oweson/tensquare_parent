package com.tensquare.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        String[] arr={"a","b"};
        List<String> list = Arrays.asList(arr);
        ArrayList<String> strings = new ArrayList<>(Arrays.asList(arr));
        System.out.println(list);
        arr[0]="df-21";
        System.out.println(list);
        System.out.println(strings);
    }
}
