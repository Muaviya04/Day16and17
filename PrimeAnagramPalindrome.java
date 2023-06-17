import java.util.ArrayList;
import java.util.List;

public class PrimeAnagramPalindrome {
    public static void main(String[] args) {
        System.out.println("Prime numbers that are anagrams and palindromes:");
        for (int number = 2; number <= 1000; number++) {
            if (isPrime(number) && isAnagram(number) && isPalindrome(number)) {
                System.out.print(number + " ");
            }
        }
    }
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static boolean isAnagram(int number) {
        List<Integer> digits = new ArrayList<>();

        while (number > 0) {
            digits.add(number % 10);
            number /= 10;
        }
        for (int i = 0; i < digits.size() - 1; i++) {
            for (int j = i + 1; j < digits.size(); j++) {
                if (digits.get(i).equals(digits.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isPalindrome(int number) {
        int reverse = 0;
        int original = number;

        while (number > 0) {
            int remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number /= 10;
        }
        return original == reverse;
    }
}
