import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearchWord {
    private static void sort(String [] words) {
        int length = words.length;
        for(int i=0; i<length; i++) {
            for(int j=i; j<length; j++) {
                if(words[i].compareTo(words[j]) > 0) {
                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }
        }
    }

    private static int bsearch(String word, String [] words, int a, int b) {
        if(b <= a)
            return -1;

        if(b - a == 1)
            return words[a].equals(word) ? a : -1;

        int pivot = (a + b)/2;
        if(word.compareTo(words[pivot]) < 0) {
            return bsearch(word, words, 0, pivot);
        } else if(word.compareTo(words[pivot]) > 0) {
            return bsearch(word, words, pivot, b);
        }

        return pivot;
    }

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] words = new String[4];
        for(int i=0; i<4; i++) {
            System.out.print("words["+i+"]: ");
            words[i] = br.readLine();
        }

        sort(words);
        for(int i=0; i<4; i++) {
            System.out.println("words["+i+"] = " + words[i]);
        }

        System.out.print("Enter word to search for: ");
        String word = br.readLine();

        int index = bsearch(word, words, 0, words.length);
        if(index < 0) {
            System.out.println("not found");
        } else {
            System.out.println("found at index " + index);
        }
    }
}