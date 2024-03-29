package com.wiquert.catcalories.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.wiquert.catcalories.R
import com.wiquert.catcalories.databinding.FragmentCalcBinding
import com.wiquert.catcalories.dataclass.CalcCoefficientData


class CalcFragment : Fragment() {

    private lateinit var coefSpinner : Spinner
    private lateinit var spinnerAdapter: ArrayAdapter<CalcCoefficientData>
    private lateinit var binding: FragmentCalcBinding
    var coefResult : Double = 0.0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalcBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        coefSpinner = binding.coefSpinner
        val coefObjects = getCoefficientObjects()
        spinnerAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, coefObjects)
        coefSpinner.adapter = spinnerAdapter

    coefSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            val selectedCoef = coefSpinner.selectedItem as CalcCoefficientData
            coefResult = selectedCoef.coefficient
        }

        override fun onNothingSelected(p0: AdapterView<*>?) { }
    }

        binding.bResult.setOnClickListener {
            if (!isFieldEmpty()) {
                getResult()
                binding.tvResult.visibility = View.VISIBLE
                val tvResultInfo = getString(R.string.fragment_calc_result_info) + getResult() + getString(R.string.fragment_calc_result_kcal)
                binding.tvResult.text = tvResultInfo
            }
        }
    }

    private fun getCoefficientObjects() : ArrayList<CalcCoefficientData> {
        val coefficientObjects = ArrayList<CalcCoefficientData>()
        coefficientObjects.apply {
            add(CalcCoefficientData(1.2, getString(R.string.fragment_calc_vzr_kastr)))
            add(CalcCoefficientData(1.4, getString(R.string.fragment_calc_vzr)))
            add(CalcCoefficientData(1.6, getString(R.string.fragment_calc_akt_vzr)))
            add(CalcCoefficientData(1.0, getString(R.string.fragment_calc_pereedanie)))
            add(CalcCoefficientData(0.8, getString(R.string.fragment_calc_snizhenie)))
            add(CalcCoefficientData(1.0, getString(R.string.fragment_calc_bolezn)))
            add(CalcCoefficientData(1.2, getString(R.string.fragment_calc_nabor)))
            add(CalcCoefficientData(1.3, getString(R.string.fragment_calc_rost)))
        }
        return coefficientObjects
    }




    fun isFieldEmpty() : Boolean {
        binding.apply {
            if (edtextKilos.text.isNullOrEmpty()) edtextKilos.error = getString(R.string.fragment_calc_error)
            return edtextKilos.text.isNullOrEmpty()
        }
    }


    private fun getResult(): String {
        val catWeight = binding.edtextKilos.text.toString().toDouble()
        return (coefResult * (30 * catWeight + 70)).toString()
    }

    companion object {

        @JvmStatic
        fun newInstance() = CalcFragment()

    }
}