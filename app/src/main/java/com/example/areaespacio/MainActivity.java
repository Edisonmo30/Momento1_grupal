package com.example.areaespacio;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText areaEspacio, baseEspacio, alturaBaldosa, baseBaldosa;

    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        areaEspacio = findViewById(R.id.areaEspacio);
        baseEspacio = findViewById(R.id.baseEspacio);
        alturaBaldosa = findViewById(R.id.alturaBaldosa);
        baseBaldosa = findViewById(R.id.baseBaldosa);
        resultado = findViewById(R.id.resultado);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    @SuppressLint("SetTextI18n")
    public void btncalcular(View view){
         double espacioA = Double.parseDouble(areaEspacio.getText().toString());
         double espacioB = Double.parseDouble(baseEspacio.getText().toString());
         double baldosaA = Double.parseDouble(alturaBaldosa.getText().toString());
         double baldosaB= Double.parseDouble(baseBaldosa.getText().toString());

         double areaTotalEspacio = espacioA * espacioB;
         double areaTotalBaldosa = (baldosaA/100) * (baldosaB/100);
         double areaTotal = areaTotalEspacio/areaTotalBaldosa;
         Toast.makeText(this, "Cálculo exitoso", Toast.LENGTH_LONG).show();
         String areaEspacioFinal = Double.toString(areaTotal);
         String totalEspacio = Double.toString(areaTotalEspacio);
         resultado.setText("El áre de tu espacio es: " + totalEspacio +
                  "metros cuadrados, y la cantidad de baldosas que necesitas para cubrir el área son:  " + areaEspacioFinal);

    }
}