import java.util.Scanner;

public class SubString {
    public static void main(String[] args) {
        String[] num = { "", "" };
        inputString(num);
        int length = Math.max(num[0].length(), num[1].length());
        int[] firstNum = new int[length];
        int[] secondNum = new int[length];
        inputArray(firstNum, num[0]);
        inputArray(secondNum, num[1]);
        int[] result = new int[length];
        result = subtractString(firstNum, secondNum);
        output(result);
    }

    public static void inputString(String[] num) {
        System.out.println("");
        System.out.println("===========================");
        System.out.println("Subtract two numbers");
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

    public static void swap(int[][] arr) {
        int[] temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
    }

    public static void check(int[][] arr) {
        for (int i = arr[0].length - 1; i >= 0; i--) {
            if (arr[0][i] < arr[1][i]) {
                swap(arr);
                break;
            } else {
                break;
            }
        }
    }

    public static int[] subtract(int[] result, int[] num1, int[] num2) {
        int carry = 0;
        for (int i = 0; i < num1.length; i++) {
            if (num1[i] >= num2[i] + carry) {
                result[i] = num1[i] - num2[i] - carry;
                carry = 0;
            } else {
                result[i] = num1[i] + 10 - num2[i] - carry;
                carry = 1;
            }
        }
        return result;
    }

    public static int[] subtractString(int[] num1, int[] num2) {
        int[][] arr = { num1, num2 };
        check(arr);
        int[] result = new int[num1.length];
        result = subtract(result, arr[0], arr[1]);
        return result;
    }
}
