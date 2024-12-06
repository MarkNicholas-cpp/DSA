package Stack;

public class Stack {
    private int size = 0;
    private int top = -1;
    private int stack[];

    public void setSize(int size) {
        if (size <= 0)
            throw new IllegalArgumentException("Invalid Size");
        this.size = size;
        stack = new int[size];
    }

    public Stack(int size) {
        setSize(size);
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(int data) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full");
        }
        top++;
        stack[top] = data;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top--];
    }

    public int peak() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top];
    }

    public void printStack() {
        for (int i = top; i >= 0; i--) {
            System.out.println("|" + stack[i] + "|");
            System.out.println("---");
        }
    }

    public static Stack arrayToStack(int[] list) {
        Stack stack = new Stack(list.length);
        for (int i = 0; i < list.length; i++) {
            stack.push(list[i]);
        }
        return stack;
    }

    /* =================== PROBLEMS =================== */
    public static int calPoints(String[] ops) {
        var points = new Stack(ops.length);
        for (String op : ops) {
            switch (op) {
                case "+":
                    var prev1 = points.peak();
                    points.pop();
                    var prev2 = points.peak();
                    points.pop();
                    var next = prev1 + prev2;
                    points.push(prev2);
                    points.push(prev1);
                    points.push(next);
                    break;
                case "D":
                    points.push(points.peak() * 2);
                    break;
                case "C":
                    points.pop();
                    break;
                default:
                    points.push(Integer.parseInt(op));
                    break;
            }
        }
        var sum = 0;
        while (!points.isEmpty()) {
            sum += points.pop();
        }
        return sum;
    }

    public static String removeOuterParentheses(String s) {
        String result = "";
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (count != 0)
                    result += s.charAt(i);
                count++;

            } else if (s.charAt(i) == ')') {
                count--;
                if (count != 0)
                    result = result + s.charAt(i);
            }
        }
        return result;
    }

}
