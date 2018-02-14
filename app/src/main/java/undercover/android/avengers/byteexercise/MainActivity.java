package undercover.android.avengers.byteexercise;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Connor Glennon on 09/02/2018.
 * Code belongs to The App Experts.
 * Do not use/copy/redistribute unless you have been given permission to do so.
 */

public class MainActivity extends AppCompatActivity {

    public static final int MAX_INPUT = 255;

    private LabelledSeekBarFragment inputA, inputB;
    private BitRepresentationFragment bitRepresentationFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int initialMaxValueA = 128;
        int initialMaxValueB = MAX_INPUT - initialMaxValueA;

        inputA = LabelledSeekBarFragment.
                Companion.newInstance("Byte 1", "" + initialMaxValueA);

        inputB = LabelledSeekBarFragment.
                Companion.newInstance("Byte 2", "" + initialMaxValueB);
    }
}
