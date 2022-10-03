package com.example.testeo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.testeo.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    private EditText txt_num1, txt_num2, txt_resultado;

    private Spinner sp_operations;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);

        txt_num1= (EditText) binding.txtNum1;
        txt_num2= (EditText) binding.txtNum2;
        txt_resultado= (EditText) binding.txtResultado;
        sp_operations= (Spinner) binding.spOp;

        String[] operations = {"Suma", "Resta", "Multiplicación", "División"};
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this.getContext(), R.layout.spinner_item1, operations);
        sp_operations.setAdapter(adapter);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
        binding.next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_thirdFragment);
            }
        });

        binding.btnCal.setOnClickListener((View v) ->{
            String selected = sp_operations.getSelectedItem().toString();
            if(txt_num1.getText().toString().isEmpty() || txt_num2.getText().toString().isEmpty()){
                Toast.makeText(this.getContext(), "Debe ingresar los dos números", Toast.LENGTH_SHORT).show();
            }else{
                switch (selected){
                    case "Suma":
                        suma();
                        break;
                    case "Resta":
                        resta();
                        break;
                    case "Multiplicación":
                        multiplicacion();
                        break;
                    case "División":
                        division();
                        break;
                    default:{
                        Toast.makeText(getContext(), "No se ha seleccionado ninguna operación", Toast.LENGTH_SHORT).show();
                    }

                }
            }

        });
    }

    public String suma() {
        double num1 = Double.parseDouble(txt_num1.getText().toString());
        double num2 = Double.parseDouble(txt_num2.getText().toString());
        double resultado = num1 + num2;
        txt_resultado.setText(String.valueOf(resultado));
        return String.valueOf(resultado);
    }

    public String resta() {
        double num1 = Double.parseDouble(txt_num1.getText().toString());
        double num2 = Double.parseDouble(txt_num2.getText().toString());
        double resultado = num1 - num2;
        txt_resultado.setText(String.valueOf(resultado));
        return String.valueOf(resultado);
    }

    public String division() {
        double num1 = Double.parseDouble(txt_num1.getText().toString());
        double num2 = Double.parseDouble(txt_num2.getText().toString());
        double resultado = num1 / num2;
        txt_resultado.setText(String.valueOf(resultado));
        return String.valueOf(resultado);
    }

    public String multiplicacion() {
        double num1 = Double.parseDouble(txt_num1.getText().toString());
        double num2 = Double.parseDouble(txt_num2.getText().toString());
        double resultado = num1 * num2;
        txt_resultado.setText(String.valueOf(resultado));
        return String.valueOf(resultado);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}