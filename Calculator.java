import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input calculation: ");
        String calculation = sc.nextLine();
        String[] spl = calculation.split(" ");
        switch (spl[1]) {
            case "+":
                print(sumary(spl[0], spl[2]));
                break;
            case "-":
                print(subtract(spl[0], spl[2]));
                break;
            case "*":
                print(multiply(spl[0], spl[2]));
                break;
            case "/":
                print(divide(spl[0], spl[2]));
                break;
            case "%":
                print(modulus(spl[0], spl[2]));
                break;
            case "^":
                print(power(spl[0], spl[2]));
                break;
            default:
                System.out.println("Error syntax");
                break;
        }
        sc.close();
    }

    // print the result
    public static void print(String result) {
        System.out.println("Result is: " + result);
    }

    // generate sumary of 2 numbers
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
                String result = sub.generate(num2, num1);
                return (sub.checkNegative() ? "-" : "") + result;
            } else {
                num2 = num2.substring(1);
                String result = sub.generate(num1, num2);
                return (sub.checkNegative() ? "-" : "") + result;
            }
        }
    }

    // generate subtract of 2 numbers
    public static String subtract(String num1, String num2) {
        SubString sub = new SubString();
        if (num1.charAt(0) != '-' && num2.charAt(0) != '-') {
            String subtr = sub.generate(num1, num2);
            if (sub.checkNegative()) {
                return "-" + subtr;
            } else {
                return subtr;
            }
        } else if (num1.charAt(0) == '-' && num2.charAt(0) == '-') {
            num1 = num1.substring(1);
            num2 = num2.substring(1);
            String subtr = sub.generate(num1, num2);
            if (sub.checkNegative()) {
                return subtr;
            } else {
                return "-" + subtr;
            }
        } else if (num1.charAt(0) == '-' && num2.charAt(0) != '-') {
            SumString suma = new SumString();
            return "-" + suma.generate(num1.substring(1), num2);
        } else {
            SumString suma = new SumString();
            return suma.generate(num1, num2.substring(1));
        }
    }

    // generate multiply of 2 numbers
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

    // divide 2 numbers
    public static String divide(String num1, String num2) {
        DivString div = new DivString();
        String result = "";
        if (num1.charAt(0) == '-') {
            if (num2.charAt(0) == '-') {
                result = div.generate(num1.substring(1), num2.substring(1));
            } else {
                result = "-" + div.generate(num1.substring(1), num2);
            }
        } else {
            if (num2.charAt(0) == '-') {
                result = "-" + div.generate(num1, num2.substring(1));
            } else {
                result = div.generate(num1, num2);
            }
        }
        if (result.charAt(0) == '-' && result.charAt(1) == '0') {
            result = "0";
        }
        return result;
    }

    // modulus of 2 numbers
    public static String modulus(String num1, String num2) {
        ModString mod = new ModString();
        String result = "";
        if (num1.charAt(0) == '-') {
            if (num2.charAt(0) == '-') {
                result = mod.generate(num1.substring(1), num2.substring(1));
            } else {
                result = "-" + mod.generate(num1.substring(1), num2);
            }
        } else {
            if (num2.charAt(0) == '-') {
                result = "-" + mod.generate(num1, num2.substring(1));
            } else {
                result = mod.generate(num1, num2);
            }
        }
        if (result.charAt(0) == '-' && result.charAt(1) == '0') {
            result = "0";
        }
        return result;
    }

    // generate power of 2 numbers
    public static String power(String num, String powNum) {
        PowString pow = new PowString();
        if (powNum == "0") {
            return "1";
        }
        if (num.charAt(0) == '-') {
            if (powNum.charAt(0) == '-') {
                if (Integer.parseInt(Character.toString(powNum.charAt(powNum.length() - 1))) % 2 == 0) {
                    return "1/" + pow.generate(num.substring(1), powNum.substring(1));
                } else {
                    return "-1/" + pow.generate(num.substring(1), powNum.substring(1));
                }
            } else {
                if (Integer.parseInt(Character.toString(powNum.charAt(powNum.length() - 1))) % 2 == 0) {
                    return pow.generate(num.substring(1), powNum);
                } else {
                    return "-" + pow.generate(num.substring(1), powNum);
                }
            }
        } else {
            if (powNum.charAt(0) == '-') {
                return "1/" + pow.generate(num, powNum.substring(1));
            } else {
                return pow.generate(num, powNum);
            }
        }
    }
}