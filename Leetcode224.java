class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int num = 0;
        int result = 0;
        for (char c : s.toCharArray()) {
            if (c == '+' || c == '-') {
                result += num * sign;
                num = 0;
                sign = c == '+' ? 1 : -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
                num = 0;
            } else if (c == ')') {
                result += sign * num;
                result = result * stack.pop();
                result = stack.pop() + result;
                num = 0;
                sign = 1;
            } else if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            }
        }
        if (num != 0) {
            result += sign * num;
        }
        return result;
    }
}