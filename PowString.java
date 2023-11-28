public class PowString {
    public String generate(String num, String power) {
        String[] number = { num, power };
        String result = powerString(number[0], number[1]);
        return result;
    }

    // use loop to multiply many times the numbers
    public static String powerString(String num, String pow) {
        String result = "1";
        MultiString multi = new MultiString();
        SubString subtr = new SubString();
        while (pow != "0") {
            result = multi.generate(result, num);
            pow = subtr.generate(pow, "1");
        }
        return result;
    }
}
