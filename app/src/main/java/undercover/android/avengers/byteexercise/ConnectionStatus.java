package undercover.android.avengers.byteexercise;

import android.support.annotation.StringDef;
import android.util.Log;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/**
 * Created by Connor Glennon on 09/02/2018.
 * Code belongs to The App Experts.
 * Do not use/copy/redistribute unless you have been given permission to do so.
 */

public class ConnectionStatus {

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({
            IDLE,
            IN_SESSION,
            UNNAMED_1,
            UNNAMED_2
    })
    public @interface SessionStatus {}
    public static final String IDLE = "Idle";
    public static final String IN_SESSION = "Idle";
    public static final String UNNAMED_1 = "Idle";
    public static final String UNNAMED_2 = "Idle";

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({
            IDLE,
            IN_SESSION,
            UNNAMED_1,
            UNNAMED_2
    })
    public @interface RunProfile {}
    public static final String QUICK_RUN = "Quick run";
    public static final String OTHER = "Other";

    private byte[] sixteenBits = null;

    ConnectionStatus(byte[] sixteenBits){
        this.sixteenBits = sixteenBits;
    }

    private String getRunProfile() {
        switch(concatBytes(Arrays.copyOfRange(sixteenBits, 6, 10))){
            case 1:
                return QUICK_RUN;
            default:
                return OTHER;
        }
    }

    private String getSessionStatus() {
        switch(concatBytes(Arrays.copyOfRange(sixteenBits, 3, 5))){
            case 0:
                return IDLE;
            case 1:
                return IN_SESSION;
            case 2:
                return UNNAMED_1;
            case 3:
                return UNNAMED_2;
            default:
                return UNNAMED_1;
        }
    }

    private byte concatBytes(byte[] array){
        byte result = 0;
        for(int i = 0; i < array.length; i++){
            result += array[i] * Math.pow(2, i);
        }
        return result;
    }

    private boolean getHrmStatus() {
        return sixteenBits[2] == 1;
    }

    private boolean getGpsStatus() {
        return sixteenBits[1] == 1;
    }

    private boolean getPuckStatus() {
        return sixteenBits[0] == 1;
    }

    public String printString() {
        return "Slave Puck Connected: " + getPuckStatus() +
                "\n GPS Connected: " + getGpsStatus() +
                "\n HRM connected: " + getHrmStatus() +
                "\n Session Status: " + getSessionStatus() +
                "\n Run Profile: " + getRunProfile();
    }
}
