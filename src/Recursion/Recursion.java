package Recursion;

import java.util.ArrayList;
import java.util.Stack;

public class Recursion {
    public static int xPowN(int x, int pow) {
        if (pow == 1)
            return x;
        return x * xPowN(x, pow - 1);
    }

    public static Stack<Integer> pushBottomOfStack(Stack<Integer> stack, int data) {
        if (stack.isEmpty()) {
            stack.push(data);
            return stack;
        }
        int temp = stack.pop();
        pushBottomOfStack(stack, data);
        stack.push(temp);
        return stack;
    }

    public void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int temp = stack.pop();
        reverseStack(stack);
        pushBottomOfStack(stack, temp);
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1)
            return 1;
        return n * factorial(n - 1);
    }

    public static int fibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int tileWays(int n) {
        if (n == 0 || n == 1)
            return 1;
        return tileWays(n - 1) + tileWays(n - 2);
    }

    public static int findFirstOccurrence(int[] arr, int target, int index) {
        if (index == arr.length)
            return -1;
        if (arr[index] == target)
            return index;
        return findFirstOccurrence(arr, target, index + 1);
    }

    public static int findLastOccurrence(int[] arr, int target, int index) {
        if (index < 0) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        }
        return findLastOccurrence(arr, target, index - 1);
    }

    public static int countWays(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return countWays(n - 1) + (n - 1) * countWays(n - 2);
    }

    public static int powSum(ArrayList<Integer> a, int x, int n, int index) {
        if (x == 0)
            return 1;
        if (index >= a.size())
            return 0;
        int ways = powSum(a, x, n, index + 1) + powSum(a, x - (int) Math.pow(a.get(index), n), n, index + 1);
        return ways;
    }

    public static void printRange(int start, int end) {
        if (start == end) {
            System.out.print(end + " ");
            return;
        }

        System.out.print(start + " ");
        printRange(++start, end);
    }

    public static void main(String[] args) {
        // System.out.println(countWays(4));
        System.out.println(tileWays(100));
        // ArrayList<Integer> a = new ArrayList<>();
        // int val = (int) Math.pow(25, 1.0 / 2);
        // for (int i = 1; i <= val; i++) {
        // a.add(i);
        // }
        // int ways = powSum(a, 25, 2, 0);
        // System.out.println(ways);
        // printRange(1, 10);
        // System.out.println(factorial(5));
        // System.out.println(xPowN(5, 2));

        // Stack<Integer> stack = new Stack<>();
        // stack.push(3);
        // stack.push(2);
        // stack.push(1);
        // stack = pushBottomOfStack(stack, 4);
        // while(!stack.isEmpty()) {
        //     System.out.println(stack.peek() + " ");
        //     stack.pop();
        // }
    }
}


