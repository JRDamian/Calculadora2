package com.e.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {
    TextView catchnro1, catchnro2, texto, resultado;
    Button nuevoCalculo;
    Double n1, n2, r;
    String operacion = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        catchnro1 = findViewById(R.id.TV1);
        catchnro2 = findViewById(R.id.TV2);
        texto = findViewById(R.id.TV3);
        resultado = findViewById(R.id.TV4);
        nuevoCalculo = findViewById(R.id.btnRecalcular);

        n1 = Double.valueOf(getIntent().getExtras().getString("numero1"));
        n2 = Double.valueOf(getIntent().getExtras().getString("numero2"));
        catchnro1.setText("El primer número ingresado es: "+n1);
        catchnro2.setText("y el segundo es: "+n2);
        operacion = getIntent().getExtras().getString("operacion");
        switch (operacion){
            case "Suma":
                r=n1+n2;
                break;
            case "Resta":
                r=n1-n2;
                break;
            case "Multiplicación":
                r=n1*n2;
                break;
            case "División":

                r=n1/n2;
                break;
        }
        texto.setText("La "+operacion+" es igual a: ");
        resultado.setText(String.valueOf(r));

        nuevoCalculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}