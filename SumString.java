public class SumString {
    public static void main(String[] args) {
        System.out.println(sumString(args[0], args[1]));
    }

    public static String sumString(String a, String b) {
        // Check if length of string a less than string b then swap 2 string
        if (b.length() > a.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        int carry = 0;
        String result = "";
        int n1 = a.length();
        int n2 = b.length();
        // Reverse 2 string
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        // Add string "0" to string b so that it will have the same length as string a
        for (int i = 1; i <= n1 - n2; i++) {
            b += "0";
        }
        for (int i = 0; i <= n1 - 1; i++) {
            int sum = Integer.parseInt(String.valueOf(a.charAt(i)))
                    + Integer.parseInt(String.valueOf(b.charAt(i))) + carry;
            carry = sum / 10;
            result += Integer.toString(sum % 10);
        }
        return new StringBuilder(result).reverse().toString();
    }
}
