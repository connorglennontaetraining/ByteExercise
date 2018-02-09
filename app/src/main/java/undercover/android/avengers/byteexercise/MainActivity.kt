package undercover.android.avengers.byteexercise

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val exercise = Exercise(64, 0)
        val connectionStatus = exercise.status
        Log.i(this.javaClass.simpleName, "" + connectionStatus.printString())
    }
}
