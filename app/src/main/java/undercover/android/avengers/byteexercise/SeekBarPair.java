package undercover.android.avengers.byteexercise;

import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * Created by Connor Glennon on 12/02/2018.
 * Code belongs to The App Experts.
 * Do not use/copy/redistribute unless you have been given permission to do so.
 */

public class SeekBarPair {
    private SeekBar seekBarA;
    private SeekBar seekBarB;

    List<Observer> seekBarAObservers;
    List<Observer> seekBarBObservers;

    public SeekBarPair(SeekBar seekBarA, SeekBar seekBarB){
        this.seekBarA = seekBarA;
        this.seekBarB = seekBarB;

        seekBarAObservers = new ArrayList<>();
        seekBarBObservers = new ArrayList<>();

        seekBarA.setOnSeekBarChangeListener(new OnSeekPairListener(seekBarB, 255));
        seekBarB.setOnSeekBarChangeListener(new OnSeekPairListener(seekBarA, 255));
    }

    public void addAObserver(Observer aObserver){
        this.seekBarAObservers.add(aObserver);
    }

    public void addBObserver(Observer bObserver){
        this.seekBarBObservers.add(bObserver);
    }

    private class OnSeekPairListener implements SeekBar.OnSeekBarChangeListener{
        private SeekBar pairedSeekBar;
        private int maxCombinedValue;

        public OnSeekPairListener(SeekBar pairedSeekBar, int maxCombinedValue){
            this.pairedSeekBar = pairedSeekBar;
            this.maxCombinedValue = maxCombinedValue;
        }

        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            pairedSeekBar.setMax(maxCombinedValue - i);

            for(Observer observer: seekBarAObservers){
                observer.update(null, 0);
            }
            for(Observer observer: seekBarBObservers){
                observer.update(null, 0);
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }
}
