public class SubString {
    public static void main(String[] args) {
        System.out.println(Integer.parseInt(subStringOut(args[0], args[1])));
    }

    public static String subStringOut(String a, String b) {
        // Output string
        String sub = "";

        // Check condition when length of a less or equal or greater than b
        if (a.length() < b.length()) {
            sub = "-" + subString(b, a);
        } else if (a.length() == b.length()) {
            int check = 0;
            // Check if any number of b is less than a which means b < a
            for (int i = 0; i < a.length(); i++) {
                int checkA = Integer.parseInt(String.valueOf(a.charAt(i)));
                int checkB = Integer.parseInt(String.valueOf(b.charAt(i)));
                if (checkA < checkB) {
                    check = 1;
                    break;
                }
            }
            // Add minus if the calculation result in negative value
            if (check == 1) {
                sub = "-" + subString(b, a);
            } else {
                sub = subString(a, b);
            }
        } else {
            sub = subString(a, b);
        }
        return sub;
    }

    public static String subString(String a, String b) {
        // After being processed, string a will always greater than string b
        String result = "";
        int carry = 0;
        int n1 = a.length();
        int n2 = b.length();
        // Reverse string a and b
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        // Add "0" to string b so that it will have the same length as string a
        for (int i = 1; i <= n1 - n2; i++) {
            b += "0";
        }
        // Subtraction of 2 string
        for (int i = 0; i < n1; i++) {
            int x1 = Integer.parseInt(String.valueOf(a.charAt(i)));
            int x2 = Integer.parseInt(String.valueOf(b.charAt(i)));
            int sub;
            if (x1 >= x2 + carry) {
                sub = x1 - x2 - carry;
                carry = 0;
            } else {
                sub = x1 + 10 - x2 - carry;
                carry = 1;
            }
            result += Integer.toString(sub);
        }

        return new StringBuilder(result).reverse().toString();
    }
}
