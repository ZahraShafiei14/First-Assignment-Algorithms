import java.util.ArrayList;
import java.util.List;

public class Exercises2 {

    /*
    Given an array of integers nums and an integer target, return indices of the two numbers
    such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
    */

    public int[] twoSum(int[] nums, int target) {
        int[] indices = new int [2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    indices[0] = i;
                    indices[1] = j;
                }
            }
        }
        return indices;
    }

    /*
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

    For example, 2 is written as II in Roman numeral, just two ones added together.
    12 is written as XII, which is simply X + II.
    The number 27 is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right.
    However, the numeral for four is not IIII.
    Instead, the number four is written as IV.
    Because the one is before the five we subtract it making four.
    The same principle applies to the number nine, which is written as IX.
    There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

    Given a roman numeral, convert it to an integer.
    */

    public int romanToInt(String s) {
        int romanNums = 0, integer = 0;
        if (s.isEmpty()) {
            return 0;
        } else {
            for (int i = s.length() - 1; i >= 0; i--) {
                switch (s.charAt(i)) {
                    case 'I' -> romanNums = 1;
                    case 'V' -> romanNums = 5;
                    case 'X' -> romanNums = 10;
                    case 'L' -> romanNums = 50;
                    case 'C' -> romanNums = 100;
                    case 'D' -> romanNums = 500;
                    case 'M' -> romanNums = 1000;
                }
                if (4 * romanNums < integer)
                    integer += romanNums;
                else
                    integer -= romanNums;
            }
            return integer;
        }
    }

    /*
    Given an array nums of distinct integers, return all the possible permutations.
    You can return the answer in any order.
    */
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> ans = new ArrayList<>();
        permutation(0,num,ans);
        return ans;
    }
    public static void permutation(int index,int[] num,List<List<Integer>> ans) {
        if (index == num.length) {
            List<Integer> array = new ArrayList<>();
            for (int n : num) array.add(n);
            ans.add(array);
            return;
        }
        for (int i = index; i < num.length; i++) {
            swap( i, index ,num);
            permutation(index + 1, num, ans);
            swap(index , i ,num);
        }
    }
    public static void swap(int i, int index , int[] num) {
        int temp = num[i];
        num[i] = num[index];
        num[index] = temp;
    }

    public static void main(String[] args) {
        // test your code here!
    }
}