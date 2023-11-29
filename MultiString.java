
public class MultiString {
    public String generate(String num1, String num2) {
        String[] num = { num1, num2 };
        check(num[0], num[1]);
        int[] firstNum = new int[num[0].length()];
        int[] secondNum = new int[num[1].length()];
        inputArray(firstNum, num[0]);
        inputArray(secondNum, num[1]);
        int[] result = multiString(firstNum, secondNum);
        return output(result);
    }

    // check if 1 of 2 number is 0
    public static void check(String num1, String num2) {
        if (num1.length() == 1) {
            if (Integer.parseInt(num1) == 0) {
                System.out.println("Result is: " + 0);
                System.exit(0);
            }
        }
        if (num2.length() == 1) {
            if (Integer.parseInt(num2) == 0) {
                System.out.println("Result is: " + 0);
                System.exit(0);
            }
        }
    }

    // input string into an array
    public static void inputArray(int[] arr, String number) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(Character.toString(number.charAt(number.length() - 1 - i)));
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

    // multi each unit of first number with the whole second number
    // then put them into a list
    public static void multiUnit(int unit, int[] secondNum, int[] resultUnit, int position) {
        for (int i = 0; i < position; i++) {
            resultUnit[i] = 0;
        }
        int carry = 0;
        int last = 0;
        for (int i = 0; i < secondNum.length; i++) {
            int mul = unit * secondNum[i] + carry;
            resultUnit[i + position] = mul % 10;
            carry = mul / 10;
            last++;
        }
        resultUnit[last + position] = carry;
    }

    // sumary of list of multiplication of units
    public static int[] sumUnit(int[][] result) {
        int[] resultArr = new int[result[0].length];
        int carry = 0;
        for (int i = 0; i < result[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < result.length; j++) {
                sum += result[j][i];
            }
            sum += carry;
            resultArr[i] = sum % 10;
            carry = sum / 10;
        }
        return resultArr;
    }

    // sum of two number in string
    public static int[] multiString(int[] firstNum, int[] secondNum) {
        int[][] result = new int[firstNum.length][firstNum.length + secondNum.length];
        for (int i = 0; i < firstNum.length; i++) {
            multiUnit(firstNum[i], secondNum, result[i], i);
        }
        return sumUnit(result);
    }
}
