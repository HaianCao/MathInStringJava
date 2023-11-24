import java.util.Scanner;

public class SumString {
    public static void main(String[] args) {
        String[] num = { "", "" };
        inputString(num);
        int length = Math.max(num[0].length(), num[1].length());
        int[] firstNum = new int[length];
        int[] secondNum = new int[length];
        inputArray(firstNum, num[0]);
        inputArray(secondNum, num[1]);
        int[] result = new int[length + 1];
        result = sumaryString(firstNum, secondNum);
        output(result);
    }

    public static void inputString(String[] num) {
        System.out.println("");
        System.out.println("===========================");
        System.out.println("Sumary two numbers");
        String[] position = { "first", "second" };
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < num.length; i++) {
            System.out.print("Input the " + position[i] + " number: ");
            num[i] = sc.nextLine();
        }
        sc.close();
    }

    public static void inputArray(int[] arr, String num) {
        for (int i = 0; i < num.length(); i++) {
            arr[i] = Integer.parseInt(Character.toString(num.charAt(num.length() - 1 - i)));
        }
    }

    public static void output(int[] num) {
        String out = "";
        int end = num.length;
        if (num[end - 1] == 0) {
            end -= 1;
        }
        for (int i = 0; i < end; i++) {
            out = num[i] + out;
        }
        System.out.println("");
        System.out.println("Result is: " + out);
        System.out.println("===========================");
        System.out.println("");
    }

    public static int[] sumaryString(int[] num1, int[] num2) {
        int carry = 0;
        int[] result = new int[Math.max(num1.length, num2.length) + 1];
        for (int i = 0; i < num1.length; i++) {
            int sum = num1[i] + num2[i] + carry;
            result[i] = sum % 10;
            carry = sum / 10;
        }
        result[result.length - 1] = carry;
        return result;
    }
}
