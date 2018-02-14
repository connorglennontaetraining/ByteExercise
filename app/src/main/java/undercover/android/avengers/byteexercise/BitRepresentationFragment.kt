package undercover.android.avengers.byteexercise

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BitRepresentationFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [BitRepresentationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BitRepresentationFragment : Fragment() {

    private var valueA: String = ""
    private var valueB: String = ""

    @BindView(R.id.bit_representation_tv_input_a)
    private var inputATextView: TextView? = null
    @BindView(R.id.bit_representation_tv_input_b)
    private var inputBTextView: TextView? = null
    @BindView(R.id.bit_representation_tv_combined_input)
    private var combinedInputTextView: TextView? = null

    private var unbinder: Unbinder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            valueA = arguments.getString(ARG_VALUE_A)
            valueB = arguments.getString(ARG_VALUE_B)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_bit_representation, container, false)
        unbinder = ButterKnife.bind(this, view)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setInputA(valueA)
        setInputB(valueB)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        unbinder!!.unbind()
    }

    fun setInputA(value: String){
        this.inputATextView!!.text = value
        this.updateCombinedValue()
    }

    fun setInputB(value: String){
        this.inputBTextView!!.text = value
        this.updateCombinedValue()
    }

    fun updateCombinedValue(){
        this.combinedInputTextView!!.text =
                getString(R.string.combined_bit_representation, valueA, valueB)
    }
    companion object {
        private val ARG_VALUE_A = "param1"
        private val ARG_VALUE_B = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Value A.
         * @param param2 Value B.
         * @return A new instance of fragment BitRepresentationFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String, param2: String): BitRepresentationFragment {
            val fragment = BitRepresentationFragment()
            val args = Bundle()
            args.putString(ARG_VALUE_A, param1)
            args.putString(ARG_VALUE_B, param2)
            fragment.arguments = args
            return fragment
        }
    }
}
