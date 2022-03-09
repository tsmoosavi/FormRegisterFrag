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
import androidx.navigation.fragment.findNavController
import com.example.formregisterfrag.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    lateinit var binding :FragmentFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        buttonClickListener()
    }

    private fun buttonClickListener() {
       binding.register.setOnClickListener{
           if (isfielsFullAndCorrect()&&passWordCheck()){
               findNavController().navigate(R.id.action_firstFragment_to_secondeFragment)
           }
       }
    }

    fun isfielsFullAndCorrect():Boolean{
        if (  binding.fullName.text.isNullOrBlank()){
            binding.fullName.error = "این فیلد را پر کنید."
            return false
        }
        if(binding.userName.text.isNotBlank()){
            binding.userName.error = "این فیلد را پر کنید."
            return false
        }
        if(binding.email.text.isNotBlank()){
            binding.email.error = "این فیلد را پر کنید."
            return false
        }
        if (binding.password.text.isNotBlank()){
            binding.password.error = "این فیلد را پر کنید."
            return false
        }
        if (binding.reTypePassword.text.isNotBlank()){
            binding.reTypePassword.error = "این فیلد را پر کنید."
            return false
        }
        if (!genderCheck()){
            return false
        }
        return true
    }
    fun passWordCheck():Boolean{
       if(binding.password.text == binding.reTypePassword.text){
           return true
       }
        return false
    }
    fun genderCheck():Boolean{
        val gender = when(binding.genderRadio.checkedRadioButtonId){
            binding.radioButton.id -> "Female"
            binding.radioButton2.id -> "Male"
            else -> "not chosen yet"
        }
        return gender != "not chosen yet"
    }


    private fun initView() {
        var fullNameTxv = binding.fullName.text
        var userNameTxv = binding.userName.text
        var emailTxv = binding.email.text
        var passWordTxv = binding.password.text
        var reTypePassWordTxv = binding.reTypePassword.text
        var gender = when(binding.genderRadio.checkedRadioButtonId){
            binding.radioButton.id -> "زن"
            binding.radioButton2.id -> "مرد"
            else -> "not chosen yet"
        }
    }

}