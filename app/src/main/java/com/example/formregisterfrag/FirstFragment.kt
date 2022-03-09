package com.example.formregisterfrag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class FirstFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        var fullNameTxv = view?.findViewById<EditText>(R.id.FullName)
        var userNameTxv = view?.findViewById<EditText>(R.id.userName)
        var emailTxv = view?.findViewById<EditText>(R.id.email)
        var passWordTxv = view?.findViewById<EditText>(R.id.password)
        var reTypePassWordTxv = view?.findViewById<EditText>(R.id.reTypePassword)
        var gender = when(view?.findViewById<RadioGroup>(R.id.genderRadio)?.checkedRadioButtonId){
            view?.findViewById<RadioButton>(R.id.radioButton)?.id -> "زن"
            view?.findViewById<RadioButton>(R.id.radioButton2)?.id -> "مرد"
            else -> "not chosen yet"
        }
    }

}