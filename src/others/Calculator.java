package others;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Calculator {

    static Stack<String> stack = new Stack<>();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());



        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");

            String[] expressionStr = divideExpression();
//            for (String e :
//                    expressionStr) {
//                System.out.println(e);
//            }

            int result = calc(expressionStr);

            System.out.println("\nresult: " + result);

        }

        System.out.println("fin");
    }

    static String[] divideExpression() {
        String expressionStr = "";
        while(st.hasMoreTokens()) {
            String token = st.nextToken();
            try {
                int number = Integer.parseInt(token);
                expressionStr += number + " ";
            } catch (NumberFormatException e) {
                if (token.equals("(")) stack.push(token);
                else if (token.equals(")")) {
                    while(!stack.peek().equals("(")) {
                        expressionStr += stack.pop() + " ";
                    }
                    stack.pop();
                } else {
                    // 필요하다면 연산자 우선순위 적용
                    stack.push(token);
                }

            }
        }

        while (!stack.isEmpty()) expressionStr += stack.pop() + " ";

        return expressionStr.trim().split(" ");
    }

    static int calc(String[] stackExpressionStr) {
        Stack<Integer> numberStack = new Stack<>();
        for (String exp: stackExpressionStr) {
            try {
                int number = Integer.parseInt(exp);
                numberStack.push(number);
            } catch (NumberFormatException e) {
                int num1 = numberStack.pop();
                int num2 = numberStack.pop();
                System.out.print("\n" + num2 + exp + num1);
                switch (exp) {
                    case "+":
                        numberStack.push(num2 + num1);
                        break;
                    case "-":
                        numberStack.push(num2 - num1);
                        break;
                    case "*":
                        numberStack.push(num2 * num1);
                        break;
                    case "/":
                        numberStack.push(num2 / num1);
                        break;
                }
            }
        }

        return numberStack.pop();
    }
}
