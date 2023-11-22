public class MultiString {
    public static void main(String[] args) {
        String num1 = args[0];
        String num2 = args[1];
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        int[] firstNum = new int[num1.length()];
        int[] secondNum = new int[num2.length()];
        inputArray(firstNum, num1);
        inputArray(secondNum, num2);
        int[] result = multiString(firstNum, secondNum);
        output(result);
    }

    // input string into an array
    public static void inputArray(int[] arr, String number) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(Character.toString(number.charAt(number.length() - 1 - i)));
        }
    }

    // reverse the array and output the result
    public static void output(int[] arr) {
        String out = "";
        int count = arr.length - 1;
        while (arr[count] == 0) {
            count--;
        }
        for (int i = 0; i <= count; i++) {
            out = Integer.toString(arr[i]) + out;
        }
        System.out.println(out);
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
