package undercover.android.avengers.byteexercise;

/**
 * Created by Connor Glennon on 09/02/2018.
 * Code belongs to The App Experts.
 * Do not use/copy/redistribute unless you have been given permission to do so.
 */

public class ByteUtils {
    public static byte[] extractBits(byte subject) {
        byte[] bits = new byte[8];
        for(int i = 0; i < bits.length; i++) {
            byte currentBit = (byte) (subject & 1);
            if(currentBit != 0) bits[i] = 1;
            subject >>= (byte) 1;
        }
        return bits;
    }

    public static byte[] combineByteArrays(byte[] a, byte[] b){
        byte[] statusArray = new byte[a.length + b.length];
        for(int i = 0; i < a.length; i++) {
            statusArray[i] = a[i];
        }
        for (int i = 0; i < b.length; i++){
            statusArray[a.length + i] = b[i];
        }
        return statusArray;
    }
}
