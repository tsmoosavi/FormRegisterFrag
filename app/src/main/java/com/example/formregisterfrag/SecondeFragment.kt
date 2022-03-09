package com.example.formregisterfrag

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.navigation.fragment.findNavController
import com.example.formregisterfrag.databinding.FragmentSecondeBinding
import com.google.android.material.button.MaterialButton


class SecondeFragment : Fragment() {
    lateinit var binding: FragmentSecondeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondeBinding.inflate(inflater,container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
        super.onViewCreated(view, savedInstanceState)
    }

     fun initView() {
       binding.fullnamebox.text = requireArguments().getString("name")
       binding.usernamebox.text =requireArguments().getString("username")
       binding.emailbox.text = requireArguments().getString( "email")
       binding.passwordbox.text = requireArguments().getString("password")
       binding.genderbox.text = requireArguments().getString("gender")
       binding.savebox.setOnClickListener{
            saveInformation()
           findNavController().navigate(R.id.action_secondeFragment_to_firstFragment)
       }
    }
    fun saveInformation(){
        var saveInfo : SharedPreferences = requireActivity().getSharedPreferences("personalInformation", Context.MODE_PRIVATE)
        var editor = saveInfo.edit()
        editor.putString("savedName",binding.fullnamebox.text.toString())
        editor.putString("savedUserName",binding.usernamebox.text.toString())
        editor.putString("savedmail",binding.usernamebox.text.toString())
        editor.putString("savedpassword",binding.usernamebox.text.toString())
        editor.putString("savedgender",binding.usernamebox.text.toString())
        editor.apply()
    }
}