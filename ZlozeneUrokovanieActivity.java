package com.example.finannkalkulaka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class ZlozeneUrokovanieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zlozene_urokovanie);

        Button vypocitajButton = (Button) findViewById(R.id.vypocitajButton);
        vypocitajButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText ktEditText =(EditText) findViewById(R.id.ktEditText);
                EditText k0EditText = (EditText) findViewById(R.id.k0EditText);
                EditText pEditText = (EditText) findViewById(R.id.pEditText);
                EditText tEditText = (EditText) findViewById(R.id.tEditText);
                RadioButton rokRadioButton = (RadioButton) findViewById(R.id.rokRadioButton);
                RadioButton mesiacRadioButton = (RadioButton) findViewById(R.id.mesiacRadioButton);
                RadioButton denRadioButton = (RadioButton) findViewById(R.id.denRadioButton);

                if (k0EditText.length() == 0) {
                    Toast.makeText(ZlozeneUrokovanieActivity.this, "Musíš zadať nejakú hodnotu!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (pEditText.length() == 0) {
                    Toast.makeText(ZlozeneUrokovanieActivity.this, "Musíš zadať nejakú hodnotu!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (tEditText.length() == 0) {
                    Toast.makeText(ZlozeneUrokovanieActivity.this, "Musíš zadať nejakú hodnotu!", Toast.LENGTH_SHORT).show();
                    return;
                }

                int k0 = Integer.parseInt(k0EditText.getText().toString());
                float p = Float.parseFloat(pEditText.getText().toString());
                int t = Integer.parseInt(tEditText.getText().toString());

                if (rokRadioButton.isChecked()){
                    float vysledok = k0 * Math.pow(1 + p / 100, t);
                    }
                }
                if (mesiacRadioButton.isChecked()){
                    float vysledok = k0 * Math.pow(1 + p / 100 / 12, 12 * t);
                    }
                }
                if (denRadioButton.isChecked()){
                    float vysledok = k0 * Math.pow(1 + p / 100 / 365, 365 * t);
                    }
                    ktEditText.setText(vysledok + "");

                }
            }
        });
    }
}
