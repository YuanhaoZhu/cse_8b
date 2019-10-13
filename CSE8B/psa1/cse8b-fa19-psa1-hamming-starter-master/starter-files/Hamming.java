// All import statements go here. 
// Keep the below line. This tells Java to include the classes you need.
import java.util.*;

// TODO This is the file header, you can follow this format for all files. 
/**
 * File: 
 * Author:
 * Login: 
 * Date:
 * Sources of Help:
 *
 * (Put your file header comments here.)
 */

/**
 * TODO class header here
 */
public class Hamming
{
    /** TODO
     * [randomLowercaseString description]
     * 
     * @param  length [description]
     * @return        [description]
     */
    public static String randomLowercaseString(int length)
    {
        Random rand = new Random();
        // TODO: Start below


        return "";
    }

    /** TODO
     * [randomLowercaseStringII description]
     * 
     * @param  length [description]
     * @return        [description]
     */
    public static String randomLowercaseStringII(int length)
    {
        Random rand = new Random();
        // TODO: Start below


        return "";
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
     * @return             int array that somehow tells the caller which 
     *                     bits to check (you are free to do this in any 
     *                     way you like)
     */
    public static int[] parityHelper(int parityIndex)
    {
        /* DO NOT MODIFY and do not worry about magic numbers here*/
        if(parityIndex==1) return new int[]{1, 3, 5, 7};
        else if(parityIndex==2) return new int[]{2, 3, 6, 7};
        else if(parityIndex==4) return new int[]{4, 5, 6, 7};
        return new int[4];
    }

    /** TODO
     * [hammingEncode description]
     * 
     * @param  plaintext [description]
     * @return           [description]
     */
    public static String hammingEncode(String plaintext)
    {
        // TODO: Start below


        return "";
    }

    /** TODO
     * [hammingDecode description]
     * 
     * @param  ciphertext [description]
     * @return            [description]
     */
    public static String hammingDecode(String ciphertext)
    {
        // TODO: Start below


        return "";
    }

    /** TODO
     * [corruptHammingBit description]
     * 
     * @param  ciphertext [description]
     * @param  position   [description]
     * @return            [description]
     */
    public static String corruptHammingBit(String ciphertext, int position)
    {
        // TODO: Start below


        return "";
    }
}
