package com.mykhailo.work;

import java.math.BigInteger;
import java.util.*;

public class LeetCodeProblems1 {

    // 12. Integer to Roman
    public static String intToRoman(int num) {
        String[] m = {"", "M", "MM", "MMM"};
        String[] c = {"", "C", "CC", "CCC", "CD",
                "D", "DC", "DCC", "DCCC", "CM"};
        String[] x = {"", "X", "XX", "XXX", "XL",
                "L", "LX", "LXX", "LXXX", "XC"};
        String[] i = {"", "I", "II", "III", "IV",
                "V", "VI", "VII", "VIII", "IX"};
        String thousands = m[num / 1000];
        String hundreds = c[(num % 1000) / 100];
        String tens = x[(num % 100) / 10];
        String ones = i[num % 10];
        return thousands + hundreds + tens + ones;
    }

    // 34. Find First and Last Position of Element in Sorted Array
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int start = -1;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (start == -1) {
                    start = i;
                }
                end = i;
            }
            if (nums[i] > target) {
                break;
            }
        }
        result[0] = start;
        result[1] = end;
        return result;
    }

    // 2160. Minimum Sum of Four Digit Number After Splitting Digits
    public static int minimumSum(int num) {
        int[] array = new int[4];
        for (int i = 0; i < array.length; i++) {
            array[i] = num % 10;
            num = num / 10;
        }
        Arrays.sort(array);
        int a = array[0] * 10 + array[3];
        int b = array[1] * 10 + array[2];
        return a + b;
    }

    // 2114. Maximum Number of Words Found in Sentences
    public static int mostWordsFound(String[] sentences) {
        int max = Integer.MIN_VALUE;
        for (String sentence : sentences) {
            List<String> list = Arrays.asList(sentence.split("\\s+"));
            max = Math.max(max, list.size());
        }
        return max;
    }

    // 24. Swap Nodes in Pairs
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        int temp = head.next.val;
        head.next.val = head.val;
        head.val = temp;
        head.next.next = swapPairs(head.next.next);
        return head;
    }

    // 151. Reverse Words in a String
    public static String reverseWords(String words) {
        String[] arrayOfWords = words.split("\\s+");
        StringBuilder reverseWords = new StringBuilder();
        for (int i = arrayOfWords.length - 1; i >= 0; i--) {
            reverseWords.append(arrayOfWords[i]).append(" ");
        }
        return reverseWords.toString().trim();
    }

    // 43. Multiply Strings
    public static String multiply(String num1, String num2) {
        BigInteger value1 = new BigInteger(num1);
        BigInteger value2 = new BigInteger(num2);
        return value1.multiply(value2).toString();
    }

    // 7. Reverse Integer
    public static int reverse(int x) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        StringBuilder temp = new StringBuilder(String.valueOf(x));
        temp.reverse();
        String reverse = temp.toString();
        String reverseMinus = "-" + reverse.substring(0, reverse.length() - 1);
        if (x >= 0) {
            if (Long.parseLong(reverse) >= max || Long.parseLong(reverse) <= min)
                return 0;
            return Integer.parseInt(reverse);
        } else {
            if (Long.parseLong(reverseMinus) >= max || Long.parseLong(reverseMinus) <= min)
                return 0;
            return Integer.parseInt(reverseMinus);
        }
    }

    // 26. Remove Duplicates from Sorted Array
    public static int removeDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int value : nums) {
            list.add(value);
        }
        Set<Integer> temp = new TreeSet<>(list);
        list = new ArrayList<>(temp);
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return temp.size();
    }

    // 1. Two Sum
    public static int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
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

    public static void main(String[] args) {
        System.out.println(intToRoman(2022));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(minimumSum(1425));
        System.out.println(mostWordsFound(new String[]{"of objects that implement", "the following example", "of the"}));
        System.out.println(reverse(1534236469));
        System.out.println(multiply("123456789", "987654321"));
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
