package com.daya.navigation.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_flow_step_one.*

class FlowStepFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val safeArgs = arguments?.let { FlowStepFragmentArgs.fromBundle(it) } ?: return null
        val flowStepNumber = safeArgs.flowStepNumber

        // Inflate the layout for this fragment
        return when(flowStepNumber) {
            2 -> inflater.inflate(R.layout.fragment_flow_step_two, container, false)
            else -> inflater.inflate(R.layout.fragment_flow_step_one, container, false)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        next_button.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.next_action)
        )
    }
}
