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
import androidx.navigation.fragment.navArgs
import com.example.formregisterfrag.databinding.FragmentSecondeBinding
import com.google.android.material.button.MaterialButton


class SecondeFragment : Fragment() {
    lateinit var binding: FragmentSecondeBinding
    val args: SecondeFragmentArgs by navArgs()
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
         binding.fullnamebox.text = args.name
         binding.usernamebox.text = args.userName
         binding.emailbox.text = args.email
         binding.passwordbox.text = args.passWord
         binding.genderbox.text = args.gender
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
        editor.putString("savedmail",binding.emailbox.text.toString())
        editor.putString("savedpassword",binding.passwordbox.text.toString())
        editor.putString("savedgender",binding.genderbox.text.toString())
        editor.apply()
    }
}