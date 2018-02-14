package undercover.android.avengers.byteexercise

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [LabelledSeekBarFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [LabelledSeekBarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LabelledSeekBarFragment : Fragment() {

    private var labelText: String? = null
    private var initialMaxSeekBarValue: String? = null

    private var onSeekBarChangedListener: OnSeekBarChangedListener? = null

    @BindView(R.id.labelled_seek_bar_tv_label)
    private var labelTextView: TextView? = null
    @BindView(R.id.labelled_seek_bar_tv_seek_bar_value)
    private var valueTextView: TextView? = null
    @BindView(R.id.labelled_seek_bar_sb)
    private var seekBar: SeekBar? = null

    private var unbinder: Unbinder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null) {
            labelText = arguments.getString(LABEL_TEXT)
            initialMaxSeekBarValue = arguments.getString(INITIAL_MAX_SEEKBAR_VALUE)
        }

        labelTextView!!.text = labelText
        valueTextView!!.text = initialMaxSeekBarValue
        seekBar!!.max = initialMaxSeekBarValue!!.toInt()
        seekBar!!.progress = initialMaxSeekBarValue!!.toInt()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_labelled_seek_bar, container, false)
        ButterKnife.bind(this, view)
        return  view
    }

    fun onSeekBarChanged(seekBarCurrentValue: Int) {
        if (onSeekBarChangedListener != null) {
            onSeekBarChangedListener!!.onSeekBarChanged(seekBarCurrentValue)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnSeekBarChangedListener) {
            onSeekBarChangedListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnSeekBarChangedListener.")
        }
    }

    override fun onDetach() {
        super.onDetach()
        onSeekBarChangedListener = null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if(unbinder != null){
            unbinder!!.unbind()
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface OnSeekBarChangedListener {
        fun onSeekBarChanged(currentSeekBarValue: Int)
    }

    companion object {
        private val LABEL_TEXT = "param1"
        private val INITIAL_MAX_SEEKBAR_VALUE = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param labelText The label for the seekbar,
         * this show to the user what the seek bar controls..
         * @param initialMaxSeekBarValue The maximum value the seekbar should allow,
         * when it is created.
         * @return A new instance of fragment LabelledSeekBarFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(labelText: String, initialMaxSeekBarValue: String): LabelledSeekBarFragment {
            val fragment = LabelledSeekBarFragment()
            val args = Bundle()
            args.putString(LABEL_TEXT, labelText)
            args.putString(INITIAL_MAX_SEEKBAR_VALUE, initialMaxSeekBarValue)
            fragment.arguments = args
            return fragment
        }
    }
}
