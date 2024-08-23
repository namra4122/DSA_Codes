package Stack_Queue;

import java.util.Stack;

public class fixConversion {
    static int prior(char opt) {
        if (opt == '^')
            return 3;
        else if (opt == '*' || opt == '/')
            return 2;
        else if (opt == '+' || opt == '-')
            return 1;
        else
            return -1;
    }

    static String reverse(String str) {
        String rev = "";

        for (char i : str.toCharArray()) {
            if (i == '(') {
                rev += ')';
            } else if (i == ')') {
                rev += '(';
            } else {
                rev += i;
            }
        }

        StringBuilder strBuild = new StringBuilder(rev);
        return strBuild.reverse().toString();
    }

    static String infix2postfix(String s) {
        String ans = "";
        Stack<Character> optStack = new Stack<>();
        for (char i : s.toCharArray()) {
            if (i != '+' && i != '-' && i != '*' && i != '/' && i != '^' && i != '(' && i != ')') {
                ans += i;
            } else if (i == '(') {
                optStack.push(i);
            } else if (i == ')') {
                while (optStack.peek() != '(' && !optStack.isEmpty()) {
                    ans += optStack.pop();
                }
                optStack.pop(); // hum '(' ko bhi pop kar rahi hais
            } else {
                while (!optStack.isEmpty() && (prior(i) <= prior(optStack.peek()))) {
                    ans += optStack.pop();
                }
                optStack.push(i);
            }
        }

        while (!optStack.isEmpty()) {
            ans += optStack.pop();
        }
        return ans;
    }

    static String infix2prefix(String s) {
        /*
         * divided into 3 parts
         * i. reverse the string
         * ii. perform infix2postfix
         * iii. reverse the answer string
         */

        s = reverse(s);
        String ans = infix2postfix(s);
        ans = reverse(ans);
        return ans;
    }

    static String postfix2infix(String s) {
        Stack<String> st = new Stack<>();
        for (char i : s.toCharArray()) {
            if (i != '+' && i != '-' && i != '*' && i != '/' && i != '^') {
                st.push(Character.toString(i));
            } else {
                String st1 = st.pop();
                String st2 = st.pop();
                st.push(new String('(' + st2 + i + st1 + ')'));
            }
        }

        return st.peek();
    }

    static String prefix2infix(String s) {
        s = reverse(s);
        Stack<String> st = new Stack<>();
        for (char i : s.toCharArray()) {
            if (i != '+' && i != '-' && i != '*' && i != '/' && i != '^') {
                st.push(Character.toString(i));
            } else {
                String st1 = st.pop();
                String st2 = st.pop();
                st.push(new String('(' + st1 + i + st2 + ')'));
            }
        }

        return st.peek();
    }

    static String postfix2prefix(String s) {
        Stack<String> st = new Stack<>();

        for (char i : s.toCharArray()) {
            if (i != '+' && i != '-' && i != '*' && i != '/' && i != '^') {
                st.push(Character.toString(i));
            } else {
                String st1 = st.pop();
                String st2 = st.pop();

                st.push(new String(i + st2 + st1));
            }
        }

        return st.peek();
    }

    static String prefix2postfix(String s) {
        s = reverse(s);
        Stack<String> st = new Stack<>();

        for (char i : s.toCharArray()) {
            if (i != '+' && i != '-' && i != '*' && i != '/' && i != '^') {
                st.push(Character.toString(i));
            } else {
                String st1 = st.pop();
                String st2 = st.pop();

                st.push(new String(st1 + st2 + i));
            }
        }

        return st.peek();
    }

    public static void main(String[] args) {
        System.out.println("POSTFIX: " + infix2postfix("((A+B)-C*(D/E))+F"));
        System.out.println("PREFIX: " + infix2prefix("((A+B)-C*(D/E))+F"));
        System.out.println("POST TO INFIX: " + postfix2infix("AB+CDE/*-F+"));
        System.out.println("PRE TO INFIX: " + prefix2infix("+-+AB*C/DEF"));
        System.out.println("POST TO PREFIX: " + postfix2prefix("AB+CDE/*-F+"));
        System.out.println("PRE TO POSTFIX: " + prefix2postfix("+-+AB*C/DEF"));
    }
}
