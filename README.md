![GitHub code size in bytes](https://img.shields.io/github/languages/count/mypage-solutions/Leetcode-Problems-1)
![GitHub top language](https://img.shields.io/github/languages/top/mypage-solutions/Leetcode-Problems-1)
![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/mypage-solutions/Leetcode-Problems-1)
![GitHub last commit](https://img.shields.io/github/last-commit/mypage-solutions/Leetcode-Problems-1)

# Leetcode Problems Solution 

## Table of Contents

- [General Info](#general-information)
- [Technologies Used](#technologies-used)
- [Project Status](#project-status)
- [Contact](#contact)

## General Information

1. [Integer to Roman](#integer-to-roman)
2. [Find First and Last Position of Element in Sorted Array](#find-first-and-last-position-of-element-in-sorted-array)
3. [Minimum Sum of Four Digit Number After Splitting Digits](#minimum-sum-of-four-digit-number-after-splitting-digits)
4. [Maximum Number of Words Found in Sentences](#maximum-number-of-words-found-in-sentences)
5. [Swap Nodes in Pairs](#swap-nodes-in-pairs)
6. [Reverse Words in a String](#reverse-words-in-a-string)
7. [Multiply Strings](#multiply-strings)
8. [Reverse Integer](#reverse-integer)
9. [Remove Duplicates from Sorted Array](#remove-duplicates-from-sorted-array)
10. [Two Sum](#two-sum)

#### Integer to Roman
<a href="https://leetcode.com/problems/integer-to-roman/"><em>Description</em></a>
```java
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
```
<br>

#### Find First and Last Position of Element in Sorted Array
<a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/"><em>Description</em></a>
```java
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
```
<br>

#### Minimum Sum of Four Digit Number After Splitting Digits
<a href="https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/"><em>Description</em></a>
```java
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
```
<br>

#### Maximum Number of Words Found in Sentences
<a href="https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/"><em>Description</em></a>
```java
public static int mostWordsFound(String[] sentences) {
        int max = Integer.MIN_VALUE;
        for (String sentence : sentences) {
            List<String> list = Arrays.asList(sentence.split("\\s+"));
            max = Math.max(max, list.size());
        }
        return max;
    }
```
<br>

#### Swap Nodes in Pairs
<a href="https://leetcode.com/problems/swap-nodes-in-pairs/"><em>Description</em></a>
```java
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
```
<br>

#### Reverse Words in a String
<a href="https://leetcode.com/problems/reverse-words-in-a-string/"><em>Description</em></a>
```java
public static String reverseWords(String words) {
        String[] arrayOfWords = words.split("\\s+");
        StringBuilder reverseWords = new StringBuilder();
        for (int i = arrayOfWords.length - 1; i >= 0; i--) {
            reverseWords.append(arrayOfWords[i]).append(" ");
        }
        return reverseWords.toString().trim();
    }
```
<br>

#### Multiply Strings
<a href="https://leetcode.com/problems/multiply-strings/"><em>Description</em></a>
```java
public static String multiply(String num1, String num2) {
        BigInteger value1 = new BigInteger(num1);
        BigInteger value2 = new BigInteger(num2);
        return value1.multiply(value2).toString();
    }
```
<br>

#### Reverse Integer
<a href="https://leetcode.com/problems/reverse-integer/"><em>Description</em></a>
```java
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
```
<br>

#### Remove Duplicates from Sorted Array
<a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/"><em>Description</em></a>
```java
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
```
<br>

#### Two Sum
<a href="https://leetcode.com/problems/two-sum/"><em>Description</em></a>
```java
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
```
<br>

## Technologies Used

<p>
<img src="https://github.com/mypage-solutions/Images/blob/main/Images/devicon/java-original.svg" width="35" height="35" /><span>&nbsp;&nbsp;</span>
<img src="https://github.com/mypage-solutions/Images/blob/main/Images/devicon/intellij-original.svg" width="35" height="35" /><span>&nbsp;&nbsp;</span>
<img src="https://github.com/mypage-solutions/Images/blob/main/Images/devicon/git-original.svg" width="35" height="35" /><span>&nbsp;&nbsp;</span>
<img src="https://github.com/mypage-solutions/Images/blob/main/Images/devicon/github-original.svg" width="35" height="35" /><span>&nbsp;&nbsp;</span>
</p>
  
## Project Status

Project is: _complete_.

## Contact

<p align="center">
<a href="https://twitter.com/Michael22878035"><img src="https://github.com/mypage-solutions/Images/blob/main/Images/icons/twitter-fill.png" /></a>
<a href="mailto:m_musienko@outlook.com"><img src="https://github.com/mypage-solutions/Images/blob/main/Images/icons/mail-fill.png" /></a>
<a href="https://www.linkedin.com/in/mykhailo-musiienko-80849880/"><img src="https://github.com/mypage-solutions/Images/blob/main/Images/icons/linkedin-box-fill.png" /></a>
<a href="https://t.me/Mykhailo_Musiienko"><img src="https://github.com/mypage-solutions/Images/blob/main/Images/icons/telegram-fill.png" /></a>
</p>
