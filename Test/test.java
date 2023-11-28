import java.util.Scanner;
import java.util.Stack;

public class test {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入運算式：");
        String expression = scanner.nextLine();

        try {
            double result = evaluateExpression(expression);
            System.out.println("運算結果：" + result);
        } catch (Exception e) {
            System.out.println("輸入的運算式無效：" + e.getMessage());
        }
    }

    public static double evaluateExpression(String expression) {
        char[] tokens = expression.toCharArray();

        // 運算符號堆疊
        Stack<Character> operators = new Stack<>();
        // 數字堆疊
        Stack<Double> values = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ' ')
                continue;

            if (Character.isDigit(tokens[i])) {
                StringBuilder sb = new StringBuilder();
                while (i < tokens.length && (Character.isDigit(tokens[i]) || tokens[i] == '.')) {
                    sb.append(tokens[i]);
                    i++;
                }
                values.push(Double.parseDouble(sb.toString()));
                i--;
            } else if (tokens[i] == '(') {
                operators.push(tokens[i]);
            } else if (tokens[i] == ')') {
                while (operators.peek() != '(') {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                operators.pop();
            } else if (isOperator(tokens[i])) {
                while (!operators.isEmpty() && hasPrecedence(tokens[i], operators.peek())) {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                operators.push(tokens[i]);
            }
        }

        while (!operators.isEmpty()) {
            values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        return (op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-');
    }

    private static double applyOperator(char operator, double b, double a) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("除數不能為零");
                }
                return a / b;
        }
        return 0;
    }
}