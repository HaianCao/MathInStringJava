import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input calculation: ");
        String calculation = sc.nextLine();
        String[] spl = calculation.split(" ");
        SubString sub = new SubString();
        MultiString mul = new MultiString();
        switch (spl[1]) {
            case "+":
                System.out.println(sumary(spl[0], spl[2]));
                break;
            case "-":
                System.out.println(subtract(spl[0], spl[2]));
                break;
            case "*":
                System.out.println(multiply(spl[0], spl[2]));
                break;

            case "/":
                break;
            default:
                System.out.println("Error syntax");
                break;
        }
        sc.close();
    }

    public static String sumary(String num1, String num2) {
        SumString sum = new SumString();
        if (num1.charAt(0) != '-' && num2.charAt(0) != '-') {
            return sum.generate(num1, num2);
        } else if (num1.charAt(0) == '-' && num2.charAt(0) == '-') {
            num1 = num1.substring(1);
            num2 = num2.substring(1);
            return "-" + sum.generate(num1, num2);
        } else {
            SubString sub = new SubString();
            if (num1.charAt(0) == '-') {
                num1 = num1.substring(1);
                return sub.generate(num1, num2);
            } else {
                num2 = num2.substring(1);
                return sub.generate(num1, num2);
            }
        }
    }

    public static String subtract(String num1, String num2) {
        SubString sub = new SubString();
        if (num1.charAt(0) != '-' && num2.charAt(0) != '-') {
            String subtr = sub.generate(num1, num2);
            if (sub.checkNegative()) {
                return "-" + sub.generate(num1, num2);
            } else {
                return sub.generate(num1, num2);
            }
        } else if (num1.charAt(0) == '-' && num2.charAt(0) == '-') {
            num1 = num1.substring(1);
            num2 = num2.substring(1);
            String subtr = sub.generate(num1, num2);
            if (sub.checkNegative()) {
                return sub.generate(num1, num2);
            } else {
                return "-" + sub.generate(num1, num2);
            }
        } else if (num1.charAt(0) == '-' && num2.charAt(0) != '-') {
            SumString suma = new SumString();
            return "-" + suma.generate(num1.substring(1), num2);
        } else {
            SumString suma = new SumString();
            return suma.generate(num1, num2.substring(1));
        }
    }

    public static String multiply(String num1, String num2) {
        MultiString multi = new MultiString();
        if (num1.charAt(0) == '-' && num2.charAt(0) == '-') {
            num1 = num1.substring(1);
            num2 = num2.substring(1);
            return multi.generate(num1, num2);
        } else if (num1.charAt(0) == '-' && num2.charAt(0) != '-') {
            return "-" + multi.generate(num1.substring(1), num2);
        } else if (num2.charAt(0) == '-' && num1.charAt(0) != '-') {
            return "-" + multi.generate(num1, num2.substring(1));
        } else {
            return multi.generate(num1, num2);
        }
    }
}