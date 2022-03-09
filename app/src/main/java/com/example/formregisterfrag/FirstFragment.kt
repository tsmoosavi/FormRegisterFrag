package com.example.formregisterfrag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.os.bundleOf
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

        buttonClickListener()
    }

    private fun buttonClickListener() {
       binding.register.setOnClickListener{
           if (isfielsFullAndCorrect() && passWordCheck()){
               sendInfo()

           }
       }
    }

    fun isfielsFullAndCorrect():Boolean{
        if (  binding.fullName.text.isNullOrBlank()){
            binding.fullName.error = "این فیلد را پر کنید."
            return false
        }
        if(binding.userName.text.isNullOrBlank()){
            binding.userName.error = "این فیلد را پر کنید."
            return false
        }
        if(binding.email.text.isNullOrBlank()){
            binding.email.error = "این فیلد را پر کنید."
            return false
        }
        if (binding.password.text.isNullOrBlank()){
            binding.password.error = "این فیلد را پر کنید."
            return false
        }
        if (binding.reTypePassword.text.isNullOrBlank()){
            binding.reTypePassword.error = "این فیلد را پر کنید."
            return false
        }
        if (!genderCheck()){
            Toast.makeText(context, "جنسیت را وارد کنید", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
    fun passWordCheck():Boolean{
       if(binding.password.text.toString() == binding.reTypePassword.text.toString()){
           return true
       }
        binding.reTypePassword.error = "پسورد ها همخوانی ندارند."
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


//    fun genderCheck1():Boolean{
//        val gender = when(binding.genderRadio.checkedRadioButtonId){
//            binding.radioButton.id -> "Female"
//            binding.radioButton2.id -> "Male"
//            else -> "not chosen yet"
//        }
//        if (gender == "not chosen yet"){
//            return false
//        }
//        return true
//    }



    private fun sendInfo() {
        var fullNameTxv = binding.fullName.text.toString()
        var userNameTxv = binding.userName.text.toString()
        var emailTxv = binding.email.text.toString()
        var passWordTxv = binding.password.text.toString()
        var gender = when(binding.genderRadio.checkedRadioButtonId){
            binding.radioButton.id -> "زن"
            binding.radioButton2.id -> "مرد"
            else -> "not chosen yet"
        }
        var bundle = bundleOf("name" to fullNameTxv,
                                "username" to userNameTxv,
                                "email" to emailTxv,
                                "password" to passWordTxv,
                                "gender" to gender)
        findNavController().navigate(R.id.action_firstFragment_to_secondeFragment,bundle)
    }

}