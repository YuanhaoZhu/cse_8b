import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/** 
 * Unit tests for Hamming.java, using JUnit 5
 * javac Hamming.java
 * javac -cp junit-platform-console-standalone-1.5.2.jar:. HammingTest.java
 * java -jar junit-platform-console-standalone-1.5.2.jar --class-path . --scan-class-path
 */
class HammingTest {

    @Test
    void testRandomLowercaseString() {
        String result; 
        for (int i = 0; i < 10; i++) {
            result = Hamming.randomLowercaseString(i);
            assertEquals(i, result.length());
        }
        /** ADD MORE TESTS BELOW **/
    }

    @Test
    void testRandomLowercaseStringII() {
        String result; 
        for (int i = 0; i < 10; i++) {
            result = Hamming.randomLowercaseStringII(i);
            assertEquals(i, result.length());
        }
        /** ADD MORE TESTS BELOW **/
    }
    
    @Test
    void testHammingEncode() {
        String input = "0000";
        String answer = "0000000";
        String result = Hamming.hammingEncode(input);
        assertEquals(answer, result);

        input = "0001";
        answer = "1101001";
        result = Hamming.hammingEncode(input);
        assertEquals(answer, result);

        /** ADD MORE TESTS BELOW **/
    }

    @Test
    void testHammingDecode() {
        String input = "0000000";
        String answer = "0000";
        String result = Hamming.hammingDecode(input);
        assertEquals(answer, result);

        input = "1101001";
        answer = "0001";
        result = Hamming.hammingDecode(input);
        assertEquals(answer, result);
        
        /** ADD MORE TESTS BELOW **/
    }

    @Test
    void testBitCorruptInvalid() {
        String input = "1111111";
        String result = Hamming.corruptHammingBit(null, 1);
        assertEquals(null, result);
        result = Hamming.corruptHammingBit(input, 0);
        assertEquals(null, result);
        result = Hamming.corruptHammingBit(input, 8);
        assertEquals(null, result);
        input = "1234567";
        result = Hamming.corruptHammingBit(input, 8);
        assertEquals(null, result);
        
        /** ADD MORE TESTS BELOW **/
    }

    @Test
    void testBitCorrupt() {
        String input = "1111110";
        String answer = "1111111";
        String result = Hamming.corruptHammingBit(input, 7);
        assertEquals(answer, result);

        input = "1010101";
        answer = "1010001";
        result = Hamming.corruptHammingBit(input, 5);
        assertEquals(answer, result);
        
        /** ADD MORE TESTS BELOW **/
    }

}
