package com.example.correctweight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText boy= findViewById(R.id.editTextBoy);
        final EditText kilo = findViewById(R.id.editTextKilo);
        final Button hesapla = findViewById(R.id.buttonHesapla);

        hesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double boynumber =  Double.parseDouble(boy.getText().toString())/100;
                double kilonumber = Double.parseDouble(kilo.getText().toString());
                final double sonuc = kilonumber/(boynumber*boynumber);
                if(sonuc<18.5)
                {
                    new SweetAlertDialog(MainActivity.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                            .setTitleText("Ölçüm tamamlandı")
                            .setContentText("Olması gerekenden zayıfsınız. Kilo almanız gerekiyor.")
                            .setConfirmText("Teşekkürler")
                            .setCustomImage(R.drawable.sad)
                            .show();
                }
                if(sonuc>25)
                {
                    new SweetAlertDialog(MainActivity.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                            .setTitleText("Ölçüm tamamlandı")

                            .setContentText("Fazla kilonuz var kilo vermeniz gerekiyor.")
                            .setConfirmText("Teşekkürler")
                            .setCustomImage(R.drawable.sad)
                            .show();
                }
                if(18.5<sonuc && 25>sonuc )
                {
                    new SweetAlertDialog(MainActivity.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                            .setTitleText("Ölçüm tamamlandı")
                            .setContentText("Kilonuz idealdir." )
                            .setConfirmText("Teşekkürler")
                            .setCustomImage(R.drawable.smile)
                            .show();
                }


            }
        });
    }
}
