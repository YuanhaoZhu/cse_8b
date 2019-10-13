// All import statements go here. 
// Keep the below line. This tells Java to include the classes you need.

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// TODO This is the file header, you can follow this format for all files. 
/**
 * File:
 * Author:
 * Login:
 * Date:
 * Sources of Help:
 * <p>
 * (Put your file header comments here.)
 */

/**
 * TODO class header here
 */
public class Hamming {
    /** TODO
     * [randomLowercaseString description]
     *
     * @param  length [description]
     * @return [description]
     */
    public static String randomLowercaseString(int length) {
        String text = "";
        Random rand = new Random();
        while (length != 0) {
            char c = (char) (rand.nextInt(26) + 'a');
            text = text + c;
            length = length - 1;
        }

        return text;


    }

    /** TODO
     * [randomLowercaseStringII description]
     *
     * @param  length [description]
     * @return [description]
     */
    public static String randomLowercaseStringII(int length) {
        Random rand = new Random();
        StringBuilder builder = new StringBuilder();
        while (length != 0) {
            char c = (char) (rand.nextInt(26) + 'a');
            builder.append(c);
            length = length - 1;
        }
        return builder.toString();


    }

    /**
     * DO NOT MODIFY 
     *
     * Helper function for hammingEncode() and hammingDecode(). Finds 
     * which indices of a String of length 7 that the caller should 
     * check for error detection.
     *
     * @param  parityIndex the value whose associated bits we want to check 
     *                     in either hammingEncode() or hammingDecode()
     * @return int array that somehow tells the caller which
     *                     bits to check (you are free to do this in any 
     *                     way you like)
     */
    public static int[] parityHelper(int parityIndex) {
        /* DO NOT MODIFY and do not worry about magic numbers here*/
        if (parityIndex == 1) return new int[]{1, 3, 5, 7};
        else if (parityIndex == 2) return new int[]{2, 3, 6, 7};
        else if (parityIndex == 4) return new int[]{4, 5, 6, 7};
        return new int[4];
    }

    public static int[] Helper(int parityIndex) {
        /* DO NOT MODIFY and do not worry about magic numbers here*/
        if (parityIndex == 1) return new int[]{3, 5, 7};
        else if (parityIndex == 2) return new int[]{3, 6, 7};
        else if (parityIndex == 4) return new int[]{5, 6, 7};
        return new int[3];
    }

    /** TODO
     * [hammingEncode description]
     *
     * @param  plaintext [description]
     * @return [description]
     */
    public static String hammingEncode(String plaintext) {
        // TODO: Start below
        if (plaintext.matches("[01]+") == false) {
            return null;
        }
        if (plaintext.length() != 4) {
            return null;
        }
        String s = "0000000";
        StringBuilder result = new StringBuilder(s);
        result.setCharAt(2, plaintext.charAt(0));
        result.setCharAt(4, plaintext.charAt(1));
        result.setCharAt(5, plaintext.charAt(2));
        result.setCharAt(6, plaintext.charAt(3));
        int[] parity_pos = new int[]{1, 2, 4};
        for (int i = 0; i < parity_pos.length; i++) {
            int index = parity_pos[i];
            int[] look_at = Helper(index);
            int num = 0;
            for (int j = 0; j < look_at.length; j++) {
                if (result.charAt(look_at[j] - 1) == '1') {
                    num = num + 1;
                }
            }
            if (num % 2 == 0) {
                result.setCharAt(index - 1, '0');
            }
            if (num % 2 != 0) {
                result.setCharAt(index - 1, '1');
            }


        }

        return result.toString();
    }

    /** TODO
     * [hammingDecode description]
     *
     * @param  ciphertext [description]
     * @return [description]
     */
    public static String hammingDecode(String ciphertext) {
        // TODO: Start below
        StringBuilder text = new StringBuilder(ciphertext);
        List<Integer> mismatch = new ArrayList<>();
        int[] parity_pos = new int[]{1, 2, 4};
        for (int i = 0; i < parity_pos.length; i++) {
            int[] to_look = Helper(parity_pos[i]);
            int num_ones = 0;
            for (int j = 0; j < to_look.length; j++) {
                if (text.charAt(to_look[j] - 1) == '1') {
                    num_ones = num_ones + 1;
                }
            }
            if (num_ones % 2 == 0 && text.charAt(parity_pos[i] - 1) == '1') {
                mismatch.add(parity_pos[i]);


            }
            if (num_ones % 2 != 0 && text.charAt(parity_pos[i] - 1) == '0') {
                mismatch.add(parity_pos[i]);

            }


        }
        int sum = 0;
        for (int k : mismatch) {
            sum += k;
        }
        if (sum != 0 && text.charAt(sum - 1) == '1') {
            text.setCharAt(sum - 1, '0');
        }
        if (sum != 0 && text.charAt(sum - 1) == '0') {
            text.setCharAt(sum - 1, '1');
        }
        String decode = "";
        int[] initial_pos = new int[]{3, 5, 6, 7};
        for (int k = 0; k < initial_pos.length; k++) {
            decode = decode + text.charAt(initial_pos[k] - 1);

        }

        return decode;
    }

    /** TODO
     * [corruptHammingBit description]
     *
     * @param  ciphertext [description]
     * @param  position   [description]
     * @return [description]
     */
    public static String corruptHammingBit(String ciphertext, int position) {
        // TODO: Start below

        if (position == 1 || position == 2 || position == 4) {
            System.err.println("not valid input position");
            return null;
        }

        if (position > 7 || position < 1) {
            System.err.println("not valid input position");
            return null;
        }
        StringBuilder copy = new StringBuilder(ciphertext);
        if (ciphertext.charAt(position - 1) == '0') {
            copy.setCharAt(position - 1, '1');
        }
        if (ciphertext.charAt(position - 1) == '1') {
            copy.setCharAt(position - 1, '0');
        }
        return copy.toString();
    }

    public static void main(String[] args) {
        String s = "1101";
        String encode = hammingEncode(s);
        String corrupted = corruptHammingBit(encode, 3);
        System.out.println(s);
        System.out.println(encode);
        System.out.println(corrupted);
        System.out.println(hammingDecode(corrupted));
    }
}
