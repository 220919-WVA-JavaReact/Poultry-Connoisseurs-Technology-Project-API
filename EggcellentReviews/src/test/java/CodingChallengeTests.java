import com.revature.app.util.CodingChallenge;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CodingChallengeTests {

        static CodingChallenge cc;

        @BeforeClass
        public static void setUp(){
            cc = new CodingChallenge();
        }
        @Test
        public void matrixMap(){
            Integer[] array2 = {3,7,91};
            Integer[] array3 = {-6,912,4};
            Integer[] array4 = {8,18,-65};
            Integer[][] array = {array2,array3,array4};
            Map<Integer,String> res = new HashMap<>();
            res.put(101,"3 7 91");
            res.put(910,"-6 912 4");
            res.put(-39,"8 18 -65");
            Assert.assertEquals(res,cc.giveMapBack(array));
        }

}



//        @Test
//    public void additionPositive(){
//            //method to get the amount of arrays in total from passed in object
//            //arrays inside other arrays count
//            Integer[][][] array = new Integer[1][1][1];
//            Integer[][] array2 = new Integer[1][1];
//            Integer[] array3 = new Integer[1];
//            array3[0] = 2;
//            array2[0] = array3;
//            array[0] = array2;
//
//            Assert.assertEquals(3,cc.countArrays(array));
//        }



//    public static int countArrays<T> {
//
//        //you will be passed an array with a single element in it.
//        //that element will either be an integer, or another array.
//        //the output of the method must equal the number of...
//        //arrays before encountering the number.
//
//        Class classofone = array.getClass();
//        System.out.println(classofone);
//        if(!classofone.isArray()){
//            return 0;
//        } else {
//            return 1 + countArrays((ArrayList) array.get(0));
//        }
//
//    }

