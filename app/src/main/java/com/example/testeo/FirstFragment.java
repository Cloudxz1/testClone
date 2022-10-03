package com.example.testeo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.testeo.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    private EditText num_1, num_2, respuesta;

    private RadioButton rad_sum, rad_res, rad_mul, rad_div;

    private CheckBox box_sum, box_res, box_mul, box_div;

    private RadioGroup rad_group;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        num_1 = (EditText) binding.num1;
        num_2 = (EditText) binding.num2;
        respuesta = (EditText) binding.txtRespuesta;
        rad_sum = (RadioButton) binding.radSum;
        rad_res = (RadioButton) binding.radRes;
        rad_mul = (RadioButton) binding.radMul;
        rad_div = (RadioButton) binding.radDiv;
        rad_group = (RadioGroup) binding.radGroup;
        box_sum = (CheckBox) binding.boxSum;
        box_res = (CheckBox) binding.boxRes;
        box_mul = (CheckBox) binding.boxMul;
        box_div = (CheckBox) binding.boxDiv;
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
        binding.previous1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_thirdFragment);
            }
        });

        binding.boxSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rad_group.clearCheck();
            }
        });
        binding.boxRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rad_group.clearCheck();
            }
        });
        binding.boxMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rad_group.clearCheck();
            }
        });
        binding.boxDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rad_group.clearCheck();
            }
        });

        binding.radSum.setOnClickListener((View v) -> {
            desactivar();
        });
        binding.radRes.setOnClickListener((View v) -> {
            desactivar();
        });
        binding.radMul.setOnClickListener((View v) -> {
            desactivar();
        });
        binding.radDiv.setOnClickListener((View v) -> {
            desactivar();
        });

        binding.btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resultado = "";

                if (box_sum.isChecked()) {
                    resultado = "sum:"+suma();
                }
                if (box_res.isChecked()) {
                    resultado = resultado + " resta:"+ resta();
                }
                if (box_mul.isChecked()) {
                    resultado = resultado + " mul:" + multiplicacion();
                }
                if (box_div.isChecked()) {
                    resultado = resultado + " div:"+ division();
                }
                respuesta.setText(String.valueOf(resultado));

                if (rad_sum.isChecked()) {
                    suma();

                } else if (rad_res.isChecked()) {
                    resta();

                } else if (rad_mul.isChecked()) {
                    multiplicacion();

                } else if (rad_div.isChecked()) {
                    division();

                } else {
                    if(!box_sum.isChecked() && !box_res.isChecked() && !box_mul.isChecked() && !box_div.isChecked()){
                        Toast.makeText(getContext(), "No se ha seleccionado ninguna operación", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    public void desactivar(){
        box_sum.setChecked(false);
        box_res.setChecked(false);
        box_mul.setChecked(false);
        box_div.setChecked(false);
    }


    public String suma() {
        double num1 = Double.parseDouble(num_1.getText().toString());
        double num2 = Double.parseDouble(num_2.getText().toString());
        double resultado = num1 + num2;
        respuesta.setText(String.valueOf(resultado));
        return String.valueOf(resultado);
    }

    public String resta() {
        double num1 = Double.parseDouble(num_1.getText().toString());
        double num2 = Double.parseDouble(num_2.getText().toString());
        double resultado = num1 - num2;
        respuesta.setText(String.valueOf(resultado));
        return String.valueOf(resultado);
    }

    public String division() {
        double num1 = Double.parseDouble(num_1.getText().toString());
        double num2 = Double.parseDouble(num_2.getText().toString());
        double resultado = num1 / num2;
        respuesta.setText(String.valueOf(resultado));
        return String.valueOf(resultado);
    }

    public String multiplicacion() {
        double num1 = Double.parseDouble(num_1.getText().toString());
        double num2 = Double.parseDouble(num_2.getText().toString());
        double resultado = num1 * num2;
        respuesta.setText(String.valueOf(resultado));
        return String.valueOf(resultado);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}