public class DivString {
    public String generate(String num1, String num2) {
        String[] num = { num1, num2 };
        check(num[0], num[1]);
        String result = divString(num[0], num[1]);
        return result;
    }

    public static void check(String num1, String num2) {
        if (num2 == "0") {
            System.out.println("Error: Divided by 0");
            System.exit(0);
        }
        if (num1 == "0") {
            System.out.println("Result is: " + 0);
            System.exit(0);
        }
    }

    public static String shorter(String num1, String num2) {
        String div = "0";
        SumString sum = new SumString();

        SubString subC = new SubString();
        String turnC = subC.generate(num1.substring(0, num2.length()), num2);
        if (num1.length() > num2.length()) {
            if (!subC.checkNegative()) {
                while (!subC.checkNegative()) {
                    div = sum.generate(div, "1");
                    turnC = subC.generate(turnC, num2);
                }
                for (int i = 0; i < num1.length() - num2.length(); i++) {
                    div += "0";
                }
                return div;
            } else {
                subC.checkB = false;
                turnC = subC.generate(num1.substring(0, num2.length() + 1), num2);
                while (!subC.checkNegative()) {
                    div = sum.generate(div, "1");
                    turnC = subC.generate(turnC, num2);
                }
                for (int i = 1; i < num1.length() - num2.length(); i++) {
                    div += "0";
                }
                return div;
            }
        }
        return div;
    }

    public static String divString(String num1, String num2) {
        String div = "0";
        String turn;
        String alre = "1";
        SubString sub = new SubString();
        SumString sum = new SumString();
        MultiString mul = new MultiString();
        if (num1.length() > num2.length()) {
            alre = shorter(num1, num2);
            sub.checkB = false;
        }
        turn = sub.generate(num1, sum.generate(mul.generate(alre, num2), num2));
        while (!sub.checkNegative()) {
            div = sum.generate(div, "1");
            turn = sub.generate(turn, num2);
        }
        return sum.generate(alre, div);
    }
}
