package com.revature.app.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodingChallenge {



    //idea2 - passed in array of arrays. create a map which the keys are equal to the sum of the numbers in the array...
    //and the values are strings with the numbers which make up the sum listed out with spaces in between.

    //write a function which returns a hashmap. The input will be an array of arrays of integers. Example:
    // [ [3,5] , [4,0,493,21,8] , [9] , [1,3,2,56] ]
    // The hashmap should have as many keys as there are arrays of numbers.
    // So the return for the above example input should be a hashmap with 4 key-value pairs.
    // The key should be the sum of the numbers.
    // The value should be a string with the numbers separated by spaces.
    // An example of a key-value pair of the above example would be: key: 8 | value: "3 5".
    // Assume you will not be given duplicate key sums.


    public static Map giveMapBack(Integer[][] matrix){
        HashMap<Integer,String> result = new HashMap<Integer,String>();
        for(int i = 0;i<matrix.length;i++){
            Integer[] currentArray = matrix[i];
            int key = 0;
            String value = "";
            for(int j = 0;j<currentArray.length;j++){
                key += currentArray[j];
                value = value + currentArray[j].toString() + " ";
            }
            value = value.trim();
            result.put(key,value);
        }
        return result;
    }


    //int res = countArrays();
}
