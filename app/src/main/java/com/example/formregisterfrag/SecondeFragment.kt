package com.example.formregisterfrag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
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
        var fullNameBtn =  binding.fullnamebox
        var userNameBtn = binding.usernamebox
        var emailBtn = binding.emailbox
        var passWordBtn = binding.passwordbox
        var genderBtn = binding.genderbox
        var saveBtn = binding.savebox
    }
}