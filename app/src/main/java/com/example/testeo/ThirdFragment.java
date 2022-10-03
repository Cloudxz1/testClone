package com.example.testeo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.testeo.databinding.FragmentSecondBinding;
import com.example.testeo.databinding.FragmentThirdBinding;

import org.w3c.dom.Text;


public class ThirdFragment extends Fragment {

    private FragmentThirdBinding binding;
    private EditText txt_email;


    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {


        binding = FragmentThirdBinding.inflate(inflater, container, false);
        txt_email = (EditText) binding.txtEmail;

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SharedPreferences sh = getActivity().getSharedPreferences("a", Context.MODE_PRIVATE);
        String email = sh.getString("email", "empty");
        txt_email.setText(email);

        binding.siguiente3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ThirdFragment.this)
                        .navigate(R.id.action_thirdFragment_to_FirstFragment);
            }
        });
        binding.atras3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ThirdFragment.this)
                        .navigate(R.id.action_thirdFragment_to_SecondFragment);
            }
        });

        binding.btnSave.setOnClickListener((View V) -> {
            save();
        });

    }

    public void save() {
        SharedPreferences sh = getActivity().getSharedPreferences("a", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sh.edit();
        editor.putString("email", txt_email.getText().toString());
        editor.commit();
        getActivity().finish();
    }
}

