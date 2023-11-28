public class SubString {
    public String generate(String num1, String num2) {
        String[] num = { num1, num2 };
        if (num1.equals(num2)) {
            return "0";
        }
        int length = Math.max(num[0].length(), num[1].length());
        int[] firstNum = new int[length];
        int[] secondNum = new int[length];
        inputArray(firstNum, num[0]);
        inputArray(secondNum, num[1]);
        int[] result = new int[length];
        result = subtractString(firstNum, secondNum);
        return output(result);
    }

    // input string into an array
    public static void inputArray(int[] arr, String num) {
        for (int i = 0; i < num.length(); i++) {
            arr[i] = Integer.parseInt(Character.toString(num.charAt(num.length() - 1 - i)));
        }
    }

    // reverse the array and output the result
    public static String output(int[] num) {
        String out = "";
        int end = num.length;
        if (num[end - 1] == 0) {
            end -= 1;
        }
        for (int i = 0; i < end; i++) {
            out = num[i] + out;
        }
        return out;
    }

    // swap 2 numbers in array
    public static void swap(int[][] arr) {
        int[] temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
    }

    public static boolean checkB = false;

    // check to know if the result is negative number or not
    public boolean checkNegative() {
        return checkB;
    }

    // check if the first number is smaller than the second number
    public static void check(int[][] arr) {
        for (int i = arr[0].length - 1; i >= 0; i--) {
            if (arr[0][i] < arr[1][i]) {
                swap(arr);
                checkB = true;
                break;
            } else {
                break;
            }
        }
    }

    // subtract of 2 numbers
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

    // generate
    public static int[] subtractString(int[] num1, int[] num2) {
        int[][] arr = { num1, num2 };
        check(arr);
        int[] result = new int[num1.length];
        result = subtract(result, arr[0], arr[1]);
        return result;
    }
}
