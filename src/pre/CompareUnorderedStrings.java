package pre;

public class CompareUnorderedStrings {

    public static void main(String[] args) {

        String s1 = "Indiaz";
        String s2 = "dinzIa";

        boolean result = areStringsEqual(s1, s2);
        System.out.println(result);
    }

    public static boolean areStringsEqual(String s1, String s2) {

        int[] count = new int[20];
        for (char c : s1.toCharArray()) {
            count[c]++;
        }
        System.out.println(count['z']);


        return true;
    }
}
