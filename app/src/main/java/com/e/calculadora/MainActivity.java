package com.e.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nro1, nro2;
    RadioButton rBSuma, rBResta, rBMultiplicacion, rBDivision;
    Button btnCalcular;
    String operacion = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nro1 = findViewById(R.id.eTN1);
        nro2 = findViewById(R.id.eTN2);
        rBSuma = findViewById(R.id.rBSuma);
        rBResta = findViewById(R.id.rBResta);
        rBMultiplicacion = findViewById(R.id.rBMultiplicacion);
        rBDivision = findViewById(R.id.rBDivision);
        btnCalcular = findViewById(R.id.btnCalcular);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nro1.getText().toString().length() < 1) {
                    Toast.makeText(getApplicationContext(), "Ingrese un operador en el primer campo", Toast.LENGTH_LONG).show();

                } else if (nro2.getText().toString().length() < 1) {
                    Toast.makeText(getApplicationContext(), "Ingrese un operador en el segundo campo", Toast.LENGTH_LONG).show();
                } else {
                    if (rBSuma.isChecked()) {
                        operacion = "Suma";
                    }
                    if (rBResta.isChecked()) {
                        operacion = "Resta";
                    }
                    if (rBMultiplicacion.isChecked()) {
                        operacion = "Multiplicación";
                    }
                    if (rBDivision.isChecked()) {
                        operacion = "División";
                    }

                    Intent i = new Intent(getApplicationContext(), Resultado.class);
                    i.putExtra("numero1",nro1.getText().toString());
                    i.putExtra("numero2",nro2.getText().toString());
                    i.putExtra("operacion",operacion);
                    startActivity(i);
                }

            }


        });
    }
}
