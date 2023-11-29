public class DivString {
    public String generate(String num1, String num2) {
        String[] num = { num1, num2 };
        check(num[0], num[1]);
        String result = divString(num[0], num[1]);
        return result;
    }

    public static void check(String num1, String num2) {
        if (Integer.parseInt(num2) == 0) {
            System.out.println("Error: Divided by 0");
            System.exit(0);
        }
        if (num1 == "0") {
            System.out.println("Result is: " + 0);
            System.exit(0);
        }
    }

    public static String divString(String num1, String num2) {
        SubString sub = new SubString();
        SumString sum = new SumString();
        String result = "0";
        String turn = sub.generate(num1, num2);
        while (!sub.checkNegative()) {
            result = sum.generate(result, "1");
            turn = sub.generate(turn, num2);
        }
        return result;
    }
}
