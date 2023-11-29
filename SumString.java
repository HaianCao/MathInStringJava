public class SumString {
    public String generate(String num1, String num2) {
        String[] num = { num1, num2 };
        int length = Math.max(num[0].length(), num[1].length());
        int[] firstNum = new int[length];
        int[] secondNum = new int[length];
        inputArray(firstNum, num[0]);
        inputArray(secondNum, num[1]);
        int[] result = new int[length + 1];
        result = sumaryString(firstNum, secondNum);
        return output(result);
    }

    // input string into an array
    public static void inputArray(int[] arr, String num) {
        for (int i = 0; i < num.length(); i++) {
            arr[i] = Integer.parseInt(Character.toString(num.charAt(num.length() - 1 - i)));
        }
    }

    // reverse the array and output the result
    public static String output(int[] arr) {
        String out = "";
        int count = arr.length - 1;
        while (arr[count] == 0) {
            count--;
        }
        for (int i = 0; i <= count; i++) {
            out = Integer.toString(arr[i]) + out;
        }
        return out;
    }

    // sumary of 2 numbers
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
