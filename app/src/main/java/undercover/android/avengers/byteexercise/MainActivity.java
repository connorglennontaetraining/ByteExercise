package undercover.android.avengers.byteexercise;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Connor Glennon on 09/02/2018.
 * Code belongs to The App Experts.
 * Do not use/copy/redistribute unless you have been given permission to do so.
 */

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Exercise exercise = new Exercise((byte) 64, (byte) 0);
        Log.i(this.getClass().getSimpleName(), exercise.getStatus().printString());
    }
}
