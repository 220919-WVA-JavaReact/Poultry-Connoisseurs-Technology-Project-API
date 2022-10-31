package com.revature.app.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Knowledge {

    public static void checkArray(Object arr){
        System.out.println(arr.getClass().isArray());
        java.util.Map<String,Integer> map = new java.util.HashMap<>();
    }


    public static void main(String[] args){
        Integer[] array3 = new Integer[1];
        array3[0] = 2;
        List<Integer> list = new ArrayList<>();
        list.stream().map(x -> x + 1).collect(Collectors.toList());
        checkArray(array3);
    }


}
