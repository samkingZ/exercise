package com.hihuaning.mixture;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class DataType1 {

    enum Size {SMALL, MEDIUM, LARGE, EXTRA_LARGE}

    ;

    public static String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        int tmp = 0;
        int count = 0;
        String[] unit = {"", "Thousand", "Million", "Billion"};
        String[] digit1 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] digit2 = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] digit3 = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String res = "";
        while (num / 1000 != 0 || num % 1000 != 0) {
            tmp = num % 1000;
            if (tmp != 0)
                res += unit[count] + " ";
            if (tmp % 100 / 10 == 1) {
                res += digit3[tmp % 10] + " ";
            } else {
                res += digit1[tmp % 10] + " ";
                res += digit2[tmp % 100 / 10] + " ";
            }
            if (tmp / 100 != 0) {
                res += "Hundred" + " ";
                res += digit1[tmp / 100] + " ";
            }

            num = num / 1000;
            count++;
        }
        String[] tmpres = res.split(" ");
        String result = "";
        System.out.println(Arrays.toString(tmpres));
        for (int i = tmpres.length - 1; i > 1; i--) {
            if (tmpres[i].equals(""))
                continue;
            result += tmpres[i] + ' ';
        }
        result += tmpres[1];
        return result.trim();
    }

    public int reverse(int x) {
        long y = 0;
        while (x != 0) {
            y = y * 10 + x % 10;
            x = x / 10;
            if (y > Integer.MAX_VALUE || y < Integer.MIN_VALUE)
                return 0;
        }
        return (int) y;
    }

    public String convert(String s, int numRows) {
        String[] res = new String[numRows];
        int i = 0;
        int j;
        int gap = numRows - 2;
        while (i < s.length()) {
            for (j = 0; j < numRows && i < s.length(); j++)
                res[j] += s.charAt(i++);
            for (j = gap; j > 0 && i < s.length(); j--)
                res[j] += s.charAt(i++);
        }
        String result = "";
        for (int k = 0; k < numRows; k++)
            result += res[k];
        return result;
    }

    public static int myAtoi1(String str) {
        if (str == null || str.length() < 1)
            return 0;
        str = str.trim();
        Set<Character> set = new HashSet();
        for (int i = 0; i < 10; i++) {
            set.add((char) (48 + i));
        }
        int len = str.length();
        boolean negative = false;
        boolean start = false;
        int index = 0;
        long res = 0;
        if (str.charAt(0) == '-') {
            negative = true;
            index = 1;
        } else if (str.charAt(0) == '+') {
            index = 1;
        }
        for (int i = index; i < len; i++) {
            char ch = str.charAt(i);
            if (!set.contains(ch)) {
                if (!start)
                    return 0;
                if (start)
                    break;
            } else {
                start = true;
                if (negative) {
                    res = res * 10 - ch + 48;
                } else {
                    res = res * 10 + ch - 48;
                }
                if (res > 2147483647)
                    return 2147483647;
                else if (res < -2147483648)
                    return -2147483648;
            }
        }

        return (int) res;
    }

    public int myAtoi(String str) {
        if (str == null || str.length() < 1)
            return 0;
        Set<Character> set = new HashSet();
        for (int i = 0; i < 10; i++) {
            set.add((char) (48 + i));
        }
        int len = str.length();
        boolean negative = false;
        boolean start = false;
        int res = 0;
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (set.contains(ch)) {
                start = true;
                if (negative) {
                    res = res * 10 - ch - 48;
                } else {
                    res = res * 10 + ch - 48;
                }
            } else {
                if (ch == '-' && set.contains(str.charAt(i + 1)))
                    negative = true;
                if (start)
                    break;
                continue;
            }

        }
        return res;
    }

    public boolean isPalindrome(int x) {
        int tmp = x;
        int y = 0;
        while (x > 0) {
            y = y * 10 + x % 10;
            x = x / 10;
        }
        if (tmp == y)
            return true;
        return false;
    }

    public int romanToInt(String s) {
        Map<Character, Integer> change = new HashMap();
        change.put('I', 1);
        change.put('V', 5);
        change.put('X', 10);
        change.put('L', 50);
        change.put('C', 100);
        change.put('D', 500);
        change.put('M', 1000);
        int res = change.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int pre = change.get(s.charAt(i - 1));
            int cur = change.get(s.charAt(i));
            if (pre >= cur)
                res += cur;
            else
                res = res + cur - 2 * pre;
        }
        return res;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null)
            return null;
        int arrayLen = strs.length;
        String commonPrefix = strs[0];
        for (int i = 1; i < arrayLen; i++) {
            while (strs[i].indexOf(commonPrefix) != 0)
                commonPrefix = commonPrefix.substring(0, commonPrefix.length() - 1);
        }
        return commonPrefix;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < n; i++)
            first = first.next;
        if (first == null)
            return head.next;
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return head;
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty())
                    return false;
                char top = stack.peek();
                if (ch == '}') {
                    if (top == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (ch == ']') {
                    if (top == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (ch == ')') {
                    if (top == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        if (!stack.isEmpty())
            return false;
        return true;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        ListNode newNode = new ListNode(0);
        ListNode list = null;
        boolean flag = true;
        while (l1 != null && l2 != null) {
            ListNode tmp = null;
            if (l1.val < l2.val) {
                tmp = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                tmp = new ListNode(l2.val);
                l2 = l2.next;
            }
            newNode.next = tmp;
            if (flag) {
                list = newNode.next;
                flag = false;
            }
            newNode = newNode.next;
        }
        if (l1 != null) {
            newNode.next = l1;
        }
        if (l2 != null) {
            newNode.next = l2;
        }
        return list;
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;
        int len = nums.length;
        int j = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int realLen = len;
        for (int i = 0; i < realLen; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < realLen; j++) {
                    nums[j - 1] = nums[j];
                }
                realLen--;
                i--;
            }
        }
        return realLen;
    }

    public int strStr(String haystack, String needle) {
        int haylen = haystack.length();
        int needlelen = needle.length();
        if (needlelen < 1)
            return 0;
        for (int i = 0; i < haylen - needlelen + 1; i++) {
            int j;
            for (j = 0; j < needlelen; j++) {
                if (haystack.charAt(j + i) != needle.charAt(j))
                    break;
            }
            if (j == needlelen)
                return i;
        }
        return -1;
    }

    public boolean isValidSudoku(char[][] board) {
        Set<Character> set1 = new HashSet();
        Set<Character> set2 = new HashSet();
        Set<Character> set3 = new HashSet();
        Set<Character> set4 = new HashSet();
        Set<Character> set5 = new HashSet();
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) {
                set3.clear();
                set4.clear();
                set5.clear();
            }
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (set1.contains(board[i][j]))
                        return false;
                    else {
                        set1.add(board[i][j]);
                    }
                }
                if (board[j][i] != '.') {
                    if (set2.contains(board[j][i]))
                        return false;
                    else {
                        set2.add(board[j][i]);
                    }
                }

                if (j / 3 == 0 && board[i][j] != '.') {
                    if (set3.contains(board[i][j]))
                        return false;
                    else
                        set3.add(board[i][j]);
                } else if (j / 3 == 1 && board[i][j] != '.') {
                    if (set4.contains(board[i][j]))
                        return false;
                    else
                        set4.add(board[i][j]);
                } else if (j / 3 == 2 && board[i][j] != '.') {
                    if (set5.contains(board[i][j]))
                        return false;
                    else
                        set5.add(board[i][j]);
                }
            }
            set1.clear();
            set2.clear();
        }
        return true;
    }

    public static String countAndSay(int n) {
        String result = "1";
        for (int i = 0; i < n - 1; i++) {
            result = change(result);
        }
        return result;
    }

    public static String change(String str) {
        StringBuffer sbf = new StringBuffer("");
        int len = str.length();
        char prev = str.charAt(0);
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (prev == str.charAt(i)) {
                count++;
            } else {
                sbf.append(count);
                sbf.append(prev);
                count = 1;
                prev = str.charAt(i);
            }
        }
        sbf.append(count);
        sbf.append(prev);
        return sbf.toString();
    }

    public int lengthOfLastWord(String s) {
        return s.trim().length() - 1 - s.trim().lastIndexOf(' ');
    }

    public int[] plusOne(int[] digits) {
        boolean flag = false;
        int len = digits.length;
        digits[len]++;
        for (int i = len; i > -1; i++) {
            if (flag)
                digits[i]++;
            if (digits[i] == 10) {
                digits[i] = 0;
                flag = true;
            } else {
                break;
            }
        }
        if (digits[0] == 0) {
            int[] newNum = new int[len + 1];
            for (int i = len; i > 0; i++) {
                newNum[i] = digits[i - 1];
            }
            newNum[0] = 1;
            return newNum;
        }
        return digits;
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList();
        String str = "";
        TreeNode node = null;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            node = stack.pop();
            if (node.left == null && node.right == null) {
                str += node.val;
                list.add(str);
                str = "";
            } else {
                str += node.val + "->";
            }

        }
        return list;
    }

    private static Stack<Integer> stack = new Stack();
    private static Stack<Integer> minStack = new Stack();

    public int addDigits(int num) {
        return num - 9 * ((num - 1) / 9);
    }

    public String addBinary(String a, String b) {
        a = new StringBuffer(a).reverse().toString();
        b = new StringBuffer(b).reverse().toString();
        int len1 = a.length();
        int len2 = b.length();
        int min = 0;
        int max = 0;
        String maxStr = null;
        if (len1 > len2) {
            min = len2;
            max = len1;
            maxStr = a;
        } else {
            min = len1;
            max = len2;
            maxStr = b;
        }

        boolean flag = false;
        StringBuffer sb = new StringBuffer();
        int i;
        for (i = 0; i < min; i++) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);
            if (c1 == '1' && c2 == '1' && flag) {
                sb.append(c1);
                flag = true;
            } else if (c1 == '1' && c2 == '1' && !flag) {
                sb.append('0');
                flag = true;
            } else if (c1 == '0' && c2 == '1' && flag || c1 == '1' && c2 == '0' && flag) {
                sb.append('0');
                flag = true;
            } else if (c1 == '0' && c2 == '1' && !flag || c1 == '1' && c2 == '0' && !flag) {
                sb.append('1');
                flag = false;
            } else if (c1 == '0' && c2 == '0' && flag) {
                sb.append('1');
                flag = false;
            } else {
                sb.append('0');
                flag = false;
            }
        }


        for (int j = i; j < max; j++) {
            char c1 = maxStr.charAt(j);
            if (c1 == '0' && !flag)
                sb.append('0');
            else if (c1 == '1' && !flag) {
                sb.append('1');
            } else if (c1 == '0' && flag) {
                sb.append('1');
                flag = false;
            } else if (c1 == '1' && flag) {
                sb.append('0');
                flag = true;
            }
        }
        if (flag)
            sb.append('1');
        return sb.reverse().toString();
    }

    public String addBinary0(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        BigDecimal a1 = new BigDecimal(0);
        BigDecimal b1 = new BigDecimal(0);
        for (int i = 0; i < len1; i++) {
            if (a.charAt(i) == '1')
                a1.add(new BigDecimal(Math.pow(2, len1 - i - 1)));
        }
        for (int i = 0; i < len2; i++) {
            if (b.charAt(i) == '1')
                b1.add(new BigDecimal(Math.pow(2, len2 - i - 1)));
        }
        BigDecimal c = a1.add(b1);
        return c.toEngineeringString();
    }

    public int climbStairs(int n) {
        if (n < 3)
            return n;
        int[] climb = new int[n + 1];
        climb[0] = 0;
        climb[1] = 1;
        climb[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            climb[i] = climb[i - 1] + climb[i - 2];
        }
        return climb[n];
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode now = head;
        while (now != null) {
            while (now.next != null && now.val == now.next.val)
                now.next = now.next.next;
            now = now.next;
        }
        return head;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int start = 0;
        for (int i = 0; i < n; i++) {
            int j;
            for (j = start; j < m + i; j++) {
                if (nums1[j] > nums2[i]) {
                    start = j;
                    break;
                }
            }
            if (j == m + i) {
                for (int k = i; k < n; k++) {
                    nums1[k + m] = nums2[k];
                }
                break;
            }
            for (int k = m + i - 1; k > start - 1; k--) {
                nums1[k + 1] = nums1[k];
            }
            nums1[start] = nums2[i];
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return false;
        TreeNode mirror = mirror(root.left);
        return chargeSymmetric(mirror, root.right);
    }

    public boolean chargeSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root2 == null || root1 == null)
            return false;
        if (root1.val != root2.val)
            return false;
        return chargeSymmetric(root1.left, root2.left) && chargeSymmetric(root1.right, root2.right);
    }

    public TreeNode mirror(TreeNode root) {
        if (root == null)
            return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirror(root.left);
        mirror(root.right);
        return root;
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null)
            return list;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> tmp = new ArrayList();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmpNode = q.poll();
                tmp.add(tmpNode.val);
                if (tmpNode.left != null) {
                    q.add(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    q.add(tmpNode.right);
                }
            }
            list.add(0, tmp);
        }
        return list;
    }

    public static List<List<Integer>> levelOrderBottom0(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> innerList = new ArrayList<Integer>();
        int number = 0;
        int level = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            number++;
            int newLevel = countLevel(number);
            if (newLevel != level) {
                level = newLevel;
                list.add(innerList);
                innerList = new ArrayList<Integer>();
            }
            if (temp != null) {
                innerList.add(temp.val);
                queue.add(temp.left);
                queue.add(temp.right);
            }
        }
        return list;

    }

    public static int countLevel(int number) {
        if (number == 1)
            return 1;
        int level = 0;
        for (int i = 0; i < 100; i++) {
            if (countTotal(i) < number && number <= countTotal(i + 1)) {
                level = i + 2;
            }
        }
        return level;
    }

    public static int countTotal(int level) {
        int count = 0;
        for (int i = 0; i < level + 1; i++) {
            count += Math.pow(2, i);
        }
        return count;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int lDepth = getDepth(root.left);
        int rDepth = getDepth(root.right);
        if (Math.abs(lDepth - rDepth) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        int lDepth = 1;
        int rDepth = 1;
        lDepth += getDepth(root.left);
        rDepth += getDepth(root.right);
        if (lDepth > rDepth)
            return lDepth;
        else
            return rDepth;
    }

    public boolean isBalanced0(TreeNode root) {
        if (root == null)
            return true;
        int max = maxDepth(root);
        int min = minDepth(root);
        if (Math.abs(max - min) > 1)
            return false;
        else
            return true;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null)
            return 1;
        int depthl = 1;
        int depthr = 1;
        int depth = 0;
        if (root.left != null)
            depthl += maxDepth(root.left);
        if (root.right != null)
            depthr += maxDepth(root.right);
        if (root.right == null || root.left != null && root.right != null && depthl > depthr)
            depth = depthl;
        else if (root.left == null || root.right != null && root.left != null && depthr >= depthl)
            depth = depthr;
        return depth;
    }


    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null)
            return 1;
        int depthl = 1;
        int depthr = 1;
        int depth = 0;
        if (root.left != null)
            depthl += minDepth(root.left);
        if (root.right != null)
            depthr += minDepth(root.right);
        if (depthl > depthr)
            depth = depthr;
        else
            depth = depthl;
        return depth;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        boolean result = false;
        if (sum < root.val || root == null) {
            return result;
        }
        if ((sum -= root.val) == 0 && root.left == null && root.right == null)
            result = true;
        if (root.left != null && sum > root.left.val) {
            result = hasPathSum(root.left, sum);
        }
        if (result == true)
            return result;
        if (root.right != null && sum > root.right.val) {
            result = hasPathSum(root.right, sum);
        }
        return result;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> boss = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList();
        tmp.add(1);
        boss.add(tmp);
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList();
            row.add(1);
            int prev = tmp.get(0);
            for (int j = 1; j < tmp.size(); j++) {
                row.add(prev + tmp.get(j));
                prev = tmp.get(j);
            }
            row.add(1);
            boss.add(row);
            tmp = row;
        }
        return boss;
    }

    public static BigDecimal factorial(int n, int r) {
        BigDecimal count = new BigDecimal(1);
        while (r > 0) {
            count = count.multiply(new BigDecimal(n));
            n--;
            r--;
        }
        return count;
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        int len = 0;
        if (rowIndex % 2 == 0) {
            len = (rowIndex + 1) / 2 + 1;
        } else {
            len = (rowIndex + 1) / 2;
        }
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            BigDecimal num = factorial(rowIndex, i).divide(factorial(i, i));
            arr[i] = num.intValue();
            list.add(arr[i]);
        }
        if ((rowIndex + 1) % 2 == 0) {
            for (int i = len - 1; i > -1; i--) {
                list.add(arr[i]);
            }
        } else {
            for (int i = len - 2; i > -1; i--) {
                list.add(arr[i]);
            }
        }
        return list;
    }

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() < 1)
            return true;
        s = s.toLowerCase();
        int len = s.length();
        char[] arr = new char[len];
        int j = 0;
        for (int i = 0; i < len; i++) {
            char tmp = s.charAt(i);
            if (tmp > 47 && tmp < 58 || tmp > 64 && tmp < 91 || tmp > 96 && tmp < 123) {
                arr[j] = tmp;
                j++;
            }
        }
        int len1 = j;
        for (int i = 0; i < len1 / 2; i++) {
            if (arr[i] != arr[len1 - i - 1])
                return false;
        }
        return true;
    }

    public static void push(int x) {
        if (minStack.isEmpty())
            minStack.push(x);
        else {
            if (x <= getMin()) {
                minStack.push(x);
            }
        }
        stack.push(x);
    }

    public static void pop() {
        if (minStack.peek().equals(stack.peek())) {   //这里不能用 == 因为前面定义stack时用的Integer
            minStack.pop();
        }
        stack.pop();
    }

    public static int top() {
        return stack.peek();
    }

    public static int getMin() {
        int min = minStack.peek();
        return min;
    }

    public static int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int len1 = arr1.length;
        int len2 = arr2.length;
        int max = len1;
        int min = len2;
        if (len1 < len2) {
            max = len2;
            min = len1;
        }
        for (int i = 0; i < min; i++) {
            if (Integer.valueOf(arr1[i]) > Integer.valueOf(arr2[i]))
                return 1;
            else if (Integer.valueOf(arr1[i]) < Integer.valueOf(arr2[i]))
                return -1;
        }
        if (max == len1)
            for (int i = min; i < max; i++) {
                if (Integer.valueOf(arr1[i]) > 0)
                    return 1;
            }
        else if (max == len2) {
            for (int i = min; i < max; i++) {
                if (Integer.valueOf(arr2[i]) > 0)
                    return -1;
            }
        }
        return 0;

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        int len1 = 0;
        int len2 = 0;
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1 != null) {
            len1++;
            l1 = l1.next;
        }
        while (l2 != null) {
            len2++;
            l2 = l2.next;
        }
        int abs = Math.abs(len2 - len1);
        if (len1 > len2) {
            for (int i = 0; i < abs; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < abs; i++) {
                headB = headB.next;
            }
        }
        ListNode Intersection = null;
        while (headA != null) {
            if (headA.val == headB.val) {
                if (Intersection == null)
                    Intersection = headA;
            } else {
                Intersection = null;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return Intersection;
    }

    public static String convertToTitle(int n) {
        int[] refer = {2147483647, 321272407, 12356631, 475255, 18279, 703, 27, 1};
        int len = 0;
        Map<Integer, Character> table = new HashMap<Integer, Character>();
        for (int i = 1; i < 27; i++) {
            table.put(i, (char) (i + 64));
        }
        for (int i = 0; i < refer.length; i++) {
            if (n / refer[i] > 0) {
                len = refer.length - i;
                break;
            }
        }
        System.out.println(len);
        String str = "";
        for (int i = len; i > 0; i--) {
            int a = n / (int) Math.pow(26, i - 1);
            if (n % (int) Math.pow(26, i - 1) == 0 && i > 1) {
                a--;
            }
            if (a > 0) {
                char tmp = table.get(a);
                str = str + tmp;
            }

            n = n % (int) Math.pow(26, i - 1);
            if (n % (int) Math.pow(26, i - 1) == 0 && i > 1)
                n = (int) Math.pow(26, i - 1);
        }

        return str;
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        Iterator iter = map.entrySet().iterator();
        int maxnum = map.get(nums[0]);
        int max = nums[0];
        while (iter.hasNext()) {
            Map.Entry<Integer, Integer> entry = (Map.Entry) iter.next();
            if (entry.getValue() > maxnum) {
                maxnum = entry.getValue();
                max = entry.getKey();
            }
        }
        return max;
    }

    public static int titleToNumber(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        Map<Character, Integer> table = new HashMap<Character, Integer>();
        for (int i = 1; i < 27; i++) {
            table.put((char) (i + 64), i);
        }
        s = s.toUpperCase();
        int len = s.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            count += table.get(s.charAt(i)) * Math.pow(26, len - i - 1);
        }
        return count;
    }

    public static int trailingZeroes(int n) {
        int count = 0;
        while (n / 5 > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }

    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 1)
            return;
        int len = nums.length;
        k = k % len;
        int[] result = new int[len];
        for (int i = len - k, j = 0; i < len; i++, j++)
            result[j] = nums[i];
        for (int i = 0, j = k; i < len - k; i++, j++)
            result[j] = nums[i];
        for (int i = 0; i < len; i++)
            nums[i] = result[i];
    }

    public static int reverseBits(int n) {
        long count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count += (long) Math.pow(2, 31 - i);
            }
            n = n >> 1;
        }
        return (int) count;
    }

    public static boolean isIsomorphic(String s, String t) {
        int len = s.length();
        Map<Character, Character> map1 = new HashMap();
        Map<Character, Character> map2 = new HashMap();
        for (int i = 0; i < len; i++) {
            if (!map1.containsKey(s.charAt(i))) {
                map1.put(s.charAt(i), t.charAt(i));
            } else {
                char temp = map1.get(s.charAt(i));
                if (temp != t.charAt(i))
                    return false;
            }
            if (!map2.containsKey(t.charAt(i))) {
                map2.put(t.charAt(i), s.charAt(i));
            } else {
                char temp = map2.get(t.charAt(i));
                if (temp != s.charAt(i))
                    return false;
            }
        }
        return true;
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        if (len < 1)
            return 0;
        int[][] m = new int[len + 1][len];
        for (int i = 0; i < len; i++) {
            m[i][i] = nums[i];
        }
        for (int r = 2; r <= len; r++) {
            for (int i = 0; i <= len - r; i++) {
                int j = i + r - 1;
                m[i][j] = m[i + 1][j];
                for (int k = i + 1; k <= j; k++) {
                    int t = m[i][k - 1] + m[k + 1][j];
                    if (t > m[i][j]) {
                        m[i][j] = t;
                    }
                }
            }
        }
        return m[0][len - 1];
    }

    public boolean isAnagram(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        if (len1 != len2) {
            return false;
        }
        char[] chars = new char[len1];
        chars = s.toCharArray();
        char[] chart = new char[len1];
        chart = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chart);
        if (Arrays.equals(chars, chart))
            return true;
        else
            return false;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode tail = new ListNode(head.val);
        tail.next = null;
        ListNode nodeTemp = null;
        while (head.next != null) {
            nodeTemp = new ListNode(head.next.val);
            nodeTemp.next = tail;
            tail = nodeTemp;
            head = head.next;
        }
        return nodeTemp;
    }

    public static int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args) {

        System.out.println(numberToWords(1000000));
        int[] a = new int[5];
        a[0] = 0;
        a[1] = 2;
        a[2] = 3;
        int[] b = {2, 1};
        merge(a, 3, b, 2);
        System.out.println(Arrays.toString(a));
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        System.out.println(levelOrderBottom(root));
        System.out.println();
        System.out.println(generate(5).toString());
        System.out.println(getRow(18).toString());

        //System.out.println(isPalindrome("hhi2,i.hh"));
        push(512);
        push(-1024);
        push(-1024);
        push(512);
        pop();
        getMin();
        pop();
        getMin();
        pop();
        getMin();
        System.out.println(compareVersion("1.5.6.0", "1.5.6"));
        System.out.println(titleToNumber("ab"));
        System.out.println(trailingZeroes(100));
        int[] nums = {2, 4, 15, 23, 6, 12, 3, 51, 32, 15, 5, 61, 45, 32};
        int[] nums1 = {1, 2};
        rotate(nums1, 3);
        System.out.println(Arrays.toString(nums1));
        rotate(nums, 5);
        System.out.println(Arrays.toString(nums));
        System.out.println(isIsomorphic("hello", "yeooq"));
        System.out.println(reverseBits(1));
        System.out.println((long) Math.pow(2, 31));
        /*System.out.println(hammingWeight(5));
		System.out.println(rob(nums));*/
		/*long l = (long) 0xcafebabe;
		System.out.println(Integer.toBinaryString(0xcafebabe));
		System.out.println(Long.toBinaryString(l));
		System.out.println(l);*/
		/*if(5){						//错误，不能强转为boolean型
			System.out.println("hi");
		}*/

		/*System.out.println(0b1000<<1);   //左移位操作
		 */

		/*int a = 1;				//+=是右结合运算符，所以这里相当于 a += (b += c)
		int b = 2;
		int c = 3;
		a += b+=c;
		System.out.println(a);*/

		/*Size s = Size.SMALL;  	//枚举的用法
		System.out.println(s);*/

		/*
		String str = null;
		String str1 = "";
		int len = str.length();    //因为没有任何对象和str相关联，所以这里会报错
		int len1 = str1.length();	//
		*/

		/*
		String [] strs = {"hello","world"};  //Arrays.toString(a)方法，放回一个包含数组元素的字符串
		System.out.println(Arrays.toString(strs)); //Arrays.copyOf()方法可以将一个数组的所有值拷贝到一个新的数组中去
													//Arrays.sort()方法是优化了的快速排序算法
		*/

		/*Employee eone = new Employee("zengbo");  //一个方法可以访问所属
		Employee etwo = new Employee("huaning");
		System.out.println(eone.equals(etwo));*/
    }
}

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public boolean equals(Employee other) {
        return name.equals(other);
    }


}
