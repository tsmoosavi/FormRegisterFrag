package com.example.formregisterfrag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import com.google.android.material.button.MaterialButton


class SecondeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_seconde, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
        super.onViewCreated(view, savedInstanceState)
    }
    private fun initView() {
        var fullNameBtn = view?.findViewById<MaterialButton>(R.id.fullnamebox)
        var userNameBtn = view?.findViewById<MaterialButton>(R.id.usernamebox)
        var emailBtn = view?.findViewById<MaterialButton>(R.id.emailbox)
        var passWordBtn = view?.findViewById<MaterialButton>(R.id.passwordbox)
        var genderBtn = view?.findViewById<MaterialButton>(R.id.genderbox)
        var saveBtn = view?.findViewById<MaterialButton>(R.id.savebox)
    }
}